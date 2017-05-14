CREATE TABLE account (
	id				BIGINT generated by default as identity (start with 1),
	number			INTEGER,
	agency			INTEGER,
	balance			DECIMAL,
	creation_date	TIMESTAMP WITHOUT TIME ZONE
);

ALTER TABLE account
ADD PRIMARY KEY ( number, agency );

CREATE TABLE account_holder (
	id				BIGINT generated by default as identity (start with 1),
	cpf				VARCHAR(11),
	account_number	INTEGER,
	account_agency	INTEGER,
	name			VARCHAR(100),
	creation_date	TIMESTAMP WITHOUT TIME ZONE
);

ALTER TABLE account_holder
ADD PRIMARY KEY ( id, cpf, account_number, account_agency );

ALTER TABLE account_holder
ADD FOREIGN KEY ( account_number, account_agency )
REFERENCES account ( number, agency );

CREATE TABLE transaction (
	id						BIGINT PRIMARY KEY generated by default as identity (start with 1),
	account_number_from		INTEGER,		
	account_agency_from		INTEGER,
	account_number_to		INTEGER,		
	account_agency_to		INTEGER,
	amount					DECIMAL,
	creation_date			TIMESTAMP WITHOUT TIME ZONE,
	description				VARCHAR(100)
);

ALTER TABLE transaction
ADD FOREIGN KEY ( account_number_from, account_agency_from )
REFERENCES account ( number, agency );

ALTER TABLE transaction
ADD FOREIGN KEY ( account_number_to, account_agency_to )
REFERENCES account ( number, agency );
