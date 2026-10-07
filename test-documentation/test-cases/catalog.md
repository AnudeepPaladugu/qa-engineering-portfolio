# Catalog detailed cases

Records below contain the latest observed results, timestamps and evidence. The original design baseline was NOT EXECUTED.

## TC-UI-007 — Catalog exposes named product cards

- Requirement ID: REQ-CAT-001
- Scenario ID: TS-UI-007
- Module: Catalog
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: Synthetic QA account where required; Blue Top product ID 1; no real personal or payment data.
- Priority: High
- Severity if failed: Major
- Risk: High
- Test type: UI / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: smoke,regression
- Automation: PortfolioTests.catalog

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /products. | ALL PRODUCTS is visible and at least one product card is displayed. |
| 2 | Inspect the Blue Top card. | The card displays Blue Top and Rs. 500. |

- Actual result: Catalog heading=ALL PRODUCTS; Blue Top card=Rs. 500 / Blue Top / Add to cart
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:28:48.535395Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified

## TC-UI-008 — Search for top includes name and category matches

- Requirement ID: REQ-CAT-002
- Scenario ID: TS-UI-008
- Module: Catalog
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
- Automation: PortfolioTests.searchTop

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /products. | Search Product field is visible. |
| 2 | Enter top in Search Product. | The field contains top. |
| 3 | Click the search button. | SEARCHED PRODUCTS is visible and at least one matching product is displayed. |
| 4 | Read each returned product name. | Returned names include Blue Top (name match) and Little Girls Mr. Panda Shirt (observed Tops & Shirts category match). |

- Actual result: top search returned 14 products, including Blue Top and the Tops & Shirts category item Little Girls Mr. Panda Shirt: [Blue Top, Winter Top, Summer White Top, Madame Top For Women, Fancy Green Top, Sleeves Printed Top - WhiteSource Suppliers, Half Sleeves Top Schiffli Detailing - Pink, Frozen Tops For Kids, Full Sleeves Top Cherry - Pink, Printed Off Shoulder Top - White, Sleeves Top and Short - Blue & Pink, Little Girls Mr. Panda Shirt, Colour Blocked Shirt – Sky BlueBrowse Clothing, Lace Top For Women]
- Status: PASS
- Defect ID: QA-DES-001 fixed (historical)
- Execution date: 2026-10-07T11:31:53.134825100Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified

## TC-UI-009 — Unknown search has no product cards

- Requirement ID: REQ-CAT-002
- Scenario ID: TS-UI-009
- Module: Catalog
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: Synthetic QA account where required; Blue Top product ID 1; no real personal or payment data.
- Priority: Medium
- Severity if failed: Minor
- Risk: Medium
- Test type: UI / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: regression
- Automation: PortfolioTests.searchNoMatch

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /products. | Search Product field is visible. |
| 2 | Enter qa-no-product-<UUID>. | The field contains that unique string. |
| 3 | Click the search button. | SEARCHED PRODUCTS is visible and zero product cards are displayed. |

- Actual result: SEARCHED PRODUCTS displayed with zero product cards
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:31:45.870371900Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified

## TC-UI-010 — Product detail exposes the inspected item attributes

- Requirement ID: REQ-CAT-003
- Scenario ID: TS-UI-010
- Module: Catalog
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
- Automation: PortfolioTests.productDetails

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /product_details/1. | The product information heading is Blue Top. |
| 2 | Read the product price and attributes. | Price is Rs. 500; Availability is In Stock; Condition is New; Brand is Polo. |
| 3 | Inspect the quantity field. | Its initial value is 1. |

- Actual result: Product details=Blue Top / Category: Women > Tops / Rs. 500 / Quantity: Add to cart / Availability: In Stock / Condition: New / Brand: Polo; initial quantity=1
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:31:05.066943100Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified

## TC-UI-019 — Women Tops category exposes its catalog subset

- Requirement ID: REQ-CAT-004
- Scenario ID: TS-UI-019
- Module: Catalog
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: Synthetic QA account where required; Blue Top product ID 1; no real personal or payment data.
- Priority: Medium
- Severity if failed: Minor
- Risk: Medium
- Test type: UI / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: regression
- Automation: PortfolioTests.categoryFilter

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /category_products/2. | WOMEN - TOPS PRODUCTS is visible. |
| 2 | Read the category product cards. | At least one card is visible and Blue Top is present. |

- Actual result: Category heading=WOMEN - TOPS PRODUCTS; names=[Blue Top, Winter Top, Summer White Top, Madame Top For WomenSupport Causes, Fancy Green Top, Lace Top For Women]
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:28:53.430808500Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified

## TC-UI-020 — Polo brand filter exposes its catalog subset

- Requirement ID: REQ-CAT-004
- Scenario ID: TS-UI-020
- Module: Catalog
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: Synthetic QA account where required; Blue Top product ID 1; no real personal or payment data.
- Priority: Medium
- Severity if failed: Minor
- Risk: Medium
- Test type: UI / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: regression
- Automation: PortfolioTests.brandFilter

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /brand_products/Polo. | BRAND - POLO PRODUCTS is visible. |
| 2 | Read the brand product cards. | At least one card is visible and Blue Top is present. |

- Actual result: Brand heading=BRAND - POLO PRODUCTS; names=[Blue Top, Fancy Green Top, Green Side Placket Detail  T-Shirt, Premium Polo  T-Shirts, Soft Stretch Jeans, Grunt Blue Slim Fit Jeans]
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:28:26.307875500Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified
