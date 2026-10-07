# Exploratory detailed cases

Records below contain the latest observed results, timestamps and evidence. The original design baseline was NOT EXECUTED.

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
- Browser/client: Chrome 155.0.8059.39 / Windows; headed keyboard and viewport sessions; headless boundary reproduction
- Groups: manual
- Automation: Manual

| Step | Action | Expected result |
|---|---|---|
| 1 | Open /login in headed Chrome. | Login and signup forms are visible. |
| 2 | Use Tab to reach the login email field. | A visible focus indication reaches the email field. |
| 3 | Use Tab to reach password and Login. | Focus reaches password then Login without a keyboard trap. |

- Actual result: In headed Chrome, Tab reached login-email, then login-password and login-button without a trap. Before/after element screenshots show a visible text caret in the focused email field. This is a focused keyboard check, not an accessibility certification.
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:19:55.107774+00:00
- Executed by: Codex agent-assisted exploratory inspection and screenshot review
- Evidence location: evidence/exploratory/results.json and linked screenshots

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
- Browser/client: Chrome 155.0.8059.39 / Windows; headed keyboard and viewport sessions; headless boundary reproduction
- Groups: manual
- Automation: Manual

| Step | Action | Expected result |
|---|---|---|
| 1 | Set Chrome viewport to 390 by 844 pixels. | The viewport has the requested dimensions. |
| 2 | Open /products. | The search field and product content can be reached by scrolling. |
| 3 | Inspect search and product card controls. | Controls remain readable and operable without being covered by overlapping content. |

- Actual result: Viewport measured 390x844 CSS pixels. Agent visual review of the search and product screenshots found readable, unobscured search/button controls and the Blue Top card, Rs. 500 price and Add to cart control, reachable by vertical scrolling. This is a limited visual assessment, not device coverage.
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:19:55.107774+00:00
- Executed by: Codex agent-assisted exploratory inspection and screenshot review
- Evidence location: evidence/exploratory/results.json and linked screenshots

## TC-MAN-003 — Enforce the declared quantity minimum before cart addition

- Requirement ID: REQ-CART-004
- Scenario ID: TS-MAN-003
- Module: Exploratory
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: 0 and -1; boundary check based on observed HTML min=1; baseline revised after discovery.
- Priority: High
- Severity if failed: Minor
- Risk: High
- Test type: MAN / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome 155.0.8059.39 / Windows; headed keyboard and viewport sessions; headless boundary reproduction
- Groups: manual
- Automation: Manual

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /product_details/1. | Blue Top quantity defaults to 1 and the input declares min=1. |
| 2 | Set quantity to 0. | The input validity.rangeUnderflow is true. |
| 3 | Click Add to cart and wait for the application request to finish. | The invalid quantity is not added to the cart; no successful addition should be represented for a quantity below the declared minimum. |
| 4 | Navigate to /view_cart. | The fresh-session cart has no Blue Top row with zero quantity. |
| 5 | Repeat the steps in a new session with quantity -1. | The input is below min=1; no negative-quantity row or negative line total is created. |
| 6 | Use a new session and repeat with quantity 1 as a positive control. | Blue Top is added with quantity 1 and line total Rs. 500. |

- Actual result: Quantity DOM min=1. Both 0 and -1 have rangeUnderflow=true but display the Added modal and persist in cart after request completion. Zero produces Rs. 0; -1 produces Rs. -500. Positive control 1 produces Rs. 500. Negative case reproduced in two independent sessions.
- Status: FAIL
- Defect ID: QA-PROD-001
- Execution date: 2026-10-07T11:19:55.107774+00:00
- Executed by: Codex agent-assisted exploratory inspection and screenshot review
- Evidence location: evidence/exploratory/results.json and linked screenshots
