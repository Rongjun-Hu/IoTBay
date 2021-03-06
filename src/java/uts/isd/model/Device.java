/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author apple
 */
public class Device implements Serializable {

    private int id;
    private String name;
    private double price;
    private String type;
    private int stock;

    public Device(int id, String name, double price, String type, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.stock = stock;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStock() {
        return stock;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }
    
    public void setDevice(int id, String name, double price, String type, int stock){
        setId(id);
        setName(name);
        setPrice(price);
        setType(type);
        setStock(stock);
    }

}
