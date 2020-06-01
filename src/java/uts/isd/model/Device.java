/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author diamo
 */
public class Device implements Serializable {

    private int id;
    private String name;
    private double price;
    private String description;
    private int stock;

    public Device(int id, String name, double price, String description, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }
    
    public void setDevice(int id, String name, double price, String description, int stock){
        setId(id);
        setName(name);
        setPrice(price);
        setDescription(description);
        setStock(stock);
    }

}
