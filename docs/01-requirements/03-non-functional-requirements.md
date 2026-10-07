# Non-functional requirements

These project quality targets are not an invented website SLA.

| ID / title | Description and acceptance criteria | Source | Priority / business risk | Dependencies | Testable / related cases |
|---|---|---|---|---|---|
| NFR-001 / Reproducibility | A clean Java 21 and Maven checkout can run smoke tests using the documented command; dependency versions are pinned | Portfolio brief | High / reviewer cannot reproduce results | Browser/network | Yes / setup audit |
| NFR-002 / Evidence integrity | Failed UI tests stay failed; screenshot or explicit capture error, stack trace and logs are retained with case ID | Portfolio brief | High / false release confidence | TestNG listener | Yes / evidence fault-injection audit |
| NFR-003 / Credential hygiene | Credentials come from environment/system properties; passwords are not logged or committed | Portfolio brief | High / secret exposure | Configuration | Yes / source audit |
| NFR-004 / Keyboard operability | Login controls can be reached without a keyboard trap | QA usability target | Medium / keyboard users blocked | Headed browser | Yes / TC-MAN-001 |
| NFR-005 / Narrow viewport | Search and catalog remain operable at 390 x 844 | QA usability target | Medium / narrow-screen buyers blocked | Headed browser | Yes / TC-MAN-002 |
| NFR-006 / Measured duration | Report observed execution duration; make no latency SLA assertion | No product SLA available | Medium / unsupported performance claim | Actual run | Yes / execution report |
