drop schema if exists project1 cascade;

drop table if exists postgres.project1.ers_reimbursement_status cascade;
drop table if exists postgres.project1.ers_reimbursement_type cascade;
drop table if exists postgres.project1.ers_user_roles cascade;
drop table if exists postgres.project1.ers_users cascade;
drop table if exists postgres.project1.ers_reimbursement cascade;

create schema project1;
create table postgres.project1.ers_reimbursement_status(
  STATUS_ID serial primary key,
  REIMB_STATUS varchar(10)
);

create table postgres.project1.ers_reimbursement_type(
  REIMBURSEMENT_ID serial primary key,
  REIMBURSEMENT_TYPE varchar(10)
);

create table postgres.project1.ers_user_roles (
  ROLE_ID serial primary key,
  USER_ROLE varchar(10)
);

create table postgres.project1.ers_users (
  USER_ID serial primary key,
  ERS_USERNAME varchar(50),
  ERS_PASSWORD varchar(50),
  USER_FIRST_NAME varchar(100),
  USER_LAST_NAME varchar(100),
  USER_EMAIL varchar(150),
  ROLE_ID integer references postgres.project1.ers_user_roles (ROLE_ID)
);

create table postgres.project1.ers_reimbursement (
  REIMB_ID serial primary key, 
  REIMB_AMOUNT numeric (10, 2),
  REIMB_SUBMITTED timestamp,
  REIMB_RESOLVED timestamp,
  REIMB_DESCRIPTION varchar(250),
  REIMB_RECEIPT bytea,
  AUTHOR_ID integer references postgres.project1.ers_users (USER_ID),
  RESOLVER_ID integer references postgres.project1.ers_users (USER_ID),
  TYPE_ID integer references postgres.project1.ers_reimbursement_type (REIMBURSEMENT_ID),
  STATUS_ID integer references postgres.project1.ers_reimbursement_status (STATUS_ID)
);

insert into postgres.project1.ers_user_roles (user_role) values ('Employee'), ('Manager');
insert into postgres.project1.ers_reimbursement_status (REIMB_STATUS) values ('Pending'), ('Approved'), ('Denied');
insert into postgres.project1.ers_reimbursement_type (reimbursement_type) values ('Food'), ('Travel'), ('Lodging'), ('Other');

insert into postgres.project1.ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, role_id)
values 
	('MrEric', 'MyPassword', 'Eric', 'Hunsinger', 'ehumdinger@gmail.com', 1),
	('MrBigglesworth', 'HisPassword', 'Mr', 'Bigglesworth', 'bigglesMr@gmail.com', 2),
	('DHelmet', '12345', 'Dark', 'Helmet', 'DHelmet@gmail.com', 2);

insert into postgres.project1.ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, author_id, resolver_id, type_id, status_id) 
values 
	('3.50','01/13/2019 13:14.02', '01/15/2019 10:13:32', 'Buffalo Wild Wings', null, 3, 2, 1, 1),
	('3.50','01/13/2019 13:14.02', '01/15/2019 10:13:32', 'Flight to Florida', null, 2, 2, 2, 2),
	('201.45','01/22/2019 13:14.02', '01/15/2019 10:13:32', 'Marriot Stay', null, 1, 2, 3, 2),
	('23.13','01/19/2019 13:14.02', '01/15/2019 10:13:32', 'Miniature Golf', null, 2, 2, 4, 3);

