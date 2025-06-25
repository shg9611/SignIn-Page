package com.example.SignInPage.controller;

import com.example.SignInPage.dto.JoinEntity;
import com.example.SignInPage.dto.JoinForm;
import com.example.SignInPage.repository.JoinRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private JoinRepository joinRepository;

    @GetMapping("/signup")
    public String signUpPage(){
        return "pages/signUpPage";
    }

    @PostMapping("/join")
    public String createJoin(JoinForm joinForm){

        JoinEntity joinEntity=joinForm.toEntity();

        JoinEntity saveEntity=joinRepository.save(joinEntity);

        log.info(joinForm.toString());
        log.info(joinEntity.toString());
        log.info(saveEntity.toString());
        return"redirect:/member/"+saveEntity.getId();
    }
    @GetMapping("/memberlist")
    public String showMemberList(Model model){

        ArrayList<JoinEntity> memberList = joinRepository.findAll();
        model.addAttribute("memberList", memberList);
        log.info(memberList.toString());

        return "pages/showMemberList";
    }

    @GetMapping("/member/{id}")
    public String showMember(@PathVariable Long id, Model model){

        JoinEntity member = joinRepository.findById(id).orElse(null);
        model.addAttribute("member",member);
        log.info(member.toString());

        return "pages/showMember";

    }
}
