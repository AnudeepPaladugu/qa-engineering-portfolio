# Five-minute interview walkthrough

1. Explain the scope: a shared e-commerce practice environment, not an owned production system. Show direct discovery and the documented limitations.
2. Trace REQ-CHK-003 through its scenario, TC-UI-016, PortfolioTests.completeOrder, the page objects and the real confirmation screenshot.
3. Explain the search test-design correction: matching can come from category data; narrowing the oracle to names created a false failure. Show the retained failed run and corrected baseline.
4. Show the evidence lifecycle issue: screenshots existed locally but listener timing missed the active Allure test. The hook fix and intentional failure audit demonstrate debugging rather than hiding failures.
5. Show QA-PROD-001: min=1 is exposed, yet quantity -1 persists and displays Rs. -500. Explain request synchronization and the positive control, then show the new failing regression guard.
6. Explain why a high pass percentage still leads to NO-GO. The open monetary correctness defect matters more than cosmetic/positive-path successes.
7. Describe Postman transport status versus responseCode, and explain why no database execution or successful Jenkins run is claimed.

Describe this as a portfolio demonstration using synthetic data. Do not imply that the app owner approved the inferred requirement, that a genuine payment gateway was tested, or that this project was delivered for an employer.
