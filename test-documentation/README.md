# Test Documentation Guide

This folder contains the detailed test artifacts used by the portfolio.

## What each section means

| Folder / file | Purpose |
|---|---|
| [Test Scenarios](test-scenarios/) | High-level conditions or areas that need to be tested |
| [Test Cases](test-cases/) | Detailed executable test procedures with expected results |
| [Defects](defects/) | Defect records with reproduction and impact details |
| [Execution](execution/) | Recorded test execution results and run context |
| [Coverage Baseline](coverage-baseline.md) | Calculated scope and coverage metrics |
| [Case Index](case-index.json) | Machine-readable traceability index for the selected cases |

### Scenario vs. Test Case

A test scenario answers: What do we need to test?

A test case answers: How exactly do we test it, and what should happen?

Both are intentionally retained because they demonstrate different parts of the QA process.

## Typical QA flow

Requirement -> Scenario -> Test Case -> Execution -> Defect -> Retest / Conclusion

The repository root README provides the recruiter-friendly summary; this folder provides the detailed testing evidence.
