# Final repository audit

Audited 7 October 2026. The portfolio implementation is delivered; the tested application has one open defect and the QA recommendation remains NO-GO.

| Check | Evidence / disposition |
|---|---|
| Live application and observed behavior | Discovery records plus real Chrome/API execution; shared demo build unavailable |
| Requirements and traceability | 19 functional requirements; 33 unique cases; each case appears once in RTM |
| Framework and assertions | Java/Selenium/TestNG/POM/Maven executed; 21 latest UI results, 20 PASS / 1 FAIL |
| Current smoke selection | Eight cases, seven PASS / one FAIL within regression; original seven-case smoke passed separately |
| Failure integrity | Negative-quantity guard remains failed; Maven exit 1; independent intentional failure audit verified evidence capture |
| Cleanup and reporting | All 21 cleanup results PASS; Allure counts agree; 66 direct attachments exist |
| API verification | Nine collection requests; 40 assertions PASS; committed collection SHA-256 matches executed artifact |
| Exploratory evidence | Three agent-assisted checks; two PASS / one FAIL; keyboard, narrow viewport and synchronized quantity observations retained |
| Documentation | Detailed cases, actual results, exact assertions, risks, strategy, plan, defects, architecture and QA explanation included |
| Links and repository hygiene | Relative Markdown links checked; whitespace checked; generated runtime output, local tools, private resume and .env excluded |
| Avoiding hidden failures | No automatic retries, Thread.sleep or forced JavaScript clicks; original failed histories retained |
| Source identity | Latest UI run used 290d148b3826804ab3440db5a453e68cb56970b3; final delivery edits are documentation/report changes |
| Reproduction | Fresh GitHub clone at 14b3fdebb57ce2e2496366d2f80574ab4869dba7 compiled and passed TC-UI-011: one test, zero failures/errors/skips, Maven exit 0; [record](../evidence/clean-clone-verification.json). This was a representative check, not a repeated full suite |
| Jenkins / CI artifacts | DEFERRED at owner's request because no server is connected; no pipeline supplied |
| Database | Design-only SQL; no public database credentials or execution claimed |
| Other broad-brief features | Video, GitHub Actions, REST Assured and duplicate UI frameworks excluded under the owner's resume/simplicity instruction |

No release sign-off, human exploratory certification, third-party bug fix, or successful CI run is claimed. Retest QA-PROD-001 after the application owner fixes it, then rerun smoke and regression before revising the recommendation.
