# QA Documentation Guide

This folder contains the detailed QA documentation behind the project.

## Recommended reading order

1. Discovery: how the application was inspected
2. Requirements: functional requirements, business rules and traceability
3. Analysis: how requirements were interpreted for testing
4. Test Strategy: what was tested and why
5. Test Plan: scope, approach and execution planning
6. Architecture: automation framework design
7. QA Approach: interview-friendly explanation of the testing approach

## Core documents

| Area | Purpose |
|---|---|
| Discovery | [Application inspection](00-discovery/application-inspection.md) |
| Requirements | [Requirements overview](01-requirements/01-requirements-overview.md) |
| Functional requirements | [Detailed functional requirements](01-requirements/02-functional-requirements.md) |
| Traceability | [Requirement traceability matrix](01-requirements/06-requirement-traceability-matrix.md) |
| Analysis | [Requirements analysis](02-analysis/requirements-analysis.md) |
| Test strategy | [Test strategy](03-test-strategy/test-strategy.md) |
| Test plan | [Test plan](04-test-plan/test-plan.md) |
| Architecture | [Automation architecture](architecture/architecture.md) |
| Execution | [How to run](how-to-run.md) |
| QA approach | [Interview walkthrough](qa-approach/interview-walkthrough.md) |

## Supporting material

Database validation is documented as a design because the public application does not provide database access. Design decisions and audit records are retained as supporting evidence rather than being part of the main execution flow.

For the recruiter-facing summary, start with the repository [README](../README.md) and then the [project overview](../project-overview/01-project-overview.md).
