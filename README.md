# QA Engineering Portfolio

## 👋 Start Here

This repository demonstrates an **end-to-end QA testing project** for a public e-commerce application.

### In simple terms, what did I do?

I approached the application like a QA Engineer would in a real project:

**Understand the application → identify requirements → design tests → execute tests → find defects → automate repeatable regression tests → test APIs → collect evidence → make a QA recommendation**

### Application under test

**Automation Exercise** — a public e-commerce demo application.

### What this portfolio demonstrates

| Area | What I did |
|---|---|
| Requirements Analysis | Inspected the application and identified testable functional and non-functional requirements |
| Test Planning | Defined scope, strategy, coverage and execution approach |
| Manual Testing | Designed and documented functional test cases and scenarios |
| Functional Testing | Tested authentication, catalog, cart, checkout and related user journeys |
| Negative & Boundary Testing | Checked invalid inputs and edge conditions |
| Exploratory Testing | Investigated unexpected application behaviour beyond scripted cases |
| Defect Reporting | Documented reproducible defects with expected/actual results and evidence |
| UI Automation | Automated repeatable regression checks with Java, Selenium and TestNG |
| API Testing | Created and verified API checks using Postman/Newman |
| Evidence | Captured screenshots, logs, execution records and Allure-compatible results |
| QA Assessment | Reviewed the latest results and made a release recommendation based on evidence |

---

## 📊 Latest Test Results

The latest documented execution was performed on **7 October 2026** against the shared public demo using Chrome on Windows.

| Test Area | Passed | Failed |
|---|---:|---:|
| Java UI Regression | 20 | 1 |
| Postman API Verification | 9 | 0 |
| Exploratory Checks | 2 | 1 |
| **Total Case Records** | **31** | **2** |

The two failures identify the same application defect: a cart quantity of **-1** is accepted and produces a negative cart total. The automated guard correctly remains failing rather than hiding the defect.

**QA recommendation: NO-GO until the defect is fixed and retested.**

👉 [Read the final execution summary](test-documentation/execution/execution-summary.md)  
👉 [Read the defect report](test-documentation/defects/QA-PROD-001.md)  
👉 [View latest regression evidence](evidence/latest-regression/README.md)

---

## 🧭 How to Navigate This Repository

### If you are a recruiter or non-technical reviewer

Start here:

1. **[Project Overview](project-overview/01-project-overview.md)** — what the project is and what I tested
2. **[What I Tested](project-overview/02-what-i-tested.md)** — QA activities explained in plain English
3. **[Defects Found](project-overview/04-defects-found.md)** — examples of issues identified and documented
4. **[Automation Overview](project-overview/05-automation-overview.md)** — what the automation code does without requiring Selenium knowledge
5. **[Results & Conclusion](project-overview/06-results-and-conclusion.md)** — final test outcome and QA recommendation

### If you are a QA Engineer or hiring manager

Review:

- [Test Strategy](docs/03-test-strategy/test-strategy.md)
- [Test Plan](docs/04-test-plan/test-plan.md)
- [Requirement Traceability Matrix](docs/01-requirements/06-requirement-traceability-matrix.md)
- [Manual Test Cases](test-documentation/test-cases/)
- [Selenium Automation](src/)
- [Postman API Testing](api-tests/README.md)
- [Execution Evidence](evidence/)
- [Architecture](docs/architecture/architecture.md)

---

## 🗂️ Repository Guide

| Folder / File | What it means |
|---|---|
| `project-overview/` | Plain-English explanation of the project for recruiters and non-technical readers |
| `docs/` | QA analysis, requirements, strategy, planning and technical design |
| `test-documentation/` | Test scenarios, test cases, execution summaries and defect reports |
| `src/` | Java/Selenium automation source code |
| `postman/` | Postman collection and API testing material |
| `api-tests/` | API testing documentation and execution guidance |
| `test-data/` | Synthetic and boundary test data used by the project |
| `evidence/` | Curated execution results, screenshots and supporting evidence |
| `artifacts/` | Runtime/generated artifact guidance. Generated output is not treated as the primary portfolio evidence |
| `pom.xml` | Maven dependencies and test/build configuration |
| `testng-smoke.xml` | Defines the smoke test selection |
| `testng-regression.xml` | Defines the regression test selection |

---

## 🔍 Automation Code, Explained Simply

You do not need to know Java or Selenium to understand the structure.

