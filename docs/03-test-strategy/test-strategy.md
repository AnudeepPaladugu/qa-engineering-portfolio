# Test strategy

## Objective and scope
Build evidence-backed confidence in the inspected customer purchase path. Cover account UI, catalog/search/category/brand, cart, checkout and nine documented API read/validation cases. Exclude real financial settlement, database execution, admin workflows, order history, sorting, load/penetration testing and API endpoints that are not published.

## Approach and rationale
| Area | Approach | Why |
|---|---|---|
| Test levels | UI system tests and cart-to-checkout integration; no application unit tests | Application source is not owned |
| Functional/UI | Selenium verifies text, URLs, form properties and totals | Provides observable outcomes |
| Smoke | Form availability, signup/login, catalog, cart total, guest gate and complete practice order | Samples the business-critical chain |
| Regression | All 20 UI cases | Covers correction, persistence, negative and filter paths |
| Sanity | Login form case plus a focused changed-area case selected by ID | Small change-focused checks; do not equate with full release confidence |
| API | Manual Postman collection with HTTP/body-code assertions | Fits resume scope and the unusual demo response contract |
| Integration | Cart quantity/address carried into review and confirmation | Detects data transfer failures across pages |
| Database | Documented SQL design only | No legitimate public database access |
| Compatibility | Chrome baseline; manual narrow viewport assessment | Matches available environment without unsupported cross-browser claims |
| Negative/validation | Unknown login, duplicate signup, required login/payment input, missing API parameter | Exercises failure contracts |
| Boundary/edge | Empty versus missing API search; zero/negative quantity charter | Empty/omitted values differ; quantity limits need clarification |
| Exploratory | Keyboard, narrow viewport and quantity charters | Human observation addresses ambiguities and usability |
| Risk-based | Prioritize authentication, cart arithmetic and checkout completion | Failure there outweighs cosmetic coverage |

## Automation and manual separation
Use Java 21, Selenium, TestNG, Maven, page objects and Allure. Fresh browser per case, serial by default, explicit waits and no retries. Manual records remain NOT EXECUTED until someone performs their steps. Do not relabel a programmatic HTTP probe as a Postman GUI execution.

## Entry, exit and suspension
Entry: verified URL, available Chrome/driver, configured TEST_PASSWORD, reviewed case baseline, synthetic data and internet access. Exit: all critical smoke cases pass, no unresolved reproducible high-severity product defect, full regression result reviewed, evidence retained and manual/API limitations stated. Suspend for sustained site outage, account cleanup failure or unsafe environment drift; resume after confirming health and resolving the cause. Three infrastructure failures in succession trigger environment investigation, not blind retries.

## Data, defects and reporting
Unique test emails prevent collisions. Account setup uses UI signup; teardown owns deletion. Each failed comparison creates a defect candidate; triage distinguishes product defect, test defect, fixture drift and environment issue before release judgment. Reports distinguish PASS, FAIL, BLOCKED, SKIPPED and NOT EXECUTED. A Jenkins definition runs Maven and archives artifacts even after failure; no successful CI claim without a real server run. Screenshots at meaningful checkpoints and pass/failure completion attach to Allure; generated files are ignored by Git.
