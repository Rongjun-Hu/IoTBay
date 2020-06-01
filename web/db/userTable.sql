/**
 * Author:  apple
 * Created: 2020-6-2
 */

-- DROP TABLE USERS;

CREATE TABLE USERS
(
Email varchar(50),
Name varchar(10),
Password varchar(20),
Gender varchar(10),
Favcol varchar(10),
DOB date,
Permission varchar(15),
PRIMARY KEY(Email));

INSERT INTO USERS (EMAIL, NAME, PASSWORD, GENDER, FAVCOL, DOB, PERMISSION)
VALUES
('steve@uts.edu.au', 'Hong Kung', 'a12431868', 'male', 'Red', '1997-04-08', 'staff'),
('xu@uts.edu.au', 'George Xu', '225588', 'male', 'Blue', '1998-05-21', 'customer');

SELECT * FROM USERS;

