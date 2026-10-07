# Test Scenarios vs. Test Cases

These two folders intentionally serve different purposes.

## Test Scenarios

`test-scenarios/` answers:

> **What should we test?**

A scenario is a high-level testing idea, for example:

- Verify that a user can log in with valid credentials.
- Verify that an invalid login is rejected.
- Verify that a cart rejects a quantity below the allowed minimum.

Scenarios are useful for understanding coverage quickly.

## Test Cases

`test-cases/` answers:

> **Exactly how do we test it?**

A detailed test case contains:

- Preconditions
- Test data
- Step-by-step actions
- Expected results
- Actual results
- Status
- Defect ID
- Execution evidence
- Automation mapping where applicable

## Why both exist

They are not duplicate documentation.

**Scenario = testing idea / coverage**

**Test case = executable procedure / evidence**

The scenario IDs also provide a traceable link between requirements, detailed test cases and automation.
