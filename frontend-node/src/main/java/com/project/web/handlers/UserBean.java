/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.web.handlers;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
