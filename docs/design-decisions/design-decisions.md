# Why this design

| Choice | Reason and tradeoff |
|---|---|
| Java / Selenium | Matches the owner's resume and tests a real browser; slower than API checks but observes customer UI behavior |
| TestNG / Maven | Familiar lifecycle, groups and pinned dependency management; one runner avoids duplicated step layers |
| Page Object Model | Keeps selectors in one place and assertions readable; no PageFactory proxy layer is needed |
| Explicit waits / EAGER load | Synchronize on business controls while avoiding ad-resource delays; genuine intercepted clicks still fail |
| One Chrome session per case | Isolates cart cookies and account state; serial execution limits public-demo load |
| Synthetic signup per account case | Makes credentials reproducible and independent; adds runtime and requires owned cleanup |
| Listener / screenshots / logs | Consistent evidence at start and outcome plus meaningful checkpoints; runtime files stay ignored |
| Allure runtime steps | Reports readable actions and attachments without weaving or additional framework layers |
| Environment configuration | Test passwords stay outside source; `.env.example` is documentation, not an implicit loader |
| Smoke / regression | Smoke concentrates on seven critical checks; regression contains all 20 UI cases |
| Manual Postman API work | Matches the resume's manual REST API skill; no REST Assured dependency is added |
| SQL design only | Public database is unavailable; an unexecuted owned-environment example cannot imply actual DB validation |
| CI deferred | Jenkins skipped at the owner's request because no server is connected |
| No Cucumber/Testim layer | They are resume skills, but adding both would duplicate this small TestNG suite |
| No automatic retries | Preserves failures and avoids turning intermittent behavior into unexplained passes |
| Manual exploratory checks | Keyboard and visual usability need observation; undefined quantity limits need a requirement decision |
| Video deferred | The owner asked for resume-aligned simplicity; screenshots and logs cover this project's evidence needs |
