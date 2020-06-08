/**
 * Author:  apple
 * Created: 2020-6-2
 */

-- DROP TABLE USERS;

CREATE TABLE USERS
(
Email varchar(50),
Name varchar(20),
Password varchar(20),
Gender varchar(10),
Favcol varchar(10),
DOB date,
Permission varchar(15),
PRIMARY KEY(Email));

INSERT INTO USERS (EMAIL, NAME, PASSWORD, GENDER, FAVCOL, DOB, PERMISSION)
VALUES
('hong@uts.edu.au', 'Hong Kung', '112233', 'male', 'Red', '1997-04-08', 'staff'),
('apple@uts.edu.au', 'Boon Wong','345678a','male', 'Orange', '1997-01-01', 'staff'),
('hexo@uts.edu.au', 'Peter Wu', '4567890', 'male', 'Blue', '1999-02-02','staff'),
('opps@uts.edu.au', 'Yifan Wang', '5677889b', 'female', 'Blue', '1999-03-02','staff'),
('hello@uts.edu.au', 'Alan Lan', '654321', 'male', 'Black', '1999-05-05', 'staff'),
('xu@uts.edu.au', 'George Xu', '123456', 'male', 'Blue', '1998-05-21', 'customer'),
('feli@uts.edu.au', 'Felipe Macedo', '234567', 'male', 'green', '1998-01-21', 'customer'),
('fans@uts.edu.au', 'Geoe Xu', '123456', 'male', 'Red', '1998-05-21', 'staff'),
('vans@uts.edu.au', 'Willy Xu', '123456', 'female', 'Blue', '1998-05-21', 'customer'),
('sddk@uts.edu.au', 'Fred Xu', '123456', 'male', 'Black', '2001-05-21', 'customer'),
('pooos@uts.edu.au', 'Tim Xu', '123456', 'male', 'Blue', '1999-05-21', 'customer'),
('endsiv@uts.edu.au', 'Joshua Xu', '123456', 'male', 'Red', '1998-05-21', 'customer'),
('mike@uts.edu.au', 'Ge Xu', '123456', 'female', 'Blue', '1998-05-21', 'customer'),
('joy@uts.edu.au', 'Chris Xu', '123456', 'female', 'Blue', '1998-05-21', 'customer'),
('ramdom@uts.edu.au', 'Seb Xu', '123456', 'male', 'Black', '1998-03-21', 'customer'),
('vsdsaer@uts.edu.au', 'Jack Xu', '123456', 'male', 'Blue', '1998-04-21', 'customer'),
('iojonn@uts.edu.au', 'Rita Xu', '123456', 'female', 'Orange', '1998-05-21', 'customer'),
('iotbay@uts.edu.au', 'Alfson Xu', '123456', 'male', 'Blue', '1998-06-21', 'customer'),
('dasv@uts.edu.au', 'Becky Xu', '123456', 'female', 'Pink', '1998-09-21', 'customer'),
('ihuihn@uts.edu.au', 'Eric Xu', '123456', 'male', 'Blue', '1998-07-21', 'customer'),
('ruygvb@uts.edu.au', 'Alex Xu', '123456', 'male', 'Pink', '1998-08-21', 'customer');


SELECT * FROM USERS;

