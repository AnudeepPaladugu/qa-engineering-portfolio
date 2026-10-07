# Requirement traceability matrix

Current discovery-derived baseline: 19 functional requirements and 33 case records. All were executed; 31 PASS and two FAIL. Both failures concern the same open quantity-validation defect. The source website has not been modified.

| Requirement | Scenario | Case | Automation / mode | Latest result | Defect | Evidence |
|---|---|---|---|---|---|---|
| REQ-AUTH-001 | TS-UI-001 | TC-UI-001 | PortfolioTests.loginForm | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-AUTH-002 | TS-UI-002 | TC-UI-002 | PortfolioTests.invalidLogin | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-AUTH-001 | TS-UI-003 | TC-UI-003 | PortfolioTests.requiredLoginEmail | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-AUTH-003 | TS-UI-004 | TC-UI-004 | PortfolioTests.registerAccount | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-AUTH-004 | TS-UI-005 | TC-UI-005 | PortfolioTests.validLogin | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-AUTH-005 | TS-UI-006 | TC-UI-006 | PortfolioTests.logout | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-CAT-001 | TS-UI-007 | TC-UI-007 | PortfolioTests.catalog | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-CAT-002 | TS-UI-008 | TC-UI-008 | PortfolioTests.searchTop | PASS | QA-DES-001 fixed | evidence/latest-regression/results.json |
| REQ-CAT-002 | TS-UI-009 | TC-UI-009 | PortfolioTests.searchNoMatch | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-CAT-003 | TS-UI-010 | TC-UI-010 | PortfolioTests.productDetails | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-CART-001 | TS-UI-011 | TC-UI-011 | PortfolioTests.cartTotal | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-CART-002 | TS-UI-012 | TC-UI-012 | PortfolioTests.removeCartItem | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-CART-003 | TS-UI-013 | TC-UI-013 | PortfolioTests.cartPersists | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-CHK-001 | TS-UI-014 | TC-UI-014 | PortfolioTests.guestCheckout | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-CHK-002 | TS-UI-015 | TC-UI-015 | PortfolioTests.checkoutReview | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-CHK-003 | TS-UI-016 | TC-UI-016 | PortfolioTests.completeOrder | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-CHK-004 | TS-UI-017 | TC-UI-017 | PortfolioTests.paymentRequiredName | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-AUTH-003 | TS-UI-018 | TC-UI-018 | PortfolioTests.duplicateSignup | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-CAT-004 | TS-UI-019 | TC-UI-019 | PortfolioTests.categoryFilter | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-CAT-004 | TS-UI-020 | TC-UI-020 | PortfolioTests.brandFilter | PASS | None recorded | evidence/latest-regression/results.json |
| REQ-API-001 | TS-API-001 | TC-API-001 | Postman collection / runner verification | PASS | QA-PM-001 fixed | evidence/postman/results.json |
| REQ-API-001 | TS-API-002 | TC-API-002 | Postman collection / runner verification | PASS | QA-PM-001 fixed | evidence/postman/results.json |
| REQ-API-001 | TS-API-003 | TC-API-003 | Postman collection / runner verification | PASS | QA-PM-001 fixed | evidence/postman/results.json |
| REQ-API-001 | TS-API-004 | TC-API-004 | Postman collection / runner verification | PASS | QA-PM-001 fixed | evidence/postman/results.json |
| REQ-API-002 | TS-API-005 | TC-API-005 | Postman collection / runner verification | PASS | QA-PM-001 fixed | evidence/postman/results.json |
| REQ-API-002 | TS-API-006 | TC-API-006 | Postman collection / runner verification | PASS | QA-PM-001 fixed | evidence/postman/results.json |
| REQ-API-002 | TS-API-007 | TC-API-007 | Postman collection / runner verification | PASS | QA-PM-001 fixed | evidence/postman/results.json |
| REQ-API-002 | TS-API-008 | TC-API-008 | Postman collection / runner verification | PASS | QA-PM-001 fixed | evidence/postman/results.json |
| REQ-API-002 | TS-API-009 | TC-API-009 | Postman collection / runner verification | PASS | QA-PM-001 fixed | evidence/postman/results.json |
| REQ-AUTH-001 | TS-MAN-001 | TC-MAN-001 | Agent-assisted exploratory inspection | PASS | None recorded | evidence/exploratory/results.json |
| REQ-CAT-001 | TS-MAN-002 | TC-MAN-002 | Agent-assisted exploratory inspection | PASS | None recorded | evidence/exploratory/results.json |
| REQ-CART-004 | TS-MAN-003 | TC-MAN-003 | Agent-assisted exploratory inspection | FAIL | QA-PROD-001 OPEN | evidence/exploratory/results.json |
| REQ-CART-004 | TS-UI-021 | TC-UI-021 | PortfolioTests.rejectNegativeQuantity | FAIL | QA-PROD-001 OPEN | evidence/latest-regression/results.json |
