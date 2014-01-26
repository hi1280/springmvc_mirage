CREATE TABLE test.users
(
    username                    VARCHAR(32) NOT NULL,
    mailaddress                 VARCHAR(30),
    CONSTRAINT PRIMARY KEY (username)
);
