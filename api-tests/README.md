# API strategy and execution

The portfolio uses Postman requests and assertions, matching the owner's manual REST API experience. There is no Java API automation framework. The exported collection is independently verified with Postman's official Newman collection runner; this is artifact validation and is not a claim that the Postman desktop GUI was operated.

Source: [official API list](https://automationexercise.com/api_list). Request and response expectations were compared with real discovery requests. Base URL: https://automationexercise.com/api. Current contract: HTTP 200 even for validation failures; JSON responseCode contains 200/400/405. JSON currently arrives with text/html Content-Type, so parse the body explicitly. Do not confuse body code 405 with an HTTP 405 response.

## Import and manual execution

1. Open Postman and import postman/collection.json.
2. Import postman/environment.example.json and select the public demo environment.
3. Send TC-API-001 first; it records current catalog IDs for the empty-search comparison.
4. Send each request once in order. Inspect HTTP status, responseCode, exact message, product/brand fields and the Tests results.
5. Record timestamp, observed body, assertion outcomes and evidence in the execution record. Export a run report if using Collection Runner.

No authentication key is required for these nine cases. Missing verifyLogin inputs and unsupported DELETE are negative validation checks, not valid-login checks. Account creation/update/deletion endpoints are published by the site but excluded from this selected Postman scope; account UI workflows cover actual authentication. PATCH is not published and is excluded.

| Cases | Requests and purpose |
|---|---|
| TC-API-001 / 002 | GET catalog with fixture/field/unique-ID validation; unsupported POST with exact body code/message |
| TC-API-003 / 004 | GET typed brands; unsupported PUT |
| TC-API-005 / 006 / 007 | Search top using name-or-category matching; missing parameter error; empty value compared with current catalog IDs |
| TC-API-008 / 009 | Missing login inputs; unsupported DELETE |

Pre-request script records a UTC timestamp without secrets. Assertions verify transport status, Content-Type presence, body code, exact messages and typed response fields. Unknown maximum lengths and undocumented mutation behavior are outside this scope.

## Optional export verification

[Newman is Postman's official collection runner](https://learning.postman.com/docs/collections/using-newman-cli/installing-running-newman). If Node.js/npm are already available, the following pinned helper command verifies the same exported collection without creating a second API framework:

```sh
npx --yes newman@6.2.1 run postman/collection.json -e postman/environment.example.json --reporters cli,json --reporter-json-export artifacts/postman-run.json
```

Node/Newman is optional verification tooling, not a new portfolio skill requirement. Postman manual import remains the normal user workflow. The helper command must preserve a non-zero exit if assertions fail. Actual verification: nine requests and 40 assertions passed with zero failures. See [recorded results](../evidence/postman/results.json). Two initial failed script attempts are retained, with QA-PM-001 documenting the fix. Manual Postman GUI import/execution remains NOT VERIFIED.
