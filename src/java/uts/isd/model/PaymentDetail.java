/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author lantianxiang
 */
public class PaymentDetail implements Serializable {

    private int id;
    private String bankCard;
    private String cvv;
    private String expiryDate;

    public PaymentDetail(int id, String bankCard, String cvv, String expiryDate) {
        this.id = id;
        this.bankCard = bankCard;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setbankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setPaymentDetail(int id, String bankCard, String cvv, String expiryDate) {
        setId(id);
        setbankCard(bankCard);
        setCvv(cvv);
        setExpiryDate(expiryDate);

    }
}