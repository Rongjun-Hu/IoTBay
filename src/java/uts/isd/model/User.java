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
    private String email;
    private String name;
    private String password;
    private String gender;
    private String favcol;
    private String dob;
    private String permission;

    
    //insert a constructor that intializes thefields
    public User(String email, String name, String password, String gender, String favcol, String dob, String permission) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.favcol = favcol;
        this.dob = dob;
        this.permission = permission;
    }
    
    public static void updateUser(HttpSession session, HttpServletRequest request, User user) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String favcol = request.getParameter("favcol");
        String permission = request.getParameter("permission");
        user = new User(email, name ,password, gender, favcol, dob, permission);
        session.setAttribute("user", user);
    }
    
    //insert getter and setter

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFavcol() {
        return favcol;
    }

    public void setFavcol(String favcol) {
        this.favcol = favcol;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

       
}
