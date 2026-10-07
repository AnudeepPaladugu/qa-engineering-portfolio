# Failure evidence audit

Executed 7 October 2026 against the rendered login page. AUDIT-001 is an intentional framework assertion failure, excluded from both application suites. Maven returned exit code 1; TestNG reported one failure. The runtime audit result is FAIL; a FAIL-named PNG, structured log, stack trace and Allure failed result were saved. This is not an application defect and is not counted in application pass percentages.

Reproduce separately:

```sh
mvn test -Dtest=EvidenceAuditTest -Dgroups=evidence-audit -Dallure.results.directory=artifacts/audit-allure-results
```

Expected: non-zero exit and a failure screenshot under artifacts/runs. Do not use this command as a release test suite. This confirms the framework preserves a real assertion failure; it does not prove every future infrastructure failure can produce a browser screenshot.
