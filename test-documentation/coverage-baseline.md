# Calculated coverage after scope expansion

All denominators are the selected portfolio scope, not the entire website. The original 32-case baseline expanded to 33 after adding an automated guard for the discovered minimum-quantity defect.

| Metric | Calculation | Meaning |
|---|---|---|
| Functional requirement design coverage | 19/19 = 100% | Every current functional requirement has a case |
| Scenario design coverage | 33/33 = 100% | Every selected scenario has a detailed case |
| Java UI automation coverage | 21/33 = 63.636% | UI case records backed by Java tests |
| Executable UI + Postman checks | 30/33 = 90.909% | Remaining three cases are exploratory inspections |
| Case execution coverage | 33/33 = 100% | All selected records were executed/observed; this is not a pass claim |
| Functional requirements exercised | 19/19 = 100% | Includes the failed quantity requirement |
| Functional requirements satisfying selected checks | 18/19 = 94.737% | REQ-CART-004 remains failed |
| Smoke selection | 8/21 UI cases = 38.095% | Seven pass and one fails within latest regression; separate eight-case smoke run not claimed |
| Regression scope | 21/21 UI cases = 100% | 20 pass / one fail |
| All-case pass rate | 31/33 = 93.939% | Two failures point to one open application defect |

NFR audit targets, unavailable database access and Jenkins deferred at owner request are tracked separately; they are not hidden inside a passing percentage.
