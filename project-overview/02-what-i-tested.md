# What I Tested

This page explains the testing work without requiring knowledge of automation tools.

| Testing Area | What I did | Why it matters |
|---|---|---|
| Authentication | Tested login/account-related behaviour | Ensures users can access the application correctly |
| Catalog | Tested product visibility, details, search and sorting | Protects core shopping functionality |
| Cart | Tested adding/removing items, quantities and totals | Prevents incorrect shopping-cart behaviour |
| Checkout | Tested navigation, required information and order flow | Protects the purchase journey |
| Negative Testing | Used invalid inputs and unexpected values | Finds validation weaknesses |
| Boundary Testing | Tested values around allowed limits | Finds edge-case defects |
| Exploratory Testing | Investigated behaviour outside scripted tests | Finds issues that predefined cases may miss |
| API Testing | Verified API responses and assertions | Checks application behaviour below the UI |
| Regression Testing | Re-ran important existing functionality | Helps detect regressions after changes |
| Defect Reporting | Recorded reproducible issues and evidence | Gives developers enough information to investigate |
| Evidence | Captured screenshots and execution records | Makes results traceable and reviewable |

## Manual to automation decision

Not every test needs automation.

I treated a scenario as a strong automation candidate when it was stable, repeatable, regression-focused and had a clear expected result.

Exploratory, subjective or rapidly changing checks can remain manual.

## Coverage

The project documents 19 observed functional requirements and 33 detailed test cases, with requirement traceability connecting the testing work back to the application requirements.

[Next: Test Coverage](03-test-coverage.md)