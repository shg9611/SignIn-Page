package com.example.SignInPage.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberForm {

    private Long id;
    private String email;
    private String password;

    public Member toEntity(){
        return new Member(id,email,password);
    }
}
