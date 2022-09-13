package kbg.modu.moduproject.controller.board;

import kbg.modu.moduproject.service.MemberCommentService;
import kbg.modu.moduproject.domain.MemberComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberCommentController {

    @Autowired
    MemberCommentService rs;
    /**
     * 리뷰
     */
    @RequestMapping("/memberComment")
    public String review(){
        return "MemberComment";
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
    public String InsertContent(MemberComment r) {
        rs.insertContent(r);
        return "MemberComment";
    }
    @RequestMapping("/DeTest")
    public String DeleteContent(MemberComment r) {
        rs.deleteContent(r);
        return "MemberComment";
    }
    @RequestMapping("/UpTest")
    public String UpdateContent(MemberComment r) {
        rs.UpdateContent(r);
        return "MemberComment";
    }
}
