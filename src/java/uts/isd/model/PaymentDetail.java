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

    private User user;
    private String paymentMethod;
    private String bankCard;
    private String cvv;
    private String expiryYear;
    private String expiryMonth;

    public PaymentDetail() {
        this.user = user;
        this.paymentMethod = paymentMethod;
        this.bankCard = bankCard;
        this.cvv = cvv;
        this.expiryYear = expiryYear;
        this.expiryMonth = expiryMonth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setMethodOfPayment(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }
}
