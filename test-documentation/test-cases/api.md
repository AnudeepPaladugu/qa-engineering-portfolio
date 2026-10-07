# API detailed cases

Status baseline: NOT EXECUTED. Test execution must record an observed result, timestamp and evidence rather than copy the expected result.

## TC-API-001 — GET /api/productsList — contract validation

- Requirement ID: REQ-API-001
- Scenario ID: TS-API-001
- Module: API
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: null
- Priority: High
- Severity if failed: Major
- Risk: Medium
- Test type: API / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Postman collection via Newman; Postman GUI import/execution NOT VERIFIED
- Groups: manual-api
- Automation: Manual

| Step | Action | Expected result |
|---|---|---|
| 1 | Set api_base_url to https://automationexercise.com/api. | The request URL resolves to https://automationexercise.com/api/productsList. |
| 2 | Select HTTP method GET. | The request method is GET. |
| 3 | Leave the request body empty. | Request data matches the specified form fields; omitted fields stay omitted. |
| 4 | Send the request once. | HTTP status is 200; parse the body as JSON despite the text/html Content-Type. |
| 5 | Inspect responseCode and response fields. | Body responseCode is 200; products array is non-empty; ID 1 has name Blue Top, price Rs. 500 and brand Polo. |

- Actual result: HTTP 200; Content-Type text/html; charset=utf-8; responseCode 200; message None; products 34; brands 0; all 6 Postman assertions passed.
- Status: PASS
- Defect ID: QA-PM-001 (fixed collection defect; initial failures retained)
- Execution date: 2026-10-07T11:11:14.843000+00:00
- Executed by: Codex exported Postman collection verification using official Newman 6.2.1
- Evidence location: evidence/postman/results.json; original failed attempts in evidence/postman/initial-script-failures.json

## TC-API-002 — POST /api/productsList — contract validation

- Requirement ID: REQ-API-001
- Scenario ID: TS-API-002
- Module: API
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: {}
- Priority: Medium
- Severity if failed: Minor
- Risk: Medium
- Test type: API / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Postman collection via Newman; Postman GUI import/execution NOT VERIFIED
- Groups: manual-api
- Automation: Manual

| Step | Action | Expected result |
|---|---|---|
| 1 | Set api_base_url to https://automationexercise.com/api. | The request URL resolves to https://automationexercise.com/api/productsList. |
| 2 | Select HTTP method POST. | The request method is POST. |
| 3 | Configure form-urlencoded body {}. | Request data matches the specified form fields; omitted fields stay omitted. |
| 4 | Send the request once. | HTTP status is 200; parse the body as JSON despite the text/html Content-Type. |
| 5 | Inspect responseCode and response fields. | Body responseCode is 405; message equals This request method is not supported.. |

- Actual result: HTTP 200; Content-Type text/html; charset=utf-8; responseCode 405; message 'This request method is not supported.'; products 0; brands 0; all 4 Postman assertions passed.
- Status: PASS
- Defect ID: QA-PM-001 (fixed collection defect; initial failures retained)
- Execution date: 2026-10-07T11:11:14.843000+00:00
- Executed by: Codex exported Postman collection verification using official Newman 6.2.1
- Evidence location: evidence/postman/results.json; original failed attempts in evidence/postman/initial-script-failures.json

## TC-API-003 — GET /api/brandsList — contract validation

- Requirement ID: REQ-API-001
- Scenario ID: TS-API-003
- Module: API
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: null
- Priority: Medium
- Severity if failed: Minor
- Risk: Medium
- Test type: API / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Postman collection via Newman; Postman GUI import/execution NOT VERIFIED
- Groups: manual-api
- Automation: Manual

| Step | Action | Expected result |
|---|---|---|
| 1 | Set api_base_url to https://automationexercise.com/api. | The request URL resolves to https://automationexercise.com/api/brandsList. |
| 2 | Select HTTP method GET. | The request method is GET. |
| 3 | Leave the request body empty. | Request data matches the specified form fields; omitted fields stay omitted. |
| 4 | Send the request once. | HTTP status is 200; parse the body as JSON despite the text/html Content-Type. |
| 5 | Inspect responseCode and response fields. | Body responseCode is 200; brands array is non-empty; each brand has id and brand. |

- Actual result: HTTP 200; Content-Type text/html; charset=utf-8; responseCode 200; message None; products 0; brands 34; all 4 Postman assertions passed.
- Status: PASS
- Defect ID: QA-PM-001 (fixed collection defect; initial failures retained)
- Execution date: 2026-10-07T11:11:14.843000+00:00
- Executed by: Codex exported Postman collection verification using official Newman 6.2.1
- Evidence location: evidence/postman/results.json; original failed attempts in evidence/postman/initial-script-failures.json

