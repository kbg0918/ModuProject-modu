package kbg.modu.moduproject.controller;

import kbg.modu.moduproject.service.UserCommentService;
import kbg.modu.moduproject.service.SignUpService;
import kbg.modu.moduproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignUpController {

    @Autowired
    SignUpService ss;

    @Autowired
    UserCommentService rs;


    /**
     * 회원가입 폼
     * @Return
     */
    //url 회원가입
    @RequestMapping("/")
    public String mainForm() {
        return "Main";
    };

    @RequestMapping("/signUpForm")
    public String signUpForm() {
        return "signUp";
    };

    //실제 회원가입하는 곳
    @RequestMapping("/signUp")
    public String signUp(User m) {
        ss.joinSignUp(m);
        return "Main";

    }




}