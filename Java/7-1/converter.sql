
DROP DATABASE IF EXISTS currency_converter;
CREATE DATABASE currency_converter;
USE currency_converter;

CREATE TABLE currency (
    abbreviation CHAR(3) NOT NULL,
    name VARCHAR(60) NOT NULL,
    rate_to_usd DECIMAL(12, 6) NOT NULL,
    PRIMARY KEY (abbreviation)
);
-- Data
INSERT INTO currency (abbreviation, name, rate_to_usd)
VALUES ('USD', 'US Dollar', 1.000000),
    ('EUR', 'Euro', 1.090000),
    ('GBP', 'British Pound', 1.280000),
    ('JPY', 'Japanese Yen', 0.006600),
    ('SEK', 'Swedish Krona', 0.095000),
    ('NOK', 'Norwegian Krone', 0.093000),
    ('CHF', 'Swiss Franc', 1.100000),
    ('CAD', 'Canadian Dollar', 0.740000),
    ('AUD', 'Australian Dollar', 0.650000),
    ('INR', 'Indian Rupee', 0.011500);
-- User
DROP USER IF EXISTS 'appuser' @'localhost';
CREATE USER 'appuser' @'localhost' IDENTIFIED BY 'password';

GRANT SELECT ON currency_converter.currency TO 'appuser' @'localhost';