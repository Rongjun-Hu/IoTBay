/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller.paymentController;

import java.io.Serializable;

/**
 *
 * @author lantianxiang
 */
public class paymentDetail implements Serializable {
    private String bankCard;
    private String cvv;
    private String expiryYear;
    private String expiryMonth;

    public paymentDetail(String bankCard, String cvv, String expiryYear, String expiryMonth) {
        this.bankCard = bankCard;
        this.cvv = cvv;
        this.expiryYear = expiryYear;
        this.expiryMonth = expiryMonth;
    }
    
//get and set bankCard
    public String getbankCard() { 
        return bankCard; 
    
    }
    public void setbankCard(String card) { 
        this.bankCard = bankCard; 
    }
    
//get and set cvv
    public String getCvv() { 
        return cvv; 
    }
    
    public void setCvv(String cvv) { 
        this.cvv = cvv; 
    }
    
//get and set expiryYear
    public String getExpiryYear() { 
        return expiryYear; 
    }
    
    public void setExpiryYear(String expiryYear) { 
        this.expiryYear = expiryYear; 
    }
    
//get and set expiryMonth    
    public String getExpiryMonth() { 
        return expiryMonth; 
    }
    
    public void setExpiryMonth(String expiryMonth) { 
        this.expiryMonth = expiryMonth; 
    }
}
