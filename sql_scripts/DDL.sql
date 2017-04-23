drop table customers;
CREATE TABLE customers ( 
id_customer INTEGER NOT NULL, 
first_name varchar2(200), 
last_name varchar2(200), 
passport_number INTEGER, 
passport_date date, 
date_start date DEFAULT sysdate, 
date_end date DEFAULT '01-01-9999', 
PRIMARY KEY(id_customer, date_start, date_end));

drop table contracts;
CREATE TABLE contracts ( 
contract_number INTEGER NOT NULL, 
id_customer INTEGER, 
contract_start_date date, 
contract_end_date date DEFAULT sysdate+365*3, 
PRIMARY KEY(contract_number)
--, FOREIGN KEY(id_customer) REFERENCES customers (id_customer)
);

drop table accounts;
CREATE TABLE accounts ( 
account_number INTEGER NOT NULL, 
contract_number INTEGER, 
account_type varchar2(200), 
account_start_date date, 
account_end_date date, 
balance INTEGER, 
PRIMARY KEY(account_number), 
FOREIGN KEY(contract_number) REFERENCES contracts );

drop table operations;
CREATE TABLE operations ( 
id_operation INTEGER NOT NULL, 
payment_purpose varchar2(200), 
sender_account_number INTEGER, 
recipient_account_number INTEGER, 
amount INTEGER, 
operation_date date, 
PRIMARY KEY(id_operation), 
FOREIGN KEY(sender_account_number) REFERENCES accounts (account_number), 
FOREIGN KEY(recipient_account_number) REFERENCES accounts (account_number));





