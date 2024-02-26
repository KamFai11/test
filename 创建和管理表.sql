#第十章_创建和管理表

#1、创建数据库test01_office,指明字符集为utf8.
CREATE DATABASE IF NOT EXISTS test01_office CHARACTER SET 'utf8';
USE test01_office;

#2,创建表dept01
/*字段          类型
  id            INT(7)
  NAME          VARCHAR(25)
  */
  CREATE TABLE IF NOT EXISTS dept01(
id INT(7),
`name` VARCHAR(25)  
  );
  
#3、将表departments中的数据插入新表dept02中
  CREATE TABLE IF NOT EXISTS dept02
  AS
  SELECT *
  FROM atguigudb.`departments`;

#4,创建表emp01
CREATE TABLE emp01(
id INT(7),
first_name VARCHAR(25),
last_name VARCHAR(25),
dept_id INT(7)
); 

#5、将列last_name的长度增加到50
DESC emp01;


ALTER TABLE emp01
MODIFY last_name VARCHAR(50);

#6、根据表employees创建emp02
CREATE TABLE emp02
AS
SELECT *
FROM atguigudb.`employees`;

SHOW TABLES;
#7、删除表emp01
DROP TABLE emp01;#ddl的操作是不能回滚的，可以用ROLLBACK;检验

#8、将emp02重新命名为emp01
#第一种（推荐）
RENAME TABLE emp02 TO emp01;
#第二种
ALTER TABLE emp02 RENAME TO emp01;

#9、在表dept02和emp01中添加新列test_column,并检查所作的操作
ALTER TABLE emp01 ADD test_column VARCHAR(10);
DESC emp01;

ALTER TABLE dept02 ADD test_column VARCHAR(10);
DESC dept02;

#10、直接删除表emp01中的列department_id
ALTER TABLE emp01
DROP COLUMN department_id;

#11、创建数据库test02_market
CREATE DATABASE IF NOT EXISTS test02_market CHARACTER SET 'utf8';

USE test02_market;

#12、创建数据表 customers 
CREATE TABLE IF NOT EXISTS customers (
c_num INT,
c_name VARCHAR(50),
c_contact VARCHAR(50),
c_city VARCHAR(50),
c_birth DATE 
);

#13、将c_contact字段移动到c_birth字段后面
DESC customers;

ALTER TABLE customers
MODIFY c_contact VARCHAR(50) AFTER c_birth;

#14、将c_name字段数据类型改为varchar(70)
ALTER TABLE customers
MODIFY c_name VARCHAR(70);

#15、将c_contact字段改名为c_phone
ALTER TABLE customers
CHANGE c_contact c_phone VARCHAR(50);

#16、增加c_gender字段到c_name后面，数据类型为CHAR(1)
ALTER TABLE customers
ADD c_gender CHAR(1) AFTER c_name;

#17、将表名改为customers_info
RENAME TABLE customers
TO customers_info;

DESC customers_info;

#18、删除字段c_city
ALTER TABLE customers_info	
DROP COLUMN c_city;



























