# Final execution report — 7 October 2026

**QA recommendation: NO-GO for release confidence.** The public application's quantity input declares min=1, but Add to cart persists -1 and displays Rs. -500. QA-PROD-001 remains OPEN. A high overall pass percentage does not resolve this monetary validation risk.

| Scope | Total case records | PASS | FAIL | BLOCKED | SKIPPED | NOT EXECUTED |
|---|---:|---:|---:|---:|---:|---:|
| Latest Java UI regression | 21 | 20 | 1 | 0 | 0 | 0 |
| Postman collection verification | 9 | 9 | 0 | 0 | 0 | 0 |
| Agent-assisted exploratory inspection | 3 | 2 | 1 | 0 | 0 | 0 |
| Total | 33 | 31 | 2 | 0 | 0 | 0 |

Overall case pass rate: 31/33 = **93.939%**. Fail rate: 2/33 = **6.061%**. The two failed cases (TC-UI-021 and TC-MAN-003) identify one product defect, not two different bugs. Critical automated failures: one. The current eight-member smoke subset has seven passes and the same failed quantity guard within this regression; a separate eight-case smoke run is not claimed. The original seven-case smoke run passed before scope expansion.

## Execution context and evidence

- Tested UI Git commit: `290d148b3826804ab3440db5a453e68cb56970b3`. Later delivery changes are documentation/report changes, not a claim of re-executing another UI source version.
- Environment: https://automationexercise.com; shared public demo; application build identifier not exposed.
- Browser/platform: Chrome 155.0.8059.39 / Windows.
- UI Allure execution window: 229.524 seconds. Sum of recorded UI test-body durations: 153.634 seconds; setup/cleanup and report generation are additional.
- UI cleanup: 21 PASS / 0 FAIL. TestNG: 21 tests, one failure, zero skipped; Maven exit **1**. This is the application-defect result, not a suppressed or expected-pass exception.
- Allure: 20 passed / one failed / zero broken / zero skipped; 66 direct screenshot/log/failure attachments checked for existing files. Nested checkpoints provide additional evidence.
- API client: exported Postman collection verified with official Newman 6.2.1; nine requests, **40 assertions passed**, zero failures, 7.765 seconds. Postman GUI operation was not claimed. Collection SHA-256: `e1f0a83dfdbdf7b94583d8930ac4ffeb60cf33ee9a92db055d4ed4d833c450dd`.
- Manual-style observations: agent-assisted browser input and screenshot review, not a human sign-off. Keyboard caret and 390x844 layout evidence are published.
- Execution date: 7 October 2026; individual records use UTC timestamps. Executor: Codex using real Chrome/HTTP executions.

## Defects and history

QA-FW-001 (Allure lifecycle attachments), QA-DES-001 (name-only search oracle), and QA-PM-001 (Postman sandbox variable conflict) were fixed and verified. QA-PROD-001 remains OPEN in the third-party site. The initial 19/20 regression, subsequent 20/20 positive baseline, failed Postman script attempts and focused failure audits remain available in evidence/. They are not converted into initial passes.

## Limits and disposition

This recommendation concerns the selected portfolio scope. It is not authority to release the public website. The input minimum is an observed UI contract inferred from the DOM; the website owner must confirm the requirement and fix the application. Do not skip the guard or mark it expected-pass to get a green build. Retest the defect after an owner-side fix, then rerun smoke/regression and reassess.

Jenkins and downloadable CI artifacts: **DEFERRED at the owner's request — no Jenkins server connected**. Database execution: **NOT IMPLEMENTED — public database access unavailable**; SQL design is illustrative and unexecuted. These unavailable integrations are not included in the 33 executable/observational case records and are not counted as passes.