| File / Area | Simple meaning |
|---|---|
| `src/main/java/.../drivers/Drivers.java` | Creates and manages the browser used by automation |
| `src/main/java/.../pages/` | Contains page objects that represent application pages and their UI actions |
| `BasePage.java` | Shared browser/UI behaviour used by page objects |
| `LoginPage.java` | Handles login-page interactions |
| `CatalogPage.java` | Handles product/catalog interactions |
| `CartPage.java` | Handles shopping-cart interactions |
| `CheckoutPage.java` | Handles checkout interactions |
| `PaymentPage.java` | Handles payment-page interactions |
| `ConfirmationPage.java` | Handles order confirmation interactions |
| `PortfolioTests.java` | Contains the main automated QA checks |
| `Evidence.java` | Captures structured execution evidence |
| `EvidenceListener.java` | Connects test events to evidence capture |
| `config.properties` | Stores project configuration outside the test implementation |

### Automation flow

```text
TestNG Test
    ↓
Page Object
    ↓
Selenium WebDriver
    ↓
Application
    ↓
Assertion
    ↓
Evidence / Report
```

The goal is not simply to write Selenium scripts. The framework separates **what to verify** from **how to interact with the application**, making the tests easier to maintain.

---

## 🐞 Defect Found

### QA-PROD-001 — Negative quantity accepted

The exploratory and automated testing identified a cart validation issue.

**Observed:** entering a quantity of `-1` can produce a negative cart total.

**Expected:** the application should reject quantities below 1.

**Why it matters:** incorrect quantity validation can lead to incorrect pricing information.

👉 [Open the full defect report](test-documentation/defects/QA-PROD-001.md)

This is a real finding from the documented test execution, not a theoretical example.

---

## 🧪 Testing Coverage

The project covers:

- Authentication
- Product/catalog behaviour
- Search
- Cart operations
- Checkout
- Order flow
- Negative and boundary conditions
- Exploratory testing
- API checks
- Regression automation
- Defect reporting
- Evidence and reporting

The repository contains **19 observed functional requirements**, **33 detailed test cases**, and requirement traceability connecting requirements to test coverage.

---

## 🛠️ Technology Stack

- **Java 21**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Postman / Newman**
- **Allure**
- **Git / GitHub**
- **Chrome**

---

## ▶️ Run the Project

### Prerequisites

- Java 21
- Maven 3.9+
- Google Chrome
- Internet access

Clone the repository:

```bash
git clone https://github.com/AnudeepPaladugu/qa-engineering-portfolio.git
cd qa-engineering-portfolio
```

Set a test-only password before running the UI suite:

**PowerShell**
```powershell
$env:TEST_PASSWORD='choose-a-test-only-password'
$env:GIT_COMMIT=(git rev-parse HEAD)
mvn clean test '-Dgroups=regression'
```

**macOS/Linux**
```bash
export TEST_PASSWORD='choose-a-test-only-password'
export GIT_COMMIT=$(git rev-parse HEAD)
mvn clean test -Dgroups=regression
```

The current regression is expected to return a non-zero result because the automated guard correctly exposes the open application defect.

For more detail, see [How to Run](docs/how-to-run.md).

---

## 📁 Detailed Documentation

- [Application Discovery](docs/00-discovery/application-inspection.md)
- [Requirements](docs/01-requirements/)
- [Requirements Analysis](docs/02-analysis/requirements-analysis.md)
- [Test Strategy](docs/03-test-strategy/test-strategy.md)
- [Test Plan](docs/04-test-plan/test-plan.md)
- [Architecture](docs/architecture/architecture.md)
- [QA Approach](docs/qa-approach/qa-approach.md)
- [Interview Walkthrough](docs/qa-approach/interview-walkthrough.md)
- [Database Validation Design](docs/database/database-validation-design.md) — design only; not executed because the public database is unavailable
- [Final Audit](docs/final-audit.md)

---

## ⚠️ Project Scope & Limitations

This is a portfolio project using a public third-party demo application.

- Database execution was not performed because the application's database is not publicly available.
- Jenkins/CI execution was intentionally deferred.
- Tests use synthetic data.
- Only Chrome on Windows was verified for the documented latest run.
- The application is external to this repository, so application defects cannot be fixed from this project.
- Historical evidence is retained where useful and is clearly separated from the latest documented result.

---

## ⭐ What this repository is intended to show

This project is designed to demonstrate **QA thinking**, not just tool usage:

**Analyze → Plan → Test → Investigate → Automate → Report → Assess**

That is the complete workflow behind the portfolio.
