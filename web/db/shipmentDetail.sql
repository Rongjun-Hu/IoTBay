/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  wangyifan
 * Created: 08/06/2020
 */


CREATE TABLE ShipmentDetails 
(
addressLine1 varchar(50),
addressLine2 varchar(50),
suburb varchar(20),
postcode int,
state char(3),
);



INSERT INTO ShipmentDetails (ADDRESSLINE1, ADDRESSLINE2, SUBURB, STATE, POSTCODE)
VALUES
('112 cew st', '1', 'Utimo', 'NSW', '4000');



SELECT * FROM ShipmentDetails;


