# Defects Found

## QA-PROD-001 — Negative quantity accepted

### What I found

During exploratory testing, I investigated quantity handling in the shopping cart.

A quantity of **-1** was accepted and resulted in a **negative cart total**.

### Expected behaviour

The application should reject quantities below the minimum allowed quantity of 1.

### Actual behaviour

The negative quantity was accepted and the cart calculation produced an incorrect negative amount.

### Why this is important

Incorrect quantity validation can result in incorrect pricing information being shown to a customer.

### Evidence

[Full defect report](../test-documentation/defects/QA-PROD-001.md)

[Latest execution evidence](../evidence/latest-regression/README.md)

## Other documented defects

The repository also contains separate documentation for design, framework and Postman-related findings where applicable.

See [all defect reports](../test-documentation/defects/).

[Next: Automation Overview](05-automation-overview.md)