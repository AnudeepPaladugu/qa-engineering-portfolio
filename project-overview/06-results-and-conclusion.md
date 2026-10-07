# Results & Conclusion

## Latest documented execution

| Area | Result |
|---|---|
| Java UI regression | 20 passed, 1 failed |
| Postman API verification | 9 passed, 0 failed |
| Exploratory checks | 2 passed, 1 failed |
| Total case records | 31 |
| Total failures | 2 |

The two failures point to the same application defect involving negative cart quantity handling.

## QA recommendation

### NO-GO

The recommendation is to fix the identified application defect and retest before treating the current build as acceptable.

This is an important part of the project: QA is not only about running tests. It is also about interpreting evidence and communicating the release risk clearly.

## What the project demonstrates

The portfolio demonstrates a complete QA workflow:

```text
Requirements
   ↓
Test Design
   ↓
Manual Execution
   ↓
Exploratory Testing
   ↓
Defect Reporting
   ↓
Automation
   ↓
API Testing
   ↓
Evidence
   ↓
QA Recommendation
```

## Supporting evidence

- [Final execution summary](../test-documentation/execution/execution-summary.md)
- [Latest regression evidence](../evidence/latest-regression/README.md)
- [Postman evidence](../evidence/postman/README.md)
- [Defect report](../test-documentation/defects/QA-PROD-001.md)

## Important limitation

The application under test is a public third-party demo. The portfolio can identify and document application defects, but it cannot change the external application itself.
