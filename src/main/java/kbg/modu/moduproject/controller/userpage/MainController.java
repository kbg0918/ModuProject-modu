package kbg.modu.moduproject.controller.userpage;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String mainForm() {
        return "Main";
    }

    @RequestMapping("/MainForm")
    public String main(){
        return "Main";
    }
}
