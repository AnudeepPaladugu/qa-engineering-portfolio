# QA-PM-001: Postman test-script local name conflicts with built-in globals

- Module: API collection; classification: test artifact defect
- Environment: Newman 6.2.1 / exported Postman v2.1 collection / public API
- Browser: not applicable; application build: not exposed; collection build: SHA-256 recorded in evidence/postman/results.json
- Severity: Major; priority: High
- Preconditions: Initial exported collection used `const data`, then `const responseBody`, in test scripts.
- Reproduce: (1) execute the initial collection export; (2) inspect test-script errors and assertion count.
- Expected: Nine request test scripts run and evaluate transport/body assertions.
- Actual: Each attempt sent nine HTTP requests but all nine test scripts failed with Identifier 'data' has already been declared or Identifier 'responseBody' has already been declared. Zero assertions executed; runner exit 1. HTTP 200 alone did not make these cases pass.
- Reproducibility: All nine scripts in each of two retained attempts.
- Evidence/logs: evidence/postman/initial-script-failures.json; complete runtime exports under ignored artifacts/.
- Fix: Use the scoped name qaPortfolioPayload instead of Postman legacy globals.
- Status: FIXED AND VERIFIED. Final run: nine requests, 40 assertions, zero script/assertion failures; runner exit 0.

This was a collection defect, not an application defect. Failed attempts remain recorded.
