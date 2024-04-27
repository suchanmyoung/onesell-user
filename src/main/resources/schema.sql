CREATE TABLE ONESELL_USER
(
    id        NUMBER PRIMARY KEY,
    user_id   VARCHAR(20),
    password  CHAR(65),
    name      VARCHAR(30),
    nickname  VARCHAR(30),
    cellphone VARCHAR(20),
    email     VARCHAR(30),
    CREATED_AT TIMESTAMP,
    MODIFIED_AT TIMESTAMP
);

CREATE SEQUENCE user_id_seq;
CREATE INDEX user_id_idx ON ONESELL_USER(user_id);


