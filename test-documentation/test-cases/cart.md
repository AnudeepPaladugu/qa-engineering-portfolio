# Cart detailed cases

Records below contain the latest observed results, timestamps and evidence. The original design baseline was NOT EXECUTED.

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
- Execution date: 2026-10-07T11:28:41.703895500Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified

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
- Execution date: 2026-10-07T11:31:33.825701900Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified

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
- Execution date: 2026-10-07T11:28:34.682297300Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified

## TC-UI-021 — Reject a quantity below the declared minimum

- Requirement ID: REQ-CART-004
- Scenario ID: TS-UI-021
- Module: Cart
- Objective: Preserve a regression guard for the observed quantity validation defect.
- Preconditions: Fresh guest Chrome session; demo reachable; no account or password required.
- Test data: Product 1 Blue Top at Rs. 500; quantity -1.
- Priority: High
- Severity if failed: High
- Risk: High
- Test type: UI / negative boundary regression
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser: Chrome 155.0.8059.39
- Groups: smoke, regression, critical, ui
- Automation: PortfolioTests.rejectNegativeQuantity

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /product_details/1. | Blue Top is displayed; Quantity has min=1. |
| 2 | Set Quantity to -1. | The field contains -1, below the declared minimum. |
| 3 | Click Add to cart and wait for request completion. | The below-minimum quantity is rejected; successful addition is not required by the test. |
| 4 | Navigate to /view_cart. | The cart remains empty; no negative-quantity row or negative line total is persisted. |

- Actual result: After adding quantity -1, cart text=Home /  Products / Cart / Signup / Login / Test Cases / API Testing / Video Tutorials / Contact us / Home Shopping Cart / Proceed To Checkout / Item Description Price Quantity Total / Blue Top / Women > Tops / Rs. 500 / -1 / Rs. -500 /  /  / SUBSCRIPTION / Get the most recent updates from / our site and be updated your self... / Copyright © 2021 All rights reserved
- Status: FAIL
- Defect ID: QA-PROD-001 OPEN
- Execution date: 2026-10-07T11:31:25.540827600Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified
