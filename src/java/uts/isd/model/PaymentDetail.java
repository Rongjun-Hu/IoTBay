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

    private int customerId;
    private String bankCard;
    private String cvv;
    private String expiryDate;

    public PaymentDetail(int customerId, String bankCard, String cvv, String expiryDate) {
        this.customerId = customerId;
        this.bankCard = bankCard;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int CustmoerId) {
        this.customerId = customerId;
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

    public void setPaymentDetail(int customerId, String bankCard, String cvv, String expiryDate) {
        setCustomerId(customerId);
        setbankCard(bankCard);
        setCvv(cvv);
        setExpiryDate(expiryDate);

    }
}