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

    private String email ="mail@gmail.com";

    private String password;

    public UserBean() {
       //// System.out.println("Generate date " + System.currentTimeMillis());
       // System.out.println("Generate date " + System.currentTimeMillis());
       // System.out.println("Generate date " + System.currentTimeMillis());
       // System.out.println("Generate date " + System.currentTimeMillis());
       // System.out.println("Generate date " + System.currentTimeMillis());
    }

    public String doLogin() {
       /// System.out.println("Email is " + email);
       // System.out.println("Password  is " + password);

        return "profile";
    }

}
