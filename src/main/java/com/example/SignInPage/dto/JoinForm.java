package com.example.SignInPage.dto;


public class JoinForm {

    private String email;
    private String password;

    public JoinForm( String email, String password) {
        this.email = email;
        this.password = password;
    }

    public JoinEntity toEntity(){
        return new JoinEntity(null,email,password);
    }


    @Override
    public String toString() {
        return "JoinForm{" +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
