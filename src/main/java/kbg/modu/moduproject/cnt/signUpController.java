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
    @RequestMapping("/")
    public String signUpForm() {
        return "signUp";
    };


    @RequestMapping("/signUp")
    public String signUp(Member m) {
        ss.joinSignUp(m);
        return "login";
    }

    /**
     * 리뷰
     */
    @RequestMapping("/Ct")
    public  String ContentForm(){
        return "ContentTest";
    }
    @RequestMapping("/CTest")
    public String Content(Review r, Member m) {
        rs.registration(r,m);
        return "login";
    }


}
