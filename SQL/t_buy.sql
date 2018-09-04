CREATE TABLE m_buy (
	id SERIAL,
	user_id int NOT NULL,
	total_price int NOT NULL,
	delivery_method_id int NOT NULL,
	buy_date datetime NOT NULL
	);