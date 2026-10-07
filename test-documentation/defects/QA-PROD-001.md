# QA-PROD-001: Cart accepts below-minimum quantities and displays a negative total

- Module: product quantity / cart; classification: application validation defect
- Environment: https://automationexercise.com, shared public demo
- Browser: Chrome 155.0.8059.39 / Windows; application build: not exposed
- Severity: High (monetary correctness in the practice cart); priority: High
- Precondition: Fresh guest browser session; product 1 Blue Top costs Rs. 500.
- Steps: (1) open /product_details/1; (2) replace Quantity with -1; (3) click Add to cart; (4) wait for the Added modal / completed request; (5) open /view_cart.
- Expected: The product input explicitly declares min=1; the add action should reject a below-minimum value instead of persisting a negative quantity. This expectation is inferred from the exposed UI constraint and requires product-owner confirmation for final disposition.
- Actual: The quantity input has rangeUnderflow=true, yet the Added modal appears. The cart displays Blue Top, unit price Rs. 500, quantity -1, line total Rs. -500, and Proceed To Checkout. Quantity 0 similarly creates a Rs. 0 line. A positive control of 1 creates Rs. 500.
- Reproducibility: Negative quantity reproduced in 2/2 independent synchronized sessions; zero observed once; positive control observed once.
- Evidence: evidence/exploratory/quantity-first-observation.txt, quantity-reproduction.txt and quantity-synchronized--1.png.
- Logs: The saved observations include DOM min, browser validity, request completion, modal presence and exact cart text.
- Status: OPEN / reported in this portfolio; not submitted to the website owner, and not fixed in the third-party application.
- Related requirement/case: REQ-CART-004 / TC-MAN-003 and TC-UI-021.

No real payment was made and no claim is made about backend settlement. The finding is limited to observed cart validation and displayed totals. The previous undefined-boundary charter was revised transparently after inspecting the actual min=1 constraint.
