package com.auth.service.entities;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 1L;  
    private String id;  
    private String firstname;  
    private String lastname;  
    private String email;  
    private String password;  
    private Date registeredDate;
    private String token;


}
