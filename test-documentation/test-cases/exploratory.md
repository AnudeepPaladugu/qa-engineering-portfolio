# Exploratory detailed cases

Status baseline: NOT EXECUTED. Test execution must record an observed result, timestamp and evidence rather than copy the expected result.

## TC-MAN-001 — Login is reachable using keyboard navigation

- Requirement ID: REQ-AUTH-001
- Scenario ID: TS-MAN-001
- Module: Exploratory
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: No credentials entered.
- Priority: Medium
- Severity if failed: Minor
- Risk: Medium
- Test type: MAN / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: manual
- Automation: Manual

| Step | Action | Expected result |
|---|---|---|
| 1 | Open /login in headed Chrome. | Login and signup forms are visible. |
| 2 | Use Tab to reach the login email field. | A visible focus indication reaches the email field. |
| 3 | Use Tab to reach password and Login. | Focus reaches password then Login without a keyboard trap. |

- Actual result: Not executed yet.
- Status: NOT EXECUTED
- Defect ID: None recorded
- Execution date: Not executed
- Executed by: Not executed
- Evidence location: Pending execution

## TC-MAN-002 — Catalog usability at a narrow viewport

- Requirement ID: REQ-CAT-001
- Scenario ID: TS-MAN-002
- Module: Exploratory
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: 390 x 844 CSS pixels; visual assessment; screenshots required.
- Priority: Medium
- Severity if failed: Minor
- Risk: Medium
- Test type: MAN / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: manual
- Automation: Manual

| Step | Action | Expected result |
|---|---|---|
| 1 | Set Chrome viewport to 390 by 844 pixels. | The viewport has the requested dimensions. |
| 2 | Open /products. | The search field and product content can be reached by scrolling. |
| 3 | Inspect search and product card controls. | Controls remain readable and operable without being covered by overlapping content. |

- Actual result: Not executed yet.
- Status: NOT EXECUTED
- Defect ID: None recorded
- Execution date: Not executed
- Executed by: Not executed
- Evidence location: Pending execution

## TC-MAN-003 — Investigate zero and negative quantity behavior

- Requirement ID: REQ-CART-001
- Scenario ID: TS-MAN-003
- Module: Exploratory
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: 0 and -1; exploratory charter; no fabricated acceptance criterion.
- Priority: Medium
- Severity if failed: Minor
- Risk: Medium
- Test type: MAN / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: manual
- Automation: Manual

| Step | Action | Expected result |
|---|---|---|
| 1 | Open /product_details/1 in a fresh guest session. | Blue Top quantity is 1. |
| 2 | Set quantity to 0 and inspect browser validity before attempting Add to cart. | Record validity and whether the application accepts the value; acceptance is a business-rule question, not an assumed defect. |
| 3 | Repeat with -1 in a new session. | Record validity, cart quantity and total if accepted; raise a requirement question if positivity is not enforced. |

- Actual result: Not executed yet.
- Status: NOT EXECUTED
- Defect ID: None recorded
- Execution date: Not executed
- Executed by: Not executed
- Evidence location: Pending execution
