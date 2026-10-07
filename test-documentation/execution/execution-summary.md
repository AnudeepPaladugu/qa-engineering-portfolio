# Test execution report — 7 October 2026

## Latest UI regression

| Metric | Actual result |
|---|---|
| Total UI cases / passed / failed / skipped | 20 / 20 / 0 / 0 |
| Blocked UI cases | 0 |
| UI pass / fail percentage | 100% / 0% of 20 executed UI cases |
| Allure execution window | 231.753 seconds |
| Sum of recorded test-body durations | 156.337 seconds; setup/cleanup are additional |
| Account/session cleanup records | 20 PASS / 0 FAIL |
| Critical failures | 0 |
| Browser / platform | Chrome 155.0.8059.39 / Windows |
| Environment / application build | Shared public demo / build not exposed |
| Tested Git commit | 8bbd37f4d61ee91603df2763f9b61ba467a9d27e |
| First / last result timestamp (UTC) | 2026-10-07T11:01:28.838803600Z / 2026-10-07T11:05:16.160644100Z |
| Executor | Codex real Chrome execution |
| TestNG / Maven | 20 cases, zero failures; Maven exit 0 |
| Allure | 20 passed; every test has start/outcome screenshots and structured-log attachments; 61 direct attachments verified |

## History and scope

Smoke initially passed 7/7. The first complete regression was 19 PASS / 1 FAIL (Maven exit 1). QA-DES-001 corrected a name-only search oracle to account for category matching; QA-FW-001 corrected Allure attachment timing. Focused pass and intentional failure retests verified both fixes before this complete rerun. Original failures were retained in evidence/initial-regression/results.json; they are not converted into initial passes.

Across the planned 32 case records at this checkpoint: PASS 20, FAIL 0 latest, BLOCKED 0, SKIPPED 0, NOT EXECUTED 12 (nine Postman/manual API cases and three exploratory charters). Product defects: none reproducibly identified in this executed UI scope. Project defects: two fixed and verified. No Jenkins run is claimed.

QA recommendation: **CONDITIONAL GO for the executed customer UI scope**. The 20-case regression and all seven critical smoke members passed, but API/manual checks and Jenkins verification remain pending. A 100% UI pass rate does not establish complete website quality or payment-security readiness.

## Postman export verification

Nine API cases passed through the official Newman 6.2.1 collection runner: 40 assertions, zero failures, 7.765 seconds total. The request/response observations and collection SHA-256 are in evidence/postman/results.json. Two initial script failures were fixed and retained under QA-PM-001. This does not claim manual execution in the Postman GUI.

Latest planned-case totals: PASS 29, FAIL 0, BLOCKED 0, SKIPPED 0, NOT EXECUTED 3 (exploratory charters). Executed-case pass rate 29/29 = 100%; case execution coverage 29/32 = 90.625%. All 18 defined functional requirements now have executed checks. Jenkins and database execution remain unavailable.
