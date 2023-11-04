package com.myproject.mytodolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// 메인 페이지 접속을 위한 컨트롤러
@Controller
@RequestMapping("/mytodolist")
public class IndexController {
    @GetMapping("/index")
    public String index(){
        return ("/main/index");
    }
}
