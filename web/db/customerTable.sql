
/**
 * Author:  peter
 * Created: 12/05/2020
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
PRIMARY KEY(Email));

INSERT INTO USERS (EMAIL, NAME, PASSWORD, GENDER, FAVCOL, DOB)
VALUES
('steve@uts.edu.au', 'Hong Kung', 'a12431868', 'male', 'Red', '1997-04-08');

select * from USERS;



