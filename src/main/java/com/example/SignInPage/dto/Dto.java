package com.example.SignInPage.dto;


public class Dto {
    private Long id;
    private String email;
    private String password;

    public Dto(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Dto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
