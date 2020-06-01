/**
 * Author:  apple
 * Created: 2020-6-2
 */

CREATE TABLE DEVICES
(
Id integer,
Name varchar(15),
Price double,
Type varchar(10),
stock integer,
PRIMARY KEY(Id));

INSERT INTO DEVICES (ID, NAME, PRICE, TYPE, STOCK)
VALUES
(1001, 'macbook Air', 1140.99, 'laptop', 4000),
(1002, 'macbook Pro', 1580.99, 'laptop', 3500),
(2001, 'razor', 40.99, 'mouse', 8500);

SELECT * FROM DEVICES;

