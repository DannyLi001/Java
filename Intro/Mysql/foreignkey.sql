CREATE DATABASE shop_db

CREATE TABLE goods (
	goods_id INT PRIMARY KEY,
	goods_name VARCHAR(32) NOT NULL,
	unitprice DOUBLE NOT NULL CHECK (unitprice >= 1.0 AND unitprice <= 9999.99),
	category VARCHAR(32) NOT NULL,
	provider VARCHAR(32) NOT NULL
)
DESC goods
DROP TABLE goods
CREATE TABLE customer (
	customer_id INT PRIMARY KEY,
	`name` VARCHAR(32) NOT NULL,
	address VARCHAR(32) NOT NULL,
	email VARCHAR(32) NOT NULL UNIQUE,
	sex ENUM('m','f') NOT NULL,
	card_id DOUBLE NOT NULL
)
DESC customer
DROP TABLE customer
CREATE TABLE purchase (
	order_id INT NOT NULL PRIMARY KEY,
	customer_id INT NOT NULL,
	goods_id INT NOT NULL,
	nums INT NOT NULL,
	FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
	FOREIGN KEY (goods_id) REFERENCES goods(goods_id)
)
DESC purchase
DROP TABLE purchase