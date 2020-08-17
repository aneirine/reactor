CREATE TABLE IF NOT EXISTS users (
    id bigserial NOT NULL PRIMARY KEY,
    username VARCHAR (64) NOT NULL,
    password VARCHAR(64) NOT NULL,
    role VARCHAR(64) NOT NULL
)