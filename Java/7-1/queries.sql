USE currency_converter;
-- All
SELECT *
FROM currency;
-- One
SELECT *
FROM currency
WHERE abbreviation = 'EUR';
-- Count
SELECT COUNT(*) AS currency_count
FROM currency;
-- Max
SELECT *
FROM currency
ORDER BY rate_to_usd DESC
LIMIT 1;