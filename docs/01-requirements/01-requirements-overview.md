# Requirements overview

This is a reverse-engineered test baseline for Automation Exercise's public demo, not a product-owner-approved specification. Sources are direct discovery, inspected DOM forms, and the site's published test cases/API list. Observations and documented expectations are labeled separately where necessary.

Critical path: register or login -> product -> quantity/cart -> authenticated review -> simulated payment -> confirmation. Logout and removal protect session hygiene and correction workflows. There are 18 functional requirements. Non-functional expectations are project quality targets, not website SLA commitments.

The initial broad brief is narrowed by the owner's resume instruction: UI automation uses Java/Selenium/TestNG/POM/Maven/Allure; API cases are Postman/manual REST; CI uses a Jenkins definition. Video, REST Assured, live database access, live Jira integration, and GitHub Actions are outside this agreed implementation scope.
