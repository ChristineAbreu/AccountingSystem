CREATE SCHEMA VITRSA_SANDBOX;

CREATE SEQUENCE VITRSA_SANDBOX.GENERIC_SEQ
START WITH 50002
INCREMENT BY 1;

CREATE TABLE VITRSA_SANDBOX.CURRENCY_TYPE
(
CURRENCY_TYPE_ID BIGINT NOT NULL,
MNEMONIC VARCHAR(100) NOT NULL UNIQUE,
CURRENCY_TYPE_NAME VARCHAR(255) NOT NULL,
PRIMARY KEY(CURRENCY_TYPE_ID)
);

CREATE TABLE VITRSA_SANDBOX.ACCOUNT_TYPE
(
ACCOUNT_TYPE_ID BIGINT NOT NULL,
MNEMONIC VARCHAR(100) NOT NULL UNIQUE,
CURRENCY_TYPE_NAME VARCHAR(255) NOT NULL,
CREATION_DATE DATE NOT NULL,
PRIMARY KEY(CURRENCY_TYPE_ID)
);

CREATE TABLE VITRSA_SANDBOX.CURRENCY_TX
(
TX_ID BIGINT NOT NULL,
CURRENCY_TYPE_ID BIGINT NOT NULL,
MEMBER_ID BIGINT NOT NULL,
AMOUNT BIGINT NOT NULL,
TX_DATE DATE NOT NULL,
PRIMARY KEY (TX_ID),
CONSTRAINT FK_CURRENCY_TYPE_ID FOREIGN KEY (CURRENCY_TYPE_ID) REFERENCES VITRSA_SANDBOX.CURRENCY_TYPE (CURRENCY_TYPE_ID),

);

CREATE TABLE VITRSA_SANDBOX.ACCOUNT_TX_DETAILS
(
ACCOUNT_TX_DETAILS_ID BIGINT NOT NULL,
TX_ID BIGINT NOT NULL,
PARTNER_NAME VARCHAR(255) NOT NULL,
AMOUNT BIGINT NOT NULL,
NUMBER_OF_ITEMS DATE NOT NULL,
PRIMARY KEY (ACCOUNT_TX_DETAILS_ID),
CONSTRAINT FK_ACCOUNT_TX_ID FOREIGN KEY (TX_ID) REFERENCES VITRSA_SANDBOX.ACCOUNT_TX (TX_ID),

);

CREATE TABLE VITRSA_SANDBOX.ACCOUNT_TX
(
TX_ID BIGINT NOT NULL,
ACCOUNT_TYPE_ID BIGINT NOT NULL,
MEMBER_ID BIGINT NOT NULL,
AMOUNT BIGINT NOT NULL,
TX_DATE DATE NOT NULL,
PRIMARY KEY (TX_ID),
CONSTRAINT FK_ACCOUNT_TYPE_ID FOREIGN KEY (ACCOUNT_TYPE_ID) REFERENCES VITRSA_SANDBOX.ACCOUNT_TYPE (ACCOUNT_TYPE_ID),

);

CREATE TABLE VITRSA_SANDBOX.CURRENCY_TX_DETAILS
(
CURRENCY_TX_DETAILS_ID BIGINT NOT NULL,
TX_ID BIGINT NOT NULL,
PARTNER_NAME VARCHAR(255) NOT NULL,
AMOUNT BIGINT NOT NULL,
NUMBER_OF_ITEMS DATE NOT NULL,
PRIMARY KEY (CURRENCY_TX_DETAILS_ID),
CONSTRAINT FK_CURRENCY_TX_ID FOREIGN KEY (TX_ID) REFERENCES VITRSA_SANDBOX.CURRENCY_TX (TX_ID),

);

