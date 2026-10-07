# QA-FW-001: Allure test entries omit listener-captured outcome attachments

- Module: framework reporting; classification: framework defect
- Environment: Windows, Java 21, Selenium 4.29.0, Allure TestNG 2.29.0
- Browser: Chrome 155.0.8059.39; application build: not exposed
- Framework build: 22b411372bde472f64c8800c0845cd542562b4f3
- Severity: Major; priority: High
- Preconditions: Run smoke or regression with SCREENSHOT_MODE=ALL.
- Reproduce: (1) execute a suite; (2) confirm outcome PNG/log files in artifacts/runs; (3) inspect the corresponding Allure result JSON and test entry.
- Expected: The outcome screenshot and structured log belong to the test's Allure attachments while its lifecycle is active.
- Actual: Many test result entries have zero attachments despite saved local screenshots/logs; completeOrder has its in-body checkpoint but lacks listener outcome attachments.
- Reproducibility: Observed across multiple smoke/regression cases; not a website defect.
- Evidence/logs: Initial Allure results retained locally under artifacts/history; initial regression metadata in evidence/initial-regression/results.json. Runtime files are intentionally ignored by Git.
- Fix: Capture normal test outcomes inside TestNG IHookable while Allure's test lifecycle is active. Keep the listener as fallback for skipped bodies.
- Status: FIXED AND VERIFIED: focused search pass has START/PASS screenshots and structured log on the Allure test; intentional failure has START/FAIL screenshots, log and failure attachment, with Maven exit 1.
