/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lantianxiang
 * Created: 04/06/2020
 */

DROP TABLE paymentDetail;

Create Table paymentDetail(
customerId varchar(30),
bankCard varchar(30),
cvv varchar(5),
expiryDate varchar(20),
PRIMARY KEY (customerId)
);

INSERT INTO paymentDetail (customerId,bankCard,cvv,expiryDate)
VALUES
('xu@uts.edu.au','1234567812345678','111','19/3/20'),
('apple@uts.edu.au','1234567812345678','111','19/3/20'),
('hexo@uts.edu.au','1234424812345678','222','19/4/21'),
('opps@uts.edu.au','1234567811545678','333','19/3/20'),
('hello@uts.edu.au','1432567812345678','444','31/3/22'),
('fans@uts.edu.au','1234567435345678','555','19/3/20'),
('vans@uts.edu.au','1234567815435678','666','29/3/22'),
('sddk@uts.edu.au','1234567812344534','777','19/3/23'),
('pooos@uts.edu.au','1234567843545678','888','19/3/20'),
('endsiv@uts.edu.au','1234678123453478','999','17/5/20'),
('mike@uts.edu.au','1224267812345678','000','19/3/24'),
('joy@uts.edu.au','6324567812345678','123','15/3/20'),
('ramdom@uts.edu.au','1632567812345678','456','11/12/20'),
('vsdsaer@uts.edu.au','6234447812345678','789','19/3/22'),
('iojonn@uts.edu.au','1534663442345678','314','17/3/20'),
('iotbay@uts.edu.au','1236433424345678','533','19/3/20'),
('dasv@uts.edu.au','1234567346346678','756','24/8/20'),
('ihuihn@uts.edu.au','1234368123456678','246','14/3/20'),
('ruygvb@uts.edu.au','1634781234567648','745','19/3/20'),
('wevvw@uts.edu.au','1274576781265678','834','23/11/21'),
('world@uts.edu.au','1234435421664678','425','29/3/20');


