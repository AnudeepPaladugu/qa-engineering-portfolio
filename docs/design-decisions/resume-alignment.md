# Resume-aligned project scope

The owner requested that this project use skills listed in their resume and avoid excessive framework complexity. This instruction supersedes conflicting technology choices in the initial brief.

| Resume skill | Project use |
|---|---|
| Java, Selenium WebDriver, TestNG, POM, Maven | UI automation with a small page-object framework |
| Functional, regression, smoke, sanity, exploratory, integration, edge-case testing | Traceable test design and execution |
| Postman, manual REST API testing, HTTP methods and status codes | Importable API collection and recorded manual API observations |
| SQL and database validation | SQL validation design for an owned environment; public DB access is unavailable |
| Allure Reports | Test results with screenshots and failure details |
| Git | Incremental validated commits |
| Jenkins | Deferred at the owner's request because no Jenkins server is connected |
| Jira, Zephyr, Agile/Scrum | Portable defect/test records suitable for importing; no claim of integration with a live Jira project |

REST Assured and GitHub Actions are removed from the implementation scope because the resume lists manual Postman API testing and Jenkins. Cucumber and Testim are listed but are not required for every project; adding a second UI execution layer would duplicate this project's TestNG cases. AI chatbot testing is outside scope because this application has no chatbot.

Keep a single browser per test, run serially by default, use explicit waits, and avoid retrying failed tests automatically. Use TestNG lifecycle methods and one evidence listener. Screenshots and logs are the default evidence. Browser video is deferred to avoid adding a separate recording technology outside the resume-aligned scope.

The private resume file and its personal details are not copied into this public repository.
