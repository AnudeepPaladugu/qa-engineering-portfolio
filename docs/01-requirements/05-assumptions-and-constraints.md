# Assumptions and constraints

- Product ID 1 is the inspected Blue Top fixture at Rs. 500. Fixture drift should produce an explicit test failure for review, not silently select a different product.
- Accounts use unique example.com emails and synthetic address data. TEST_PASSWORD must be configured. Cleanup deletes only the account created by that test; cleanup failure is reported.
- The public demo is shared, has ads and exposes no build identifier. Record browser/platform, UTC timestamp and Git commit with each run.
- No database access is available. SQL examples are an unexecuted design for a hypothetical owned schema.
- No Jenkins server is supplied. The owner requested skipping Jenkins if it causes an issue; CI is deferred and no pipeline is supplied.
- Manual visual/keyboard charters and Postman imports need their own actual execution records. A Java test run does not prove those activities occurred.
- Selenium Manager resolves a matching browser driver. Network access and an installed Chrome are prerequisites.
- Serial execution limits shared-demo load and avoids account/evidence concurrency complexity. No automatic retries.
- Payment values are synthetic practice data. No real card or real customer information is used.
