# QA-DES-001: Search oracle incorrectly assumes a name-only match

- Module: catalog test design; classification: test-design defect
- Environment: public Automation Exercise; Windows / Chrome 155.0.8059.39
- Application build: not exposed; framework build: 22b411372bde472f64c8800c0845cd542562b4f3
- Severity: Major; priority: High
- Preconditions: Open /products in a fresh session.
- Reproduce: (1) type top into Search Product; (2) click Search; (3) read all returned names; (4) compare category metadata from the documented search API.
- Incorrect test expectation: Every returned name contains top.
- Actual: The results include Little Girls Mr. Panda Shirt and Colour Blocked Shirt; their API category is Tops & Shirts. The query matches category data as well as product names.
- Correct expected result: Search shows related products, including Blue Top as a name match and Little Girls Mr. Panda Shirt as the observed category match. API assertions can check name or category.
- Source: Actual browser results and documented API response. The site's official search case describes related search products, without a name-only contract.
- Reproducibility: UI result and saved API response independently show the category match.
- Evidence/logs: evidence/initial-regression/results.json (TC-UI-008); evidence/discovery/api-observations.json; raw response retained locally.
- Status: FIXED AND VERIFIED: focused search rerun passed using the corrected expectation; complete regression rerun is pending.

The initial FAIL remains in the execution history. No application fix or product defect is claimed.
