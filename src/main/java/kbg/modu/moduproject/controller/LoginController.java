package kbg.modu.moduproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {


    @RequestMapping("/loginForm")
    public String loginForm(){
        return "login";
    }

    @RequestMapping("login")
    public String login(){
        return "Main";
    }
}
