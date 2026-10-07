# Requirements analysis

The application provides a guest shopping session and a registered-customer session. There is no inspected administrator role. Account registration, cart totals and simulated order confirmation are the highest-risk chain because failures there prevent the practice purchase workflow. Authentication and checkout depend on account data; cart depends on product identity and price.

Automate repeatable DOM assertions: required fields, login errors, unique signup, catalog/search, fixture details, cart arithmetic/removal/persistence, checkout gating, address review and order confirmation. Stable `data-qa` attributes and meaningful IDs reduce locator churn. Read navigation and totals rather than asserting only that a click occurred.

Keep keyboard and responsive visual assessment manual because a passing element-presence assertion cannot establish usability. Investigate zero/negative quantity as an exploratory question; no product-owner rule defines the boundary. Never turn a suspicion into a defect without an agreed expected result.

The official APIs support catalog/brand reads, search, account lifecycle and login validation. The initial Postman scope selects nine read/validation contracts, including supported GET/POST and unsupported PUT/DELETE behavior. Account mutation APIs are documented as an optional extension; UI registration supplies the automation's accounts, keeping API work manual and aligned with the resume.

Database validation was not implemented against the public environment because database access is not available. A SQL design will show account/order referential checks in an owned environment without implying they ran.

Security considerations are limited to masking credentials, required inputs, logout navigation and synthetic data hygiene. Session-token invalidation, penetration testing, load testing and payment security certification require an owned environment and are excluded. Re-running the selected UI suite forms regression; only the critical shopping/authentication chain forms smoke.
