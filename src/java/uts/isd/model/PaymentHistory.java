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
public class PaymentHistory implements Serializable {

    private int PaymentID;
    private int deviceID;
    private String customerName;
    private String deviceType;
    private String paymentMethod;
    private String paymentAmount;
    private String paymentDate;

    public PaymentHistory(int PaymentID, int deviceID, String customerName, String deviceType, String paymentMethod, String paymentAmount, String paymentDate) {
        this.PaymentID = PaymentID;
        this.deviceID = deviceID;
        this.customerName = customerName;
        this.deviceType = deviceType;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
    }

    public int getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(int PaymentID) {
        this.PaymentID = PaymentID;
    }

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentHistory(int paymentID, int deviceID, String customerName, String deviceType, String paymentMethod, String paymentAmount, String paymentDate) {
        setPaymentID(PaymentID);
        setDeviceID(deviceID);
        setCustomerName(customerName);
        setDeviceType(deviceType);
        setPaymentMethod(paymentMethod);
        setPaymentAmount(paymentAmount);
        setPaymentDate(paymentDate);

    }

}
