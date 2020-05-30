/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lantianxiang
 * Created: 31/05/2020
 */
CREATE TABLE PAYMENT_DETAIL
(
    "USERS_EMAIL"  INTEGER PRIMARY KEY REFERENCES USERS (EMAIL) ON DELETE CASCADE,
    "BANKCARD"  VARCHAR(30),
    "CVV"   VARCHAR(3),
    "EXPIRY_MONTH" VARCHAR(2),
    "EXPIRY_YEAR"  VARCHAR(4)
);
