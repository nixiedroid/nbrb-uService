CREATE SCHEMA IF NOT EXISTS site;
CREATE TABLE IF NOT EXISTS site.feature (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS  site.product (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(100) NOT NULL
);
