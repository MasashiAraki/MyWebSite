CREATE TABLE t_user (
	id SERIAL,
	name varchar(20) NOT NULL,
	postcode int NOT NULL,
	address varchar(100) NOT NULL,
	login_id varchar(30) UNIQUE NOT NULL,
	login_password varchar(256) NOT NULL,
	create_date date NOT NULL
	);