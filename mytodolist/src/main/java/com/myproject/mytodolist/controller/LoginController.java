package com.myproject.mytodolist.controller;

import com.myproject.mytodolist.dto.MemberRequestDTO;
import com.myproject.mytodolist.service.LoginService;
import com.myproject.mytodolist.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 로그인, 회원가입 기능을 위한 컨트로러
@Controller
@RequestMapping("/mytodolist")
public class LoginController {
    LoginService service;

    @Autowired
    public LoginController(LoginService service) {
        this.service = service;
    }

    // 회원가입페이지로 이동
    @GetMapping("/register")
    public String loginPage(){
        return "member/register";
    }

    //회원가입
    @PostMapping("/register")
    public String login(MemberRequestDTO member){
        System.out.println(member);
        System.out.println(member.getProfileImg().getOriginalFilename());
        service.register(member);
        return "redirect:/mytodolist/register";
    }
}
