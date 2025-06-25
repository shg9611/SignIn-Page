package com.example.SignInPage.controller;

import com.example.SignInPage.dto.JoinEntity;
import com.example.SignInPage.dto.JoinForm;
import com.example.SignInPage.repository.JoinRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Slf4j
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

        log.info(joinForm.toString());
        log.info(joinEntity.toString());
        log.info(saveEntity.toString());
        return"";
    }
    @GetMapping("/memberlist")
    public String showMemberList(Model model){

        ArrayList<JoinEntity> memberList = joinRepository.findAll();
        model.addAttribute("memberList", memberList);
        log.info(memberList.toString());

        return "showMemberList";
    }
}
