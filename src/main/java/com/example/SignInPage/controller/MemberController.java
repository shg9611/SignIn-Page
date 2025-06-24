package com.example.SignInPage.controller;

import com.example.SignInPage.dto.JoinEntity;
import com.example.SignInPage.dto.JoinForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @GetMapping("/signup")
    public String signUpPage(){
        return "signUpPage";
    }

    @PostMapping("/join")
    public String createJoin(JoinForm joinForm){

        JoinEntity joinEntity=joinForm.toEntity();

        System.out.println(joinForm);
        System.out.println(joinEntity);
        return"";
    }
}
