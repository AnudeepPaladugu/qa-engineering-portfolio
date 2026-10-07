# Run the Java UI suite

Prerequisites: Java 21, Maven 3.9+, installed Chrome, internet access to the demo and Selenium driver downloads. Run from the repository root. Versions in pom.xml are pinned; no claim is made that they are the newest releases.

PowerShell configuration:

```powershell
$env:TEST_PASSWORD='choose-a-test-only-password'
$env:GIT_COMMIT=(git rev-parse HEAD)
mvn clean test -DsuiteXmlFile=testng-smoke.xml -Dgroups=smoke
```

macOS/Linux configuration:

```sh
export TEST_PASSWORD='choose-a-test-only-password'
export GIT_COMMIT=$(git rev-parse HEAD)
mvn clean test -DsuiteXmlFile=testng-smoke.xml -Dgroups=smoke
```

The password is only used for new synthetic accounts. Do not use an existing personal password. Test setup generates the email and test cleanup deletes the account. Missing TEST_PASSWORD fails account setup rather than skipping it as passed. `.env.example` lists configuration; copying it to `.env` alone does not set process environment variables.

```sh
# Broader regression: all 20 UI cases
mvn clean test -Dgroups=regression
# One case, still using configured environment
mvn test -Dtest=PortfolioTests#cartTotal -Dgroups=regression
# Headed Chrome / failure screenshots only
mvn test -Dgroups=smoke -DHEADLESS=false -DSCREENSHOT_MODE=FAILURE
# Generate or serve Allure after a run
mvn allure:report
mvn allure:serve
```

Screenshots, result JSON and logs: artifacts/runs. Allure raw results: artifacts/allure-results. Generated report: artifacts/allure-report. Surefire reports: target/surefire-reports. Preserve or move previous Allure results before a new run if you need independent reports; `mvn clean` only removes target and does not clear artifacts. Never interpret an accumulated report as a single run without checking timestamps.

Chrome is the verified browser. No automatic retry, video capture, parallel suite, or `.env` loader is included in this simplified implementation. Keep logs/evidence when an external ad intercepts a click; do not force the click or remove page elements.
