# Test plan

Project: Automation Exercise QA portfolio. Owner: Anudeep Paladugu. Environment: shared public HTTPS demo. Resources: one QA engineer, Java 21, Maven 3.9+, installed Chrome, network, Postman for manual APIs; CI deferred at owner request.

Objectives: verify the purchase path, reject known invalid inputs, keep traceability from requirements to evidence, and preserve honest release confidence. Features: 19 functional requirements, 21 UI cases, nine manual API cases and three exploratory charters. The approach and exclusions are in the test strategy.

| Stage | Deliverable | Planned effort / dependency |
|---|---|---|
| Discovery | Actual observations and limitations | 1-2 hours; live demo |
| Design | Requirements, strategy, plan, scenarios and step-level cases | 3-4 hours; discovery reviewed |
| Framework | POM, TestNG suites, evidence and Allure | 4-6 hours; case baseline |
| Execution | Smoke/regression, manual/API records, defects and reporting | 3-5 hours; working framework |
| Delivery | README, final reports, audit and incremental commits | 1-3 hours; reviewed execution |

Effort estimates are planning ranges, not reported time spent. Each validated stage is pushed before the next starts.

Data: test-only password from environment, UUID-based example.com emails, synthetic address, inspected Blue Top fixture and simulated card input. Main risks are ads/outages, fixture drift, cleanup failure and missing Jenkins/database access. Mitigations: explicit waits, isolated sessions, low-volume serial execution, exact assertions, owned cleanup, and clear unavailable/NOT VERIFIED statuses.

Entry: URL health, prerequisites, credentials and reviewed design. Exit: critical smoke pass, regression reviewed, no unresolved high-severity reproducible product defect, traceability/evidence complete for executed scope. Suspension: persistent outage, inability to delete created test accounts, or changed application contract. Resumption: health check, cleanup resolution and updated baseline where justified. Release recommendation applies only to the executed portfolio scope.

Current scope note: the confirmed quantity defect expanded the inventory to 33 cases. Both smoke and regression include TC-UI-021 and currently return non-zero. See suite-selection.md (in docs/03-test-strategy) and the final execution summary.
