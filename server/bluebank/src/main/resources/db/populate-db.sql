INSERT INTO ACCOUNT (number, agency, balance) VALUES (1, 1, 100.0);
INSERT INTO ACCOUNT (number, agency, balance) VALUES (2, 1, 150.0);
INSERT INTO ACCOUNT (number, agency, balance) VALUES (1, 2, 500.0);
INSERT INTO ACCOUNT (number, agency, balance) VALUES (2, 2, 700.0);

INSERT INTO ACCOUNT_HOLDER (id, cpf, account_number, account_agency, name, creation_date) VALUES (1, '51271204452', 1, 1, 'Charlie', '2017-05-14 10:00:00');
INSERT INTO ACCOUNT_HOLDER (id, cpf, account_number, account_agency, name, creation_date) VALUES (2, '59337602180', 2, 1, 'Jake', '2017-05-14 10:00:00');
INSERT INTO ACCOUNT_HOLDER (id, cpf, account_number, account_agency, name, creation_date) VALUES (3, '43435392100', 1, 2, 'Alan', '2017-05-14 10:00:00');
INSERT INTO ACCOUNT_HOLDER (id, cpf, account_number, account_agency, name, creation_date) VALUES (4, '84061237020', 2, 2, 'Berta', '2017-05-14 10:00:00');
INSERT INTO ACCOUNT_HOLDER (id, cpf, account_number, account_agency, name, creation_date) VALUES (5, '82355099979', 1, 1, 'Rose', '2017-05-14 10:00:00');

INSERT INTO TRANSACTION
	(id, account_number_from, account_agency_from, account_number_to, account_agency_to, amount, creation_date, description)
VALUES
	(1, 1, 1, 2, 1, 10.0, '2017-05-14 11:30:00', 'Lunch');