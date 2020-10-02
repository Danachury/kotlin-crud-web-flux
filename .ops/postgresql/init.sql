GRANT ALL PRIVILEGES ON DATABASE kt_crud TO kt_user;

DROP TABLE IF EXISTS shops;

CREATE TABLE shops
(
    id   BIGSERIAL NOT NULL UNIQUE,
    name VARCHAR   NOT NULL,
    PRIMARY KEY (name)
);

INSERT INTO shops(name) VALUES (?);
UPDATE shops SET name = ?, id = ? WHERE name = ?;