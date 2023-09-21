CREATE TABLE t3(
	id INT,
	`name` CHAR(32),
	sex CHAR(1),
	birthday DATE,
	entry_date DATETIME,
	job CHAR(32),
	salary DOUBLE,
	`resume` TEXT);

INSERT INTO t3 VALUES(100, 'name','c',
'2000-11-11','2023-11-11 11:11:11','job',
3000,'resume');
SELECT * FROM t3;
ALTER TABLE t3 ADD image VARCHAR(32) NOT NULL DEFAULT '' AFTER `resume`;
DESC employee
ALTER TABLE t3 DROP image;
ALTER TABLE t3 MODIFY job VARCHAR(60);
ALTER TABLE t3 DROP sex;
RENAME TABLE t3 TO employee;
ALTER TABLE employee CHARACTER SET utf8;
ALTER TABLE employee CHANGE `name` user_name VARCHAR(32) NOT NULL DEFAULT ''; 
DROP TABLE t3;