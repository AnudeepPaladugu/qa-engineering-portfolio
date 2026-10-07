# QA Engineering Portfolio

A staged QA/SDET portfolio for [Automation Exercise](https://automationexercise.com), maintained by Anudeep Paladugu.

## Current status

**In progress — no automation or CI pass claims.** Application discovery is underway. The public home, login, product catalog, product detail, cart, API documentation and test-case pages returned HTTP 200 during inspection on 7 October 2026. Fetching a page is not proof that its interactive workflow passes.

The intended stack is Java 21, Selenium WebDriver, TestNG, Maven, Postman and Allure, with a Jenkins pipeline definition. Each completed stage will be committed before the next begins.

## Delivery stages

1. Inspect application behavior and record scope and limitations.
2. Define traceable requirements, risks, strategy, plan and detailed cases.
3. Build and validate UI/API automation and evidence capture.
4. Execute tests, report actual outcomes and reproducible defects.
5. Verify CI, artifacts, reproduction instructions and final repository audit.

No results, defects, coverage percentages or release approval will be invented. Unexecuted cases remain NOT EXECUTED. Public database access has not been provided; database validation will be documented as an owned-environment design unless legitimate access becomes available.

## Completed stages

- Application inspection: [observed functionality and limitations](docs/00-discovery/application-inspection.md).
- Scope adjustment: [resume alignment](docs/design-decisions/resume-alignment.md).

API observations and guest cart discovery evidence are published under [evidence/discovery](evidence/discovery). Full test execution remains NOT EXECUTED.

- Java framework compiled; seven smoke cases passed with successful cleanup. [Actual smoke evidence](evidence/smoke/results.json).
- [Run instructions](docs/how-to-run.md) and [failure evidence audit](docs/architecture/evidence-audit.md).
