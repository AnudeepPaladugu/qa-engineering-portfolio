# Current regression evidence

Source commit: `290d148b3826804ab3440db5a453e68cb56970b3`. **21 tests: 20 PASS / 1 FAIL**. The failed minimum-quantity guard is a real open product defect, QA-PROD-001. Maven exited 1. Allure has the same counts and verified screenshot/log attachments. Cleanup passed for all 21 cases.

results.json records actual observations and metadata; allure-summary.json is copied from the generated report. Full runtime screenshots, logs and raw Allure results are kept under ignored artifacts/. Curated product-defect evidence is in ../exploratory; the earlier 20/20 evidence is an explicitly historical positive-path baseline.
