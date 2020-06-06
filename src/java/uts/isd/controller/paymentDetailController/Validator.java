/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller.paymentDetailController;

/**
 *
 * @author lantianxiang
 */
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class Validator implements Serializable {

    private String idPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";      
    private String bankCardPattern = "([0-9]{16})";
    private String expiryDatePattern = "([0-9]{2})(/)([0-9]{2})";
    private String cvvPattern = "([0-9]{3})";

    public Validator() {
    }

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);

        return match.matches();

    }

        public boolean validateId(String id) {
        return validate(idPattern, id);
    }

    public boolean validateBankCard(String bankCard) {
        return validate(bankCardPattern, bankCard);
    }

    public boolean validateExpiryDate(String expiryDate) {
        return validate(expiryDatePattern, expiryDate);
    }

    public boolean validateCvv(String cvv) {
        return validate(cvvPattern, cvv);
    }


}
