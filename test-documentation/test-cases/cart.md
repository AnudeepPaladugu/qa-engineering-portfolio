# Cart detailed cases

Status baseline: NOT EXECUTED. Test execution must record an observed result, timestamp and evidence rather than copy the expected result.

## TC-UI-011 — Quantity two produces the correct line total

- Requirement ID: REQ-CART-001
- Scenario ID: TS-UI-011
- Module: Cart
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: Synthetic QA account where required; Blue Top product ID 1; no real personal or payment data.
- Priority: High
- Severity if failed: Critical
- Risk: High
- Test type: UI / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: smoke,regression,critical
- Automation: PortfolioTests.cartTotal

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /product_details/1. | Blue Top and Rs. 500 are visible. |
| 2 | Replace the Quantity value with 2. | The Quantity field contains 2. |
| 3 | Click Add to cart. | The Added! modal is visible with Your product has been added to cart. |
| 4 | Navigate to /view_cart. | The Blue Top row shows Rs. 500, quantity 2 and total Rs. 1000. |

- Actual result: Cart Blue Top: unit=Rs. 500; quantity=2; total=Rs. 1000
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:01:46.373354200Z
- Executed by: Codex automated Chrome execution
- Evidence location: evidence/ui-regression/results.json; generated screenshots and logs under artifacts/runs; Allure attachments verified

## TC-UI-012 — Remove the only item from the cart

- Requirement ID: REQ-CART-002
- Scenario ID: TS-UI-012
- Module: Cart
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: Synthetic QA account where required; Blue Top product ID 1; no real personal or payment data.
- Priority: High
- Severity if failed: Major
- Risk: High
- Test type: UI / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: regression
- Automation: PortfolioTests.removeCartItem

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /product_details/1. | Blue Top and Rs. 500 are visible. |
| 2 | Replace the Quantity value with 2. | The Quantity field contains 2. |
| 3 | Click Add to cart. | The Added! modal is visible with Your product has been added to cart. |
| 4 | Navigate to /view_cart. | The Blue Top row shows Rs. 500, quantity 2 and total Rs. 1000. |
| 5 | Click the delete control on the Blue Top row. | The Blue Top row disappears and Cart is empty! becomes visible. |

- Actual result: Deleted Blue Top row; Cart is empty! displayed
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:04:30.865251700Z
- Executed by: Codex automated Chrome execution
- Evidence location: evidence/ui-regression/results.json; generated screenshots and logs under artifacts/runs; Allure attachments verified

## TC-UI-013 — Cart contents survive a same-session refresh

- Requirement ID: REQ-CART-003
- Scenario ID: TS-UI-013
- Module: Cart
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: Synthetic QA account where required; Blue Top product ID 1; no real personal or payment data.
- Priority: High
- Severity if failed: Major
- Risk: High
- Test type: UI / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: regression
- Automation: PortfolioTests.cartPersists

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /product_details/1. | Blue Top and Rs. 500 are visible. |
| 2 | Replace the Quantity value with 2. | The Quantity field contains 2. |
| 3 | Click Add to cart. | The Added! modal is visible with Your product has been added to cart. |
| 4 | Navigate to /view_cart. | The Blue Top row shows Rs. 500, quantity 2 and total Rs. 1000. |
| 5 | Refresh /view_cart. | The Blue Top row still shows quantity 2 and total Rs. 1000. |

- Actual result: After refresh: quantity=2; total=Rs. 1000
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:01:38.011742500Z
- Executed by: Codex automated Chrome execution
- Evidence location: evidence/ui-regression/results.json; generated screenshots and logs under artifacts/runs; Allure attachments verified
