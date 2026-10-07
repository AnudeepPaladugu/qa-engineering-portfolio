-- DESIGN ONLY / NOT EXECUTED. Hypothetical owned-environment schema.
-- Replace named parameters using the approved SQL client's parameter binding.
-- Registration: expect one row for the generated synthetic account.
SELECT customer_id, email, first_name, last_name
FROM customers WHERE email = :test_email;

-- Ownership: compare customer_id with the registration query.
SELECT order_id, customer_id, total_amount
FROM orders WHERE order_id = :test_order_id;

-- Arithmetic: no rows when line totals match the approved pricing rule.
SELECT order_id, product_id, quantity, unit_price, line_total
FROM order_items
WHERE order_id = :test_order_id
  AND line_total <> quantity * unit_price;

-- Header total: compare with expected UI total (before any agreed tax/shipping).
SELECT o.order_id, o.total_amount, SUM(i.line_total) AS calculated_total
FROM orders o JOIN order_items i ON i.order_id = o.order_id
WHERE o.order_id = :test_order_id
GROUP BY o.order_id, o.total_amount;

-- Owned test record integrity; do not broaden to unrelated customer data.
SELECT i.order_id, i.product_id
FROM order_items i LEFT JOIN products p ON p.product_id = i.product_id
WHERE i.order_id = :test_order_id AND p.product_id IS NULL;