## TC-API-004 — PUT /api/brandsList — contract validation

- Requirement ID: REQ-API-001
- Scenario ID: TS-API-004
- Module: API
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: {}
- Priority: Medium
- Severity if failed: Minor
- Risk: Medium
- Test type: API / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Postman collection via Newman; Postman GUI import/execution NOT VERIFIED
- Groups: manual-api
- Automation: Manual

| Step | Action | Expected result |
|---|---|---|
| 1 | Set api_base_url to https://automationexercise.com/api. | The request URL resolves to https://automationexercise.com/api/brandsList. |
| 2 | Select HTTP method PUT. | The request method is PUT. |
| 3 | Configure form-urlencoded body {}. | Request data matches the specified form fields; omitted fields stay omitted. |
| 4 | Send the request once. | HTTP status is 200; parse the body as JSON despite the text/html Content-Type. |
| 5 | Inspect responseCode and response fields. | Body responseCode is 405; message equals This request method is not supported.. |

- Actual result: HTTP 200; Content-Type text/html; charset=utf-8; responseCode 405; message 'This request method is not supported.'; products 0; brands 0; all 4 Postman assertions passed.
- Status: PASS
- Defect ID: QA-PM-001 (fixed collection defect; initial failures retained)
- Execution date: 2026-10-07T11:11:14.843000+00:00
- Executed by: Codex exported Postman collection verification using official Newman 6.2.1
- Evidence location: evidence/postman/results.json; original failed attempts in evidence/postman/initial-script-failures.json

## TC-API-005 — POST /api/searchProduct — contract validation

- Requirement ID: REQ-API-002
- Scenario ID: TS-API-005
- Module: API
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: {"search_product": "top"}
- Priority: High
- Severity if failed: Major
- Risk: Medium
- Test type: API / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Postman collection via Newman; Postman GUI import/execution NOT VERIFIED
- Groups: manual-api
- Automation: Manual

| Step | Action | Expected result |
|---|---|---|
| 1 | Set api_base_url to https://automationexercise.com/api. | The request URL resolves to https://automationexercise.com/api/searchProduct. |
| 2 | Select HTTP method POST. | The request method is POST. |
| 3 | Configure form-urlencoded body {"search_product": "top"}. | Request data matches the specified form fields; omitted fields stay omitted. |
| 4 | Send the request once. | HTTP status is 200; parse the body as JSON despite the text/html Content-Type. |
| 5 | Inspect responseCode and response fields. | Body responseCode is 200; products array is non-empty; each returned product contains top in its name or category, ignoring case. |

- Actual result: HTTP 200; Content-Type text/html; charset=utf-8; responseCode 200; message None; products 14; brands 0; all 5 Postman assertions passed.
- Status: PASS
- Defect ID: QA-PM-001 (fixed collection defect; initial failures retained)
- Execution date: 2026-10-07T11:11:14.843000+00:00
- Executed by: Codex exported Postman collection verification using official Newman 6.2.1
- Evidence location: evidence/postman/results.json; original failed attempts in evidence/postman/initial-script-failures.json

## TC-API-006 — POST /api/searchProduct — contract validation

- Requirement ID: REQ-API-002
- Scenario ID: TS-API-006
- Module: API
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: {}
- Priority: High
- Severity if failed: Major
- Risk: Medium
- Test type: API / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Postman collection via Newman; Postman GUI import/execution NOT VERIFIED
- Groups: manual-api
- Automation: Manual

| Step | Action | Expected result |
|---|---|---|
| 1 | Set api_base_url to https://automationexercise.com/api. | The request URL resolves to https://automationexercise.com/api/searchProduct. |
| 2 | Select HTTP method POST. | The request method is POST. |
| 3 | Configure form-urlencoded body {}. | Request data matches the specified form fields; omitted fields stay omitted. |
| 4 | Send the request once. | HTTP status is 200; parse the body as JSON despite the text/html Content-Type. |
| 5 | Inspect responseCode and response fields. | Body responseCode is 400; message equals Bad request, search_product parameter is missing in POST request.. |

- Actual result: HTTP 200; Content-Type text/html; charset=utf-8; responseCode 400; message 'Bad request, search_product parameter is missing in POST request.'; products 0; brands 0; all 4 Postman assertions passed.
- Status: PASS
- Defect ID: QA-PM-001 (fixed collection defect; initial failures retained)
- Execution date: 2026-10-07T11:11:14.843000+00:00
- Executed by: Codex exported Postman collection verification using official Newman 6.2.1
- Evidence location: evidence/postman/results.json; original failed attempts in evidence/postman/initial-script-failures.json

## TC-API-007 — POST /api/searchProduct — empty input

