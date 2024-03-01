CREATE DATABASE test_library;
USE test_library;
CREATE TABLE BOOKS(
Bookid INT PRIMARY KEY,
Title VARCHAR(255),
Author VARCHAR(255),
Publisher VARCHAR(255),
Price DECIMAL(10,2)
);

CREATE TABLE Users(
Userid INT PRIMARY KEY,
Username VARCHAR(255),
Password VARCHAR(255), 
Email VARCHAR(255)
);

CREATE TABLE Orders(
orderid INT PRIMARY KEY,
Userid INT,
orderDate DATETIME,
Status VARCHAR(255),
FOREIGN KEY(Userid) REFERENCES Users(Userid)
); 

DROP TABLE Orders;

INSERT INTO Books (Bookid, Title, Author, Publisher, Price) VALUES
(1, 'Python编程从入门到实践', 'Eric Matthes', '人民邮电出版社', 79.00),
(2, '深入理解计算机系统', 'Randal E. Bryant', '人民邮电出版社', 109.00),
(3, '数据库系统概念', 'Abraham Silberschatz', '机械工业出版社', 99.00);

INSERT INTO Users (Userid, Username, Password, Email) VALUES
(1, 'user1', 'password1', 'user1@example.com'),
(2, 'user2', 'password2', 'user2@example.com'),
(3, 'user3', 'password3', 'user3@example.com');

INSERT INTO Orders (orderid, Userid, orderDate,Status) VALUES
(1, 1, '2022-03-01 10:00:00', '待发货'),
(2, 2, '2022-03-02 11:00:00', '已发货'),
(3, 3, '2022-03-03 12:00:00', '已完成');

SELECT * FROM Books;
SELECT * FROM Users;
SELECT * FROM Orders;

UPDATE Books SET Price = 89.00 WHERE BookID = 1;
UPDATE Users SET Email = 'user1_updated@example.com' WHERE UserID = 1;
UPDATE Orders SET Status = '已取消' WHERE OrderID = 1;

DELETE FROM Books WHERE Bookid = 3;
DELETE FROM Users WHERE Userid = 3;
DELETE FROM Orders WHERE Orderid = 3;





















