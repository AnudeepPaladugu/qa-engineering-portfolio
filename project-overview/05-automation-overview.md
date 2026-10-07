# Automation Overview

## What does the automation do?

The automation uses Java, Selenium WebDriver and TestNG to repeatedly verify important application behaviour.

The simplified flow is:

```text
Test Case
   ↓
TestNG
   ↓
Page Object
   ↓
Selenium WebDriver
   ↓
Browser
   ↓
Application
   ↓
Assertion
   ↓
Evidence / Report
```

## What the important files mean

| File / Area | Plain-English meaning |
|---|---|
| `Drivers.java` | Starts and manages the browser |
| `BasePage.java` | Shared UI/browser behaviour |
| `pages/` | Page-specific UI actions and locators |
| `PortfolioTests.java` | Main automated QA checks |
| `Evidence.java` | Creates structured execution evidence |
| `EvidenceListener.java` | Captures evidence around test events |
| `config.properties` | Keeps configuration outside the test logic |
| `testng-regression.xml` | Defines the regression suite |
| `testng-smoke.xml` | Defines the smoke selection |
| `pom.xml` | Defines Maven dependencies and build/test configuration |

## Why Page Objects?

The tests should describe **what we are verifying**, while page objects handle **how the browser interacts with the page**.

That separation makes the automation easier to read and maintain.

## Why evidence?

A test result is more useful when someone can understand what happened. The project therefore captures screenshots, logs and structured results rather than relying only on a PASS/FAIL status.

[Next: Results & Conclusion](06-results-and-conclusion.md)