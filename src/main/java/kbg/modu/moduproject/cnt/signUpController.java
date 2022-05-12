package kbg.modu.moduproject.cnt;

import kbg.modu.moduproject.Service.ReviewService;
import kbg.modu.moduproject.Service.SignUpService;
import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.domain.Review;
import kbg.modu.moduproject.repo.SignUpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class signUpController {

    @Autowired
    SignUpService ss;

    @Autowired
    ReviewService rs;


    /**
     * 회원가입 폼
     * @Return
     */
    //url 회원가입
    @RequestMapping("/")
    public String signUpForm() {
        return "signUp";
    };


    //실제 회원가입하는 곳
    @RequestMapping("/signUp")
    public String signUp(Member m) {
        ss.joinSignUp(m);
        return "login";
    }




}
