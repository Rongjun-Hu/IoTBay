/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author wangyifan
 */


public class ShipmentInformation implements Serializable {

    private int ShipmentID;
    private int CustomerID;
    private String CustomerName;
    private String ShipmentDate;
    private String ShipmentStatus;


    public ShipmentInformation (int  ShipmentID, int CustomerID, String CustomerName, String ShipmentDate, String ShipmentStatus) {
        this.ShipmentID = ShipmentID;
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.ShipmentDate = ShipmentDate;
        this.ShipmentStatus = ShipmentStatus;

    }

    public int getShipmentID() {
        return ShipmentID;
    }

    public void setShipmentID(int ShipmentID) {
        this.ShipmentID = ShipmentID;
    }

    public int CustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        this.CustomerID = CustomerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        this.CustomerName = CustomerName;
    }

    public String getShipmentDate() {
        return ShipmentDate;
    }

    public void setShipmentDate(String ShipmentDate) {
        this.ShipmentDate = ShipmentDate;
    }

    public String getShipmentStatus() {
        return ShipmentStatus;
    }

    public void setShipmentStatus(String ShipmentStatus) {
        this.ShipmentStatus = ShipmentStatus;
    }



    public void setShipmentInformation(int ShipmentID, int CustomerID, String CustomerName, String ShipmentDate, String ShipmentStatus) {
        setShipmentID(ShipmentID);
        setCustomerID(ShipmentID);
        setCustomerName(CustomerName);
        setShipmentDate(ShipmentDate);
        setShipmentStatus(ShipmentStatus);
     

    }

}

    