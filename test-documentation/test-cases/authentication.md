# Authentication detailed cases

Records below contain the latest observed results, timestamps and evidence. The original design baseline was NOT EXECUTED.

## TC-UI-001 â€” Login form exposes required and masked inputs

- Requirement ID: REQ-AUTH-001
- Scenario ID: TS-UI-001
- Module: Authentication
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: Synthetic QA account where required; Blue Top product ID 1; no real personal or payment data.
- Priority: High
- Severity if failed: Major
- Risk: High
- Test type: UI / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: smoke,regression,sanity
- Automation: PortfolioTests.loginForm

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /login. | The Login to your account heading, email field, masked password field and Login button are visible. |
| 2 | Inspect the email required property. | The email field required property is true. |
| 3 | Inspect the password input type and required property. | The password type is password and required is true. |

- Actual result: /login rendered; email/password required=true; password type=password
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:30:14.246294300Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified

## TC-UI-002 â€” Unknown account receives the actual login error

- Requirement ID: REQ-AUTH-002
- Scenario ID: TS-UI-002
- Module: Authentication
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: Synthetic QA account where required; Blue Top product ID 1; no real personal or payment data.
- Priority: High
- Severity if failed: Major
- Risk: High
- Test type: UI / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: regression
- Automation: PortfolioTests.invalidLogin

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /login. | The Login to your account heading, email field, masked password field and Login button are visible. |
| 2 | Enter nobody-<UUID>@example.com as email. | The email field contains the generated unknown address. |
| 3 | Enter a generated invalid test password. | The password field is populated and masked. |
| 4 | Click Login. | The page remains /login and displays Your email or password is incorrect! |

- Actual result: Observed login error: Your email or password is incorrect!; URL path=/login
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:30:09.029225100Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified

## TC-UI-003 â€” Blank email blocks form submission

- Requirement ID: REQ-AUTH-001
- Scenario ID: TS-UI-003
- Module: Authentication
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: Synthetic QA account where required; Blue Top product ID 1; no real personal or payment data.
- Priority: High
- Severity if failed: Major
- Risk: High
- Test type: UI / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: regression
- Automation: PortfolioTests.requiredLoginEmail

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /login. | The Login to your account heading, email field, masked password field and Login button are visible. |
| 2 | Leave email blank. | Email value is empty. |
| 3 | Click Login. | The URL remains /login and the email validity.valueMissing property is true. |

- Actual result: Blank email validity.valueMissing=true; URL path=/login
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:31:38.922457Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified

## TC-UI-004 â€” Create a synthetic account through the UI

- Requirement ID: REQ-AUTH-003
- Scenario ID: TS-UI-004
- Module: Authentication
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: Synthetic QA account where required; Blue Top product ID 1; no real personal or payment data.
- Priority: High
- Severity if failed: Critical
- Risk: High
- Test type: UI / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: smoke,regression,critical
- Automation: PortfolioTests.registerAccount

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /login. | The New User Signup! heading is visible. |
| 2 | Enter the synthetic name QA Portfolio in the signup name field. | The signup name field contains QA Portfolio. |
| 3 | Enter a unique email using the qa-portfolio-<UUID>@example.com pattern. | The signup email field contains that unique email. |
| 4 | Click Signup. | The URL path is /signup and ENTER ACCOUNT INFORMATION is visible. |
| 5 | Enter the configured test-only password. | The password field is populated and has type password. |
| 6 | Enter first name QA. | The First name field contains QA. |
| 7 | Enter last name Portfolio. | The Last name field contains Portfolio. |
| 8 | Enter address Test Street. | The Address field contains Test Street. |
| 9 | Select India as the country. | The Country selection is India. |
| 10 | Enter Andhra Pradesh as the state. | The State field contains Andhra Pradesh. |
| 11 | Enter Vijayawada as the city. | The City field contains Vijayawada. |
| 12 | Enter zipcode 520001. | The Zipcode field contains 520001. |
| 13 | Enter synthetic mobile number 9999999999. | The Mobile Number field contains 9999999999. |
| 14 | Click Create Account. | ACCOUNT CREATED! is visible. |
| 15 | Click Continue. | The home page shows Logged in as QA Portfolio. |

- Actual result: ACCOUNT CREATED! displayed for owned synthetic account; Registration completed; navigation displays Logged in as QA Portfolio
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:31:17.761002800Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified

## TC-UI-005 â€” Authenticate with a newly created account

- Requirement ID: REQ-AUTH-004
- Scenario ID: TS-UI-005
- Module: Authentication
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: Synthetic QA account where required; Blue Top product ID 1; no real personal or payment data.
- Priority: High
- Severity if failed: Critical
- Risk: High
- Test type: UI / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: smoke,regression,critical
- Automation: PortfolioTests.validLogin

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /login. | The New User Signup! heading is visible. |
| 2 | Enter the synthetic name QA Portfolio in the signup name field. | The signup name field contains QA Portfolio. |
| 3 | Enter a unique email using the qa-portfolio-<UUID>@example.com pattern. | The signup email field contains that unique email. |
| 4 | Click Signup. | The URL path is /signup and ENTER ACCOUNT INFORMATION is visible. |
| 5 | Enter the configured test-only password. | The password field is populated and has type password. |
| 6 | Enter first name QA. | The First name field contains QA. |
| 7 | Enter last name Portfolio. | The Last name field contains Portfolio. |
| 8 | Enter address Test Street. | The Address field contains Test Street. |
| 9 | Select India as the country. | The Country selection is India. |
| 10 | Enter Andhra Pradesh as the state. | The State field contains Andhra Pradesh. |
| 11 | Enter Vijayawada as the city. | The City field contains Vijayawada. |
| 12 | Enter zipcode 520001. | The Zipcode field contains 520001. |
| 13 | Enter synthetic mobile number 9999999999. | The Mobile Number field contains 9999999999. |
| 14 | Click Create Account. | ACCOUNT CREATED! is visible. |
| 15 | Click Continue. | The home page shows Logged in as QA Portfolio. |
| 16 | Click Logout. | The URL path is /login and Login to your account is visible. |
| 17 | Enter the newly registered email in the login email field. | The login email field contains the registered synthetic email. |
| 18 | Enter the configured test password in the login password field. | The password field is populated and masked. |
| 19 | Click Login. | The home page shows Logged in as QA Portfolio and Logout is visible. |

