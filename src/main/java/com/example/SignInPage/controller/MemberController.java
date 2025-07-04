package com.example.SignInPage.controller;

import com.example.SignInPage.dto.Member;
import com.example.SignInPage.dto.MemberForm;
import com.example.SignInPage.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUpPage(){
        return "pages/signUpPage";
    }

    @PostMapping("/join")
    public String createJoin(MemberForm memberForm){

        Member joinMember= memberForm.toEntity();

        log.info(memberForm.toString());
        log.info(joinMember.toString());

        Member saveMember= memberRepository.save(joinMember);

        log.info(saveMember.toString());
        return"redirect:/member/"+saveMember.getId();
    }
    @GetMapping("/memberlist")
    public String showMemberList(Model model){

        ArrayList<Member> memberList = memberRepository.findAll();
        model.addAttribute("memberList", memberList);
        log.info(memberList.toString());

        return "pages/showMemberList";
    }

    @GetMapping("/member/{id}")
    public String showMember(@PathVariable Long id, Model model){

        Member member = memberRepository.findById(id).orElse(null);
        model.addAttribute("member",member);
        log.info(member.toString());

        return "pages/showMember";

    }

    @GetMapping("/member/{id}/edit")
    public String editMember(@PathVariable Long id, Model model){
        Member editMember= memberRepository.findById(id).orElse(null);

        model.addAttribute("editMember",editMember);

        return "pages/editMember";
    }

    @PostMapping("/member/{id}/edit/saved")
    public String update(Model model, MemberForm updateForm){

        log.info(updateForm.toString());

        Member updateMember=updateForm.toEntity();
        log.info(updateMember.toString());

        Member target=memberRepository.findById(updateMember.getId()).orElse(null);

        if(target!=null){
            Member saved = memberRepository.save(updateMember);
            log.info(saved.toString());
        }

        return "redirect:/member/"+updateMember.getId();

    }

    @GetMapping("/member/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){

        log.info(id.toString());

        Member target=memberRepository.findById(id).orElse(null);
        log.info(target.toString());

        if(target!=null){
            memberRepository.delete(target);
            rttr.addFlashAttribute("msg","성공적으로 삭제되었습니다.");
        }

        return "redirect:/memberlist";
    }
}
