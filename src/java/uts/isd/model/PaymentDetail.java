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
    private String expiryYear;
    private String expiryMonth;

    public PaymentDetail(int id, String bankCard, String cvv, String expiryYear, String expiryMonth) {
        this.id = id;
        this.bankCard = bankCard;
        this.cvv = cvv;
        this.expiryYear = expiryYear;
        this.expiryMonth = expiryMonth;
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

    public void setPaymentDetail(int id, String paymentMethod, String bankCard, String cvv, String expiryYear, String expiryMonth) {
        setId(id);
        setbankCard(bankCard);
        setCvv(cvv);
        setExpiryYear(expiryYear);
        setExpiryMonth(expiryMonth);
    }
}
