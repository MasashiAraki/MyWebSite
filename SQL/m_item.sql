CREATE TABLE m_item (
	id SERIAL,
	name varchar(20) UNIQUE NOT NULL,
	category_id int NOT NULL,
	detail text NOT NULL,
	price int(11) NOT NULL,
	file_name varchar(256)
	);
