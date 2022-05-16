package kbg.modu.moduproject.controller;

import kbg.modu.moduproject.service.UserCommentService;
import kbg.modu.moduproject.domain.UserComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserCommentController {

    @Autowired
    UserCommentService rs;
    /**
     * 리뷰
     */
    @RequestMapping("/userComment")
    public String review(){
        return "UserComment";
    }
    @RequestMapping("/ITest")
    public String InsertForm(){
        return "InsertTest";
    }
    @RequestMapping("/DTest")
    public String DeleteForm(){
        return "DeleteTest";
    }
    @RequestMapping("UTest")
    public String UpdateForm(){
        return "UpdateTest";
    }
    @RequestMapping("/InTest")
    public String InsertContent(UserComment r) {
        rs.insertContent(r);
        return "UserComment";
    }
    @RequestMapping("/DeTest")
    public String DeleteContent(UserComment r) {
        rs.deleteContent(r);
        return "UserComment";
    }
    @RequestMapping("/UpTest")
    public String UpdateContent(UserComment r) {
        rs.UpdateContent(r);
        return "UserComment";
    }
}
