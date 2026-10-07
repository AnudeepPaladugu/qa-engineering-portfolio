# Business rules

| Rule | Source and interpretation | Cases |
|---|---|---|
| A registered account is required to proceed from cart to checkout | Observed guest gate and authenticated checkout | TC-UI-014, 015 |
| Line total is unit price multiplied by selected quantity | Observed Rs. 500 x 2 = Rs. 1000 | TC-UI-011, 015 |
| Account email must be unique | Official registration case; formally verify duplicate outcome | TC-UI-018 |
| Required fields are enforced through HTML form constraints | Inspected required properties | TC-UI-003, 017 |
| API responseCode is distinct from HTTP status | Direct discovery; validation requests returned HTTP 200 | TC-API-001 through 009 |

Do not infer tax, shipping, refund, inventory decrement, genuine payment processing or order-history rules. No accessible product-owner specification defines accepted quantity bounds; TC-MAN-003 investigates zero/negative values without manufacturing a confirmed defect.
