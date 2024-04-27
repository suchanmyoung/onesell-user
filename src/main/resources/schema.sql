CREATE TABLE ONESELL_USER
(
    id        NUMBER PRIMARY KEY,
    user_id   VARCHAR(255),
    password  VARCHAR(255),
    name      VARCHAR(255),
    nickname  VARCHAR(255),
    cellphone VARCHAR(255),
    email     VARCHAR(255),
    CREATED_AT TIMESTAMP,
    MODIFIED_AT TIMESTAMP
);

CREATE SEQUENCE user_id_seq;

