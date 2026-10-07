# Functional requirements

Source references: [application discovery](../00-discovery/application-inspection.md), [official UI cases](https://automationexercise.com/test_cases), [official API list](https://automationexercise.com/api_list). Requirements based on an official expected outcome remain provisional until execution verifies behavior.

## REQ-AUTH-001: Required login inputs

- Description: Login exposes email and masked password, and the browser blocks missing required input.
- Source: Direct browser/DOM discovery and official UI cases
- Priority: High
- Business risk: Credential form becomes unusable or exposes password text.
- Acceptance criteria: Login fields are visible; email/password required properties are true; password type is password.
- Dependencies: None
- Testable: Yes
- Related test cases: TC-UI-001, TC-UI-003, TC-MAN-001

## REQ-AUTH-002: Invalid authentication

- Description: Unknown credentials receive the application error.
- Source: Direct browser/DOM discovery and official UI cases; final outcome pending formal execution
- Priority: High
- Business risk: Users cannot diagnose a rejected login.
- Acceptance criteria: Your email or password is incorrect! appears after unknown credentials are submitted.
- Dependencies: REQ-AUTH-001
- Testable: Yes
- Related test cases: TC-UI-002

## REQ-AUTH-003: Registration and uniqueness

- Description: A synthetic account can be registered; reusing its email is rejected.
- Source: Direct browser/DOM discovery and official UI cases
- Priority: High
- Business risk: Accounts cannot be created or uniqueness is broken.
- Acceptance criteria: ACCOUNT CREATED! then Logged in as QA Portfolio; duplicate email displays Email Address already exist!
- Dependencies: None
- Testable: Yes
- Related test cases: TC-UI-004, TC-UI-018

## REQ-AUTH-004: Valid authentication

- Description: A registered user can authenticate through the UI.
- Source: Direct browser/DOM discovery and official UI cases
- Priority: High
- Business risk: Existing users cannot reach checkout.
- Acceptance criteria: Registered credentials display Logged in as QA Portfolio and Logout.
- Dependencies: REQ-AUTH-003
- Testable: Yes
- Related test cases: TC-UI-005

## REQ-AUTH-005: Logout

- Description: An authenticated user can end the UI session.
- Source: Direct browser/DOM discovery and official UI cases
- Priority: High
- Business risk: Shared-browser session remains authenticated.
- Acceptance criteria: Logout navigates to /login and removes authenticated navigation.
- Dependencies: REQ-AUTH-004
- Testable: Yes
- Related test cases: TC-UI-006

## REQ-CAT-001: Catalog display

- Description: The product catalog exposes names and prices.
- Source: Direct browser/DOM discovery and official UI cases
- Priority: High
- Business risk: Buyers cannot identify items.
- Acceptance criteria: ALL PRODUCTS is visible; product cards include Blue Top at Rs. 500.
- Dependencies: None
- Testable: Yes
- Related test cases: TC-UI-007, TC-MAN-002

## REQ-CAT-002: Catalog search

- Description: Search returns matching names and supports a no-match result.
- Source: Direct browser/DOM discovery and official UI cases
- Priority: High
- Business risk: Buyers cannot find products.
- Acceptance criteria: top search includes observed name and category matches; a unique unknown query produces zero cards.
- Dependencies: REQ-CAT-001
- Testable: Yes
- Related test cases: TC-UI-008, TC-UI-009

## REQ-CAT-003: Product details

- Description: Product 1 exposes the inspected attributes.
- Source: Direct browser/DOM discovery and official UI cases
- Priority: High
- Business risk: Incorrect product identity or price reaches cart.
- Acceptance criteria: Blue Top; Rs. 500; In Stock; New; Polo; default quantity 1.
- Dependencies: REQ-CAT-001
- Testable: Yes
- Related test cases: TC-UI-010

## REQ-CAT-004: Category and brand browsing

- Description: Known category and brand routes expose their subsets.
- Source: Direct browser/DOM discovery and official UI cases; final outcome pending formal execution
- Priority: Medium
- Business risk: Browsing misses available stock.
- Acceptance criteria: Women Tops and Polo result headings appear; Blue Top belongs to both.
- Dependencies: REQ-CAT-001
- Testable: Yes
- Related test cases: TC-UI-019, TC-UI-020

## REQ-CART-001: Cart quantity and total

- Description: Adding quantity 2 of product 1 carries the item quantity and price.
- Source: Direct browser/DOM discovery and official UI cases
- Priority: High
- Business risk: Incorrect amount reaches checkout.
- Acceptance criteria: Blue Top at Rs. 500, quantity 2, line total Rs. 1000. Positivity constraints require clarification.
- Dependencies: REQ-CAT-003
- Testable: Yes
- Related test cases: TC-UI-011, TC-MAN-003

## REQ-CART-002: Cart removal

- Description: Removing the only cart row returns the empty state.
- Source: Direct browser/DOM discovery and official UI cases
- Priority: High
- Business risk: Buyers cannot correct their cart.
- Acceptance criteria: Blue Top row disappears; Cart is empty! is visible.
- Dependencies: REQ-CART-001
- Testable: Yes
- Related test cases: TC-UI-012

## REQ-CART-003: Same-session cart persistence

- Description: Refreshing the cart retains the added row.
- Source: Direct browser/DOM discovery and official UI cases
- Priority: High
- Business risk: Navigation loses the purchase selection.
- Acceptance criteria: Refresh preserves product 1, quantity 2, total Rs. 1000 in the same session.
- Dependencies: REQ-CART-001
- Testable: Yes
- Related test cases: TC-UI-013

## REQ-CHK-001: Guest checkout gate

- Description: Guests are prompted to register or login before checkout.
- Source: Direct browser/DOM discovery and official UI cases
- Priority: High
- Business risk: Order flow lacks an associated account.
- Acceptance criteria: Checkout modal displays Register / Login account to proceed on checkout.
- Dependencies: REQ-CART-001
- Testable: Yes
- Related test cases: TC-UI-014

## REQ-CHK-002: Authenticated order review

- Description: The review carries account address and cart totals.
- Source: Direct browser/DOM discovery and official UI cases
- Priority: High
- Business risk: Wrong delivery details or totals reach payment.
- Acceptance criteria: Address Details and Review Your Order match the synthetic account and Rs. 1000 cart.
- Dependencies: REQ-AUTH-004; REQ-CART-001
- Testable: Yes
- Related test cases: TC-UI-015

## REQ-CHK-003: Simulated order confirmation

- Description: Synthetic payment input completes the practice order.
- Source: Direct browser/DOM discovery and official UI cases; final outcome pending formal execution
- Priority: High
- Business risk: The business-critical purchase flow fails.
- Acceptance criteria: ORDER PLACED! and Congratulations! Your order has been confirmed! appear. This is a practice order, not financial settlement.
- Dependencies: REQ-CHK-002
- Testable: Yes
- Related test cases: TC-UI-016

## REQ-CHK-004: Required payment input

- Description: Blank name on card blocks submission in the browser.
- Source: Direct browser/DOM discovery and official UI cases
- Priority: High
- Business risk: Incomplete payment form reaches confirmation.
- Acceptance criteria: Name on Card validity.valueMissing is true; URL stays /payment.
- Dependencies: REQ-CHK-002
- Testable: Yes
- Related test cases: TC-UI-017

## REQ-API-001: Catalog API contracts

- Description: Documented catalog/brand methods return parseable body contracts.
- Source: Official API list and direct HTTP discovery
- Priority: High
- Business risk: Consumers misread successful or unsupported operations.
- Acceptance criteria: HTTP 200; responseCode 200 for GET and 405 for documented unsupported methods; product/brand arrays exist.
- Dependencies: None
- Testable: Yes
- Related test cases: TC-API-001, TC-API-002, TC-API-003, TC-API-004

## REQ-API-002: Search and login API validation

- Description: Missing and empty fields have distinct documented or observed behavior.
- Source: Official API list and direct HTTP discovery
- Priority: High
- Business risk: Integrations misclassify validation errors.
- Acceptance criteria: HTTP 200 with body codes and exact messages per TC-API-005 through 009.
- Dependencies: REQ-API-001
- Testable: Yes
- Related test cases: TC-API-005, TC-API-006, TC-API-007, TC-API-008, TC-API-009
