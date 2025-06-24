package com.example.SignInPage.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class JoinForm {

    private String email;
    private String password;

    public JoinEntity toEntity(){
        return new JoinEntity(null,email,password);
    }
}
