package kbg.modu.moduproject.cnt;

import kbg.modu.moduproject.Service.SignUpService;
import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class signUpController {
    @Autowired
    SignUpService Ss;

    /**
     * 회원가입 폼
     * @Return
     */
    @GetMapping("/signUp")
    public String signUpForm(){
        return "signUp";
    }

    @PostMapping("/signUp")
    public String sginUp(Member m){
        Ss.joinSignUp(m);
        return "redirect:/login";
    }


}
