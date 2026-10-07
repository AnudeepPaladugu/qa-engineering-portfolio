# Checkout detailed cases

Status baseline: NOT EXECUTED. Test execution must record an observed result, timestamp and evidence rather than copy the expected result.

## TC-UI-014 — Guest checkout is gated by registration or login

- Requirement ID: REQ-CHK-001
- Scenario ID: TS-UI-014
- Module: Checkout
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
- Automation: PortfolioTests.guestCheckout

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /product_details/1. | Blue Top and Rs. 500 are visible. |
| 2 | Replace the Quantity value with 2. | The Quantity field contains 2. |
| 3 | Click Add to cart. | The Added! modal is visible with Your product has been added to cart. |
| 4 | Navigate to /view_cart. | The Blue Top row shows Rs. 500, quantity 2 and total Rs. 1000. |
| 5 | Click Proceed To Checkout. | The checkout modal displays Register / Login account to proceed on checkout. and the Register / Login link. |

- Actual result: Not executed yet.
- Status: NOT EXECUTED
- Defect ID: None recorded
- Execution date: Not executed
- Executed by: Not executed
- Evidence location: Pending execution

## TC-UI-015 — Authenticated review carries address and cart total

- Requirement ID: REQ-CHK-002
- Scenario ID: TS-UI-015
- Module: Checkout
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: Synthetic QA account where required; Blue Top product ID 1; no real personal or payment data.
- Priority: High
- Severity if failed: Critical
- Risk: High
- Test type: UI / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: regression,critical
- Automation: PortfolioTests.checkoutReview

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /login. | The New User Signup! heading is visible. |
| 2 | Enter the synthetic name QA Portfolio in the signup name field. | The signup name field contains QA Portfolio. |
| 3 | Enter a unique email using the qa-portfolio-<UUID>@example.com pattern. | The signup email field contains that unique email. |
| 4 | Click Signup. | The URL path is /signup and ENTER ACCOUNT INFORMATION is visible. |
| 5 | Enter the configured test-only password. | The password field is populated and has type password. |
| 6 | Enter first name QA. | The First name field contains QA. |
| 7 | Enter last name Portfolio. | The Last name field contains Portfolio. |
| 8 | Enter address Test Street. | The Address field contains Test Street. |
| 9 | Select India as the country. | The Country selection is India. |
| 10 | Enter Andhra Pradesh as the state. | The State field contains Andhra Pradesh. |
| 11 | Enter Vijayawada as the city. | The City field contains Vijayawada. |
| 12 | Enter zipcode 520001. | The Zipcode field contains 520001. |
| 13 | Enter synthetic mobile number 9999999999. | The Mobile Number field contains 9999999999. |
| 14 | Click Create Account. | ACCOUNT CREATED! is visible. |
| 15 | Click Continue. | The home page shows Logged in as QA Portfolio. |
| 16 | Navigate to /product_details/1. | Blue Top and Rs. 500 are visible. |
| 17 | Replace the Quantity value with 2. | The Quantity field contains 2. |
| 18 | Click Add to cart. | The Added! modal is visible with Your product has been added to cart. |
| 19 | Navigate to /view_cart. | The Blue Top row shows Rs. 500, quantity 2 and total Rs. 1000. |
| 20 | Click Proceed To Checkout. | The URL path is /checkout; Address Details and Review Your Order are visible. |
| 21 | Read the delivery address. | It contains QA Portfolio, Test Street, Vijayawada Andhra Pradesh 520001 and India. |
| 22 | Read the order review and total. | The Blue Top row shows quantity 2 and Rs. 1000; Total Amount is Rs. 1000. |

- Actual result: Not executed yet.
- Status: NOT EXECUTED
- Defect ID: None recorded
- Execution date: Not executed
- Executed by: Not executed
- Evidence location: Pending execution

## TC-UI-016 — Submit a simulated order using synthetic payment data

