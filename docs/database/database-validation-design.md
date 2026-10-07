# Database validation design — NOT EXECUTED

**Database validation was not implemented against the public environment because database access is not available.** No JDBC driver, fabricated connection string or invented public database schema is included.

In an owned environment, request a read-only account scoped to the QA database and approved synthetic records. Confirm the actual schema with developers before adapting the illustrative queries below. These table/column names are hypothetical design examples, not Automation Exercise's discovered schema.

| Validation | Observable evidence required | Why |
|---|---|---|
| Registration persistence | Exactly one row for the generated email; approved profile fields match UI input | Detects missing/duplicate writes |
| Order ownership | The order references the created customer ID | Prevents cross-account data association |
| Order arithmetic | Line totals equal quantity x unit price; header total equals the sum of lines under documented pricing rules | Detects data loss or incorrect totals |
| Referential integrity | No order items reference missing orders/products | Detects broken relationships |
| Positive quantities | No selected order line has quantity <= 0, if approved business rules require positivity | Protects monetary correctness |
| Account deletion | Approved deletion/anonymization policy is reflected; do not assume cascade deletion | Privacy and retention rules can differ |

Workflow: execute the UI case -> capture generated customer/order identifier -> bind it as a parameter in a read-only query -> compare rows with the exact UI fixture -> record query version, environment, row count and redacted result -> retain evidence with the test case ID. SQL runs are BLOCKED until a legitimate environment and actual schema are supplied. Do not scan production records or store customer credentials.

See database-validation.sql for illustrative SELECT-only queries. There is no claim that the public demo uses these tables or enforces these constraints.
