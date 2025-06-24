package com.example.SignInPage.controller;

import com.example.SignInPage.dto.JoinEntity;
import com.example.SignInPage.dto.JoinForm;
import com.example.SignInPage.repository.JoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    private JoinRepository joinRepository;

    @GetMapping("/signup")
    public String signUpPage(){
        return "signUpPage";
    }

    @PostMapping("/join")
    public String createJoin(JoinForm joinForm){

        JoinEntity joinEntity=joinForm.toEntity();

        JoinEntity saveEntity=joinRepository.save(joinEntity);

        System.out.println(joinForm);
        System.out.println(joinEntity);
        System.out.println(saveEntity);
        return"";
    }
}
