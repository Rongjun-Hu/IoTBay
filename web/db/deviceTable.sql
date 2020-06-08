/**
 * Author:  apple
 * Created: 2020-6-2
 */

-- DROP TABLE DEVICES;

CREATE TABLE DEVICES
(
Id int GENERATED ALWAYS AS IDENTITY (START WITH 1000, INCREMENT BY 1) primary key,
Name varchar(15),
Price double,
Type varchar(10),
stock int
);

INSERT INTO DEVICES (NAME, PRICE, TYPE, STOCK)
VALUES
('macbook Air', 1140.99, 'laptop', 4000),
('macbook Pro', 1580.99, 'laptop', 3500),
('macbook ProX', 1770.99, 'laptop', 1500),
('macbook ProG', 1650.99, 'laptop', 7500),
('macbook ProG3', 1588.49, 'laptop', 5500),
('macbook AirF', 1260.99, 'laptop', 2500),
('macbook AirF2', 1310.49, 'laptop', 800),
('iphone 6', 980.99, 'phone', 3500),
('iphone 7', 1180.99, 'phone', 4500),
('iphone 8', 1380.99, 'phone', 4400),
('iphone 9', 1350.99, 'phone', 3200),
('iphone 10', 1580.49, 'phone', 7100),
('iphone 10s', 1545.99, 'phone', 6650),
('iphone X', 1790.49, 'phone', 7300),
('iphone 11', 1920.99, 'phone', 5500),
('mach S1', 580.99, 'toy', 400),
('mach S2', 345.99, 'toy', 750),
('mach S3', 660.99, 'toy', 1100),
('control H11', 4255.99, 'toy', 2400),
('control J9', 8870.99, 'toy', 550),
('control K2', 5750.99, 'toy', 1950);

SELECT * FROM DEVICES;

-- UPDATE IOTUSER.DEVICES SET NAME = 'wire80', PRICE = 6.99 ,TYPE = 'wire',STOCK = 1200 WHERE ID =1002;
-- 
-- SELECT ID FROM DEVICES;
