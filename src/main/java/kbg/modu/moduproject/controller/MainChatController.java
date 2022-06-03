package kbg.modu.moduproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainChatController {

    @GetMapping("/MODUChatting")
    public String indexFrom(){
        return "/MODUChat";
    }
}
