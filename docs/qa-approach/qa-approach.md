# How QA was approached

This is a discovery-driven portfolio, not a claim of employment on Automation Exercise. Results came from real browser/API executions. The owner's resume constraint narrowed the original tool list to a manageable Java/TestNG framework, Postman, SQL design, Allure, Git and Jenkins.

| Stage | What and why | How | Actual result |
|---|---|---|---|
| Requirement understanding | Establish what the live application really offers before writing tests | Inspect official docs, rendered pages and API responses | Account, catalog, cart and checkout scope established; unsupported sorting/order history excluded |
| Risk identification | Focus on account access and monetary correctness | Follow the purchase chain and inspect dependencies | Signup/login, cart totals and checkout were prioritized |
| Test scope | Fit the project to the resume and accessible environment | Select UI automation, Postman contracts and focused exploratory charters | Initially 32 cases; one automated defect guard expanded scope to 33 |
| Strategy | Separate repeatable checks from visual/ambiguous behavior | Define smoke/regression, negative cases and exploratory targets | Serial UI execution; no retries; honest unavailable database/CI status |
| Scenarios | Give every requirement a traceable check | Assign requirement, scenario and case IDs | 19 current functional requirements mapped to 33 cases |
| Case design | Make comparisons observable | Write one action per step and precise text/URL/value expectations | Step-level baseline created before automation; search oracle corrected after real category matching was observed |
| Test data | Avoid collisions and personal information | Unique example.com accounts, configured test password, synthetic address/card data | Owned accounts created/deleted by tests; product 1 used as an explicit fixture |
| Manual/exploratory execution | Investigate keyboard, narrow layout and boundaries | Browser controls plus direct screenshot review; synchronize pending requests | Keyboard and narrow layout passed; min=1 was not enforced during cart addition |
| Defect reporting | Preserve evidence rather than manufacture bugs | Reproduce, distinguish application/framework/design causes, record exact observations | Three project defects fixed; one real quantity validation defect remains open |
| Automation selection | Automate stable customer contracts | Selenium/POM with TestNG groups and explicit waits | 21 UI checks, including a failing regression guard for the open defect |
| Framework design | Keep behavior readable and evidence dependable | Fresh browser, owned cleanup, listener plus lifecycle hook | Allure attachment-order defect found and fixed; failure exit audited |
| API testing | Verify real documented HTTP/body contracts | Postman export; official runner used to validate scripts and assertions | Nine requests and 40 assertions passed; GUI execution not claimed |
| Database strategy | Show SQL reasoning without fictitious access | Read-only hypothetical query design with named parameters | NOT EXECUTED; public database access unavailable |
| CI | Make failures and evidence available in a familiar pipeline | Same Maven commands can be integrated when an owned server is available | Deferred at owner request; no pipeline supplied |
| Evidence | Link observations to cases | UTC/case/method/status files, screenshots, JSON logs and Allure attachments | Original failures retained; curated screenshots published; bulk runtime files ignored |
| Reporting | Explain risk beyond a percentage | Reconcile TestNG, Allure, case records, API assertions and RTM | Negative total remains material even when most checks pass |
| Release recommendation | Protect confidence in the purchase amount | Evaluate open high-risk defect and failure guard | NO-GO for release confidence; website fix requires its owner |

The initial UI-only 20/20 passing baseline remains in evidence/ui-regression. It is historical: exploratory discovery then expanded the requirements and added TC-UI-021. The current suite intentionally flags the product issue. No unsuccessful run is converted into a historical pass.
