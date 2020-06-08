/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  wangyifan
 * Created: 08/06/2020
 */


CREATE TABLE SHIPMENT (
    SHIPMENTID INT,
    NAME VARCHAR (50),
    ADDRESSLINE VARCHAR (30),
    SUBURB CHAR(20),
    STATE CHAR(3),
    POSTCODE INT,
    SHIPPINGSTATUS INT,
    SHIPMENTDATE DATE,
    ORDERID INT
);

INSERT INTO SHIPMENT (SHIPMENTID,NAME,ADDRESSLINE, SUBURB,STATE,POSTCODE,SHIPPINGSTATUS,SHIPMENTDATE,ORDERID)
VALUES
('001','WA','1A STREET','1A STREE'),
('002','8765432187654321','456','21/3/20')