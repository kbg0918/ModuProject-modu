package kbg.modu.moduproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageController {

    @RequestMapping("/MyPage")
    public String MyPageForm(){
        return "Profile";
    }
}
