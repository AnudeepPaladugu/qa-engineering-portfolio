# Calculated coverage

Denominators are the selected portfolio scope, not all behavior of Automation Exercise.

| Metric | Calculation | Interpretation |
|---|---|---|
| Functional requirement design coverage | 18/18 = 100% | All defined functional requirements have cases |
| Scenario design coverage | 32/32 = 100% | Each defined scenario has a detailed case |
| Implemented UI automation coverage | 20/32 = 62.5% | Remaining cases are intentionally API/manual |
| Latest executed case coverage | 20/32 = 62.5% | UI cases executed; API/manual pending |
| Latest exercised functional requirements | 16/18 = 88.89% | Two API requirements remain unexecuted |
| Smoke selection | 7/20 UI cases = 35% | Critical confidence subset, all passed in the latest regression |
| Regression selection | 20/20 UI cases = 100% | All selected UI automation cases executed and passed |

The exploratory usability audit targets and framework evidence target are tracked separately. A UI pass percentage must not be described as total application coverage.
