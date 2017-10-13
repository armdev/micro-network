package com.project.web.handlers;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import lombok.Data;

/**
 *
 * @author armdev   
 */
@Named(value = "userBean")
@RequestScoped
@Data
public class UserBean {
    
    private String email;
  
    private String password;

    public UserBean() {
    }
    
    public String doLogin(){
        System.out.println("Email is " + email);
        System.out.println("Password  is " + password);
        
        return "profile";
    }

 
}
