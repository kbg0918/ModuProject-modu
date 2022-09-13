package kbg.modu.moduproject.controller.userpage;

import kbg.modu.moduproject.service.MemberCommentService;
import kbg.modu.moduproject.service.SignUpService;
import kbg.modu.moduproject.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignUpController {

    @Autowired
    SignUpService ss;

    @Autowired
    MemberCommentService rs;


    /**
     * 회원가입 폼
     * @Return
     */
    //url 회원가입


    @RequestMapping("/SignUpForm")
    public String signUpForm() {
        return "signUp";
    };

    //실제 회원가입하는 곳
    @RequestMapping("/signUp")
    public String signUp(Member m) {
        ss.joinSignUp(m);
        return "Main";

    }




}