- Requirement ID: REQ-CHK-003
- Scenario ID: TS-UI-016
- Module: Checkout
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
- Automation: PortfolioTests.completeOrder

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /login. | The New User Signup! heading is visible. |
| 2 | Enter the synthetic name QA Portfolio in the signup name field. | The signup name field contains QA Portfolio. |
| 3 | Enter a unique email using the qa-portfolio-<UUID>@example.com pattern. | The signup email field contains that unique email. |
| 4 | Click Signup. | The URL path is /signup and ENTER ACCOUNT INFORMATION is visible. |
| 5 | Enter the configured test-only password. | The password field is populated and has type password. |
| 6 | Enter first name QA. | The First name field contains QA. |
| 7 | Enter last name Portfolio. | The Last name field contains Portfolio. |
| 8 | Enter address Test Street. | The Address field contains Test Street. |
| 9 | Select India as the country. | The Country selection is India. |
| 10 | Enter Andhra Pradesh as the state. | The State field contains Andhra Pradesh. |
| 11 | Enter Vijayawada as the city. | The City field contains Vijayawada. |
| 12 | Enter zipcode 520001. | The Zipcode field contains 520001. |
| 13 | Enter synthetic mobile number 9999999999. | The Mobile Number field contains 9999999999. |
| 14 | Click Create Account. | ACCOUNT CREATED! is visible. |
| 15 | Click Continue. | The home page shows Logged in as QA Portfolio. |
| 16 | Navigate to /product_details/1. | Blue Top and Rs. 500 are visible. |
| 17 | Replace the Quantity value with 2. | The Quantity field contains 2. |
| 18 | Click Add to cart. | The Added! modal is visible with Your product has been added to cart. |
| 19 | Navigate to /view_cart. | The Blue Top row shows Rs. 500, quantity 2 and total Rs. 1000. |
| 20 | Click Proceed To Checkout. | The URL path is /checkout; Address Details and Review Your Order are visible. |
| 21 | Click Place Order. | The URL path is /payment and Payment is visible. |
| 22 | Enter QA Portfolio as Name on Card. | The Name on Card field contains QA Portfolio. |
| 23 | Enter the synthetic card number 4111111111111111. | The Card Number field contains that test value. |
| 24 | Enter CVC 123. | The CVC field contains 123. |
| 25 | Enter expiry month 12. | The Expiration month field contains 12. |
| 26 | Enter expiry year 2030. | The Expiration year field contains 2030. |
| 27 | Click Pay and Confirm Order. | ORDER PLACED! and Congratulations! Your order has been confirmed! are visible. |

- Actual result: Not executed yet.
- Status: NOT EXECUTED
- Defect ID: None recorded
- Execution date: Not executed
- Executed by: Not executed
- Evidence location: Pending execution

## TC-UI-017 — Missing name prevents payment submission

- Requirement ID: REQ-CHK-004
- Scenario ID: TS-UI-017
- Module: Checkout
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
- Automation: PortfolioTests.paymentRequiredName

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /login. | The New User Signup! heading is visible. |
| 2 | Enter the synthetic name QA Portfolio in the signup name field. | The signup name field contains QA Portfolio. |
| 3 | Enter a unique email using the qa-portfolio-<UUID>@example.com pattern. | The signup email field contains that unique email. |
| 4 | Click Signup. | The URL path is /signup and ENTER ACCOUNT INFORMATION is visible. |
| 5 | Enter the configured test-only password. | The password field is populated and has type password. |
| 6 | Enter first name QA. | The First name field contains QA. |
| 7 | Enter last name Portfolio. | The Last name field contains Portfolio. |
| 8 | Enter address Test Street. | The Address field contains Test Street. |
| 9 | Select India as the country. | The Country selection is India. |
| 10 | Enter Andhra Pradesh as the state. | The State field contains Andhra Pradesh. |
| 11 | Enter Vijayawada as the city. | The City field contains Vijayawada. |
| 12 | Enter zipcode 520001. | The Zipcode field contains 520001. |
| 13 | Enter synthetic mobile number 9999999999. | The Mobile Number field contains 9999999999. |
| 14 | Click Create Account. | ACCOUNT CREATED! is visible. |
| 15 | Click Continue. | The home page shows Logged in as QA Portfolio. |
| 16 | Navigate to /product_details/1. | Blue Top and Rs. 500 are visible. |
| 17 | Replace the Quantity value with 2. | The Quantity field contains 2. |
| 18 | Click Add to cart. | The Added! modal is visible with Your product has been added to cart. |
| 19 | Navigate to /view_cart. | The Blue Top row shows Rs. 500, quantity 2 and total Rs. 1000. |
| 20 | Click Proceed To Checkout. | The URL path is /checkout; Address Details and Review Your Order are visible. |
| 21 | Click Place Order. | The URL path is /payment. |
| 22 | Leave Name on Card blank. | Name on Card value is empty. |
| 23 | Click Pay and Confirm Order. | The URL remains /payment and Name on Card validity.valueMissing is true. |

- Actual result: Not executed yet.
- Status: NOT EXECUTED
- Defect ID: None recorded
- Execution date: Not executed
- Executed by: Not executed
- Evidence location: Pending execution
