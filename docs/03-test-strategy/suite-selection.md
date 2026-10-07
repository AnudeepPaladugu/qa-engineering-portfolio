# Suite selection after exploratory discovery

The initial baseline had 20 UI cases and seven smoke members. QA-PROD-001 justified one new automated guard. The current inventory has 21 UI cases, nine Postman cases and three exploratory cases: **33 distinct case records**.

| Smoke case | Why it belongs |
|---|---|
| TC-UI-001 | Login entry form availability |
| TC-UI-004 | New-customer registration |
| TC-UI-005 | Existing-customer authentication |
| TC-UI-007 | Purchasable catalog availability |
| TC-UI-011 | Positive cart arithmetic |
| TC-UI-014 | Guest checkout account gate |
| TC-UI-016 | Complete practice order |
| TC-UI-021 | Monetary boundary guard for a reproduced high-risk defect |

Smoke is now eight cases. Regression is all 21 UI cases. Both include the open product-defect guard and are expected to return a non-zero exit while the application accepts a negative cart quantity. The guard is not skipped, marked expected-failure, retried, or removed to obtain a green build. It waits for request completion without demanding a success modal, so a future valid rejection can pass.

The test suite's failed state is an honest application-quality result. Compilation, driver lifecycle, evidence and Allure were independently verified; no claim is made that a red suite means the framework is broken. The application is third-party hosted, so this repository cannot apply a website code fix.