- Actual result: ACCOUNT CREATED! displayed for owned synthetic account; Login accepted registered credentials; navigation displays Logged in as QA Portfolio
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:32:12.240145400Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified

## TC-UI-006 â€” Logout removes the authenticated navigation

- Requirement ID: REQ-AUTH-005
- Scenario ID: TS-UI-006
- Module: Authentication
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: Synthetic QA account where required; Blue Top product ID 1; no real personal or payment data.
- Priority: High
- Severity if failed: Major
- Risk: High
- Test type: UI / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: regression
- Automation: PortfolioTests.logout

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /login. | The New User Signup! heading is visible. |
| 2 | Enter the synthetic name QA Portfolio in the signup name field. | The signup name field contains QA Portfolio. |
| 3 | Enter a unique email using the qa-portfolio-<UUID>@example.com pattern. | The signup email field contains that unique email. |
| 4 | Click Signup. | The URL path is /signup and ENTER ACCOUNT INFORMATION is visible. |
| 5 | Enter the configured test-only password. | The password field is populated and has type password. |
| 6 | Enter first name QA. | The First name field contains QA. |
| 7 | Enter last name Portfolio. | The Last name field contains Portfolio. |
| 8 | Enter address Test Street. | The Address field contains Test Street. |
| 9 | Select India as the country. | The Country selection is India. |
| 10 | Enter Andhra Pradesh as the state. | The State field contains Andhra Pradesh. |
| 11 | Enter Vijayawada as the city. | The City field contains Vijayawada. |
| 12 | Enter zipcode 520001. | The Zipcode field contains 520001. |
| 13 | Enter synthetic mobile number 9999999999. | The Mobile Number field contains 9999999999. |
| 14 | Click Create Account. | ACCOUNT CREATED! is visible. |
| 15 | Click Continue. | The home page shows Logged in as QA Portfolio. |
| 16 | Click Logout. | The URL is /login; Signup / Login is visible and Logged in as QA Portfolio is absent. |

- Actual result: ACCOUNT CREATED! displayed for owned synthetic account; Logout navigated to /login; authenticated name absent; Signup / Login visible
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:30:31.114640700Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified

## TC-UI-018 â€” Duplicate signup rejects an existing address

- Requirement ID: REQ-AUTH-003
- Scenario ID: TS-UI-018
- Module: Authentication
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: Synthetic QA account where required; Blue Top product ID 1; no real personal or payment data.
- Priority: High
- Severity if failed: Major
- Risk: High
- Test type: UI / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Chrome baseline for UI/manual; Postman for API
- Groups: regression
- Automation: PortfolioTests.duplicateSignup

| Step | Action | Expected result |
|---|---|---|
| 1 | Navigate to /login. | The New User Signup! heading is visible. |
| 2 | Enter the synthetic name QA Portfolio in the signup name field. | The signup name field contains QA Portfolio. |
| 3 | Enter a unique email using the qa-portfolio-<UUID>@example.com pattern. | The signup email field contains that unique email. |
| 4 | Click Signup. | The URL path is /signup and ENTER ACCOUNT INFORMATION is visible. |
| 5 | Enter the configured test-only password. | The password field is populated and has type password. |
| 6 | Enter first name QA. | The First name field contains QA. |
| 7 | Enter last name Portfolio. | The Last name field contains Portfolio. |
| 8 | Enter address Test Street. | The Address field contains Test Street. |
| 9 | Select India as the country. | The Country selection is India. |
| 10 | Enter Andhra Pradesh as the state. | The State field contains Andhra Pradesh. |
| 11 | Enter Vijayawada as the city. | The City field contains Vijayawada. |
| 12 | Enter zipcode 520001. | The Zipcode field contains 520001. |
| 13 | Enter synthetic mobile number 9999999999. | The Mobile Number field contains 9999999999. |
| 14 | Click Create Account. | ACCOUNT CREATED! is visible. |
| 15 | Click Continue. | The home page shows Logged in as QA Portfolio. |
| 16 | Click Logout. | The URL path is /login. |
| 17 | Enter QA Portfolio in signup name. | The signup name field contains QA Portfolio. |
| 18 | Enter the previously registered email in signup email. | The signup email field contains the existing synthetic account email. |
| 19 | Click Signup. | Email Address already exist! is visible and the URL remains /signup or /login. |

- Actual result: ACCOUNT CREATED! displayed for owned synthetic account; Duplicate signup displayed: Email Address already exist!; URL=/signup
- Status: PASS
- Defect ID: None recorded
- Execution date: 2026-10-07T11:29:49.377161300Z
- Executed by: Codex real Chrome execution
- Evidence location: evidence/latest-regression/results.json; runtime Allure screenshots/logs verified