- Requirement ID: REQ-API-002
- Scenario ID: TS-API-007
- Module: API
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: {"search_product": ""}
- Priority: Medium
- Severity if failed: Minor
- Risk: Medium
- Test type: API / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Postman collection via Newman; Postman GUI import/execution NOT VERIFIED
- Groups: manual-api
- Automation: Manual

| Step | Action | Expected result |
|---|---|---|
| 1 | Set api_base_url to https://automationexercise.com/api. | The request URL resolves to https://automationexercise.com/api/searchProduct. |
| 2 | Select HTTP method POST. | The request method is POST. |
| 3 | Configure form-urlencoded body {"search_product": ""}. | Request data matches the specified form fields; omitted fields stay omitted. |
| 4 | Send the request once. | HTTP status is 200; parse the body as JSON despite the text/html Content-Type. |
| 5 | Inspect responseCode and response fields. | Body responseCode is 200; products is a non-empty array; compare IDs with a fresh productsList response. |

- Actual result: HTTP 200; Content-Type text/html; charset=utf-8; responseCode 200; message None; products 34; brands 0; all 5 Postman assertions passed.
- Status: PASS
- Defect ID: QA-PM-001 (fixed collection defect; initial failures retained)
- Execution date: 2026-10-07T11:11:14.843000+00:00
- Executed by: Codex exported Postman collection verification using official Newman 6.2.1
- Evidence location: evidence/postman/results.json; original failed attempts in evidence/postman/initial-script-failures.json

## TC-API-008 — POST /api/verifyLogin — contract validation

- Requirement ID: REQ-API-002
- Scenario ID: TS-API-008
- Module: API
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: {}
- Priority: Medium
- Severity if failed: Minor
- Risk: Medium
- Test type: API / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Postman collection via Newman; Postman GUI import/execution NOT VERIFIED
- Groups: manual-api
- Automation: Manual

| Step | Action | Expected result |
|---|---|---|
| 1 | Set api_base_url to https://automationexercise.com/api. | The request URL resolves to https://automationexercise.com/api/verifyLogin. |
| 2 | Select HTTP method POST. | The request method is POST. |
| 3 | Configure form-urlencoded body {}. | Request data matches the specified form fields; omitted fields stay omitted. |
| 4 | Send the request once. | HTTP status is 200; parse the body as JSON despite the text/html Content-Type. |
| 5 | Inspect responseCode and response fields. | Body responseCode is 400; message equals Bad request, email or password parameter is missing in POST request.. |

- Actual result: HTTP 200; Content-Type text/html; charset=utf-8; responseCode 400; message 'Bad request, email or password parameter is missing in POST request.'; products 0; brands 0; all 4 Postman assertions passed.
- Status: PASS
- Defect ID: QA-PM-001 (fixed collection defect; initial failures retained)
- Execution date: 2026-10-07T11:11:14.843000+00:00
- Executed by: Codex exported Postman collection verification using official Newman 6.2.1
- Evidence location: evidence/postman/results.json; original failed attempts in evidence/postman/initial-script-failures.json

## TC-API-009 — DELETE /api/verifyLogin — contract validation

- Requirement ID: REQ-API-002
- Scenario ID: TS-API-009
- Module: API
- Objective: Observe and compare the specific outcomes in each step below.
- Preconditions: Live demo reachable; fresh guest browser/session; TEST_PASSWORD configured for account cases; cleanup required for accounts created by this case.
- Test data: null
- Priority: Medium
- Severity if failed: Minor
- Risk: Medium
- Test type: API / functional, with negative and edge cases as indicated by the title
- Environment: https://automationexercise.com; shared public demo; build not exposed
- Browser/client: Postman collection via Newman; Postman GUI import/execution NOT VERIFIED
- Groups: manual-api
- Automation: Manual

| Step | Action | Expected result |
|---|---|---|
| 1 | Set api_base_url to https://automationexercise.com/api. | The request URL resolves to https://automationexercise.com/api/verifyLogin. |
| 2 | Select HTTP method DELETE. | The request method is DELETE. |
| 3 | Leave the request body empty. | Request data matches the specified form fields; omitted fields stay omitted. |
| 4 | Send the request once. | HTTP status is 200; parse the body as JSON despite the text/html Content-Type. |
| 5 | Inspect responseCode and response fields. | Body responseCode is 405; message equals This request method is not supported.. |

- Actual result: HTTP 200; Content-Type text/html; charset=utf-8; responseCode 405; message 'This request method is not supported.'; products 0; brands 0; all 4 Postman assertions passed.
- Status: PASS
- Defect ID: QA-PM-001 (fixed collection defect; initial failures retained)
- Execution date: 2026-10-07T11:11:14.843000+00:00
- Executed by: Codex exported Postman collection verification using official Newman 6.2.1
- Evidence location: evidence/postman/results.json; original failed attempts in evidence/postman/initial-script-failures.json
