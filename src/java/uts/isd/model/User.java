 /*
* Student is a JavaBean that stores name, email, password, and Date of birth
 */
package uts.isd.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author peter
 */
public class User {
    private String name;
    private String email;
    private String password;
    private String gender;
    private String dob;
    private String favcol;

    
    //insert a constructor that intializes thefields
    public User(String name, String email, String password, String gender, String dob, String favcol) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.favcol = favcol;

    }
    
    public static void updateUser(HttpSession session, HttpServletRequest request, User user) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String favcol = request.getParameter("favcol");
        user = new User(name,email,password,gender,dob,favcol);
        session.setAttribute("user", user);
    }
    
    //insert getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
    
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFavcol() {
        return favcol;
    }

    public void setFavcol(String favcol) {
        this.favcol = favcol;
    }


    
    
}
