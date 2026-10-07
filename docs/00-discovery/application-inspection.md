# Application inspection

Inspection date: 7 October 2026. Application: **Automation Exercise**.
URL: https://automationexercise.com. Type: public e-commerce QA practice site.
Environment: shared public demo; application build identifier is not exposed.
API base URL: https://automationexercise.com/api.
Public database access: unavailable. Public shared test credentials: none identified.

## Why this application

The site explicitly offers UI and API testing practice. Its catalog, cart and account-dependent checkout provide connected business workflows. The site's own [test cases](https://automationexercise.com/test_cases) and [API list](https://automationexercise.com/api_list) provide sources that can be compared with observed behavior. Tests will use synthetic accounts and low request volumes.

## Observed behavior

The following observations came from HTTP requests and a real headless Chrome browser, rather than inferred feature names:

| Area | Observation | Evidence |
|---|---|---|
| Login | `/login` renders separate Login and New User Signup forms; email and password are required; password input type is `password` | Saved page inspection and browser rendering |
| Catalog | `/products` renders product cards and the Search Product field | Saved page and browser rendering |
| Product | `/product_details/1` displays Blue Top, Rs. 500, In Stock, New and Polo; quantity initially 1 | Saved page and browser rendering |
| Cart | Adding Blue Top with quantity 2 produces a cart row with unit price Rs. 500 and total Rs. 1000 | `evidence/discovery/cart-observation.txt` |
| Empty cart | A fresh session at `/view_cart` displays `Cart is empty!` | Saved page and browser rendering |
| Guest checkout | Proceed To Checkout displays `Register / Login account to proceed on checkout.` | `evidence/discovery/guest-checkout-observation.txt` |
| API | Catalog endpoint returned HTTP 200, JSON `responseCode: 200` and 34 products | `evidence/discovery/api-observations.json` |
| API validation | Unsupported methods return HTTP 200 with body code 405; missing search parameter returns HTTP 200 with body code 400 | Same API observations |
| Empty API search | Empty search value returned all 34 products; omission and empty value have different behavior | Same API observations |

These are discovery observations, not execution records for test cases that have not yet been designed. Snapshot product counts are diagnostic data, not permanent assertions.

## Boundaries and limitations

- Ads and external resources can delay navigation or intercept clicks. Tests should report interference rather than silently remove page elements.
- No public database connection or deployed build identifier is available.
- No product sorting or persistent order-history feature was identified in the inspected pages; these are outside the defined scope.
- PATCH is not listed in the official API contract. Do not invent a PATCH endpoint.
- JSON bodies are served with `text/html; charset=utf-8` in the observed API responses. Tests must distinguish HTTP status from `responseCode` in the body.
- A synthetic account was created through the documented API (`responseCode: 201`, `User created!`), used for UI login, authenticated checkout review, payment-form inspection and logout, and deleted through the API (`responseCode: 200`, `Account deleted!`). Login displayed `Logged in as QA Discovery`; logout navigated to `/login`. The checkout review displayed address details and the Blue Top order row. Place Order navigated to `/payment`, where the name, card number, CVC, expiry month and expiry year fields were present. Payment submission remains unexecuted at discovery time.
- This project evaluates a shared practice environment; a QA recommendation is a portfolio scope recommendation, not authorization to release the website.
