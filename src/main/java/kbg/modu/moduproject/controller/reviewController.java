package kbg.modu.moduproject.controller;

import kbg.modu.moduproject.service.ReviewService;
import kbg.modu.moduproject.domain.User;
import kbg.modu.moduproject.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class reviewController {

    @Autowired
    ReviewService rs;
    /**
     * 리뷰
     */
    @RequestMapping("/Ct")
    public  String ContentForm(){
        return "Review";
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
    public String InsertContent(Review r) {
        rs.insertContent(r);
        return "Review";
    }
    @RequestMapping("/DeTest")
    public String DeleteContent(Review r) {
        rs.deleteContent(r);
        return "Review";
    }
    @RequestMapping("/UpTest")
    public String UpdateContent(Review r) {
        rs.UpdateContent(r);
        return "Review";
    }
}
