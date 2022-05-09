package kbg.modu.moduproject.cnt;

import kbg.modu.moduproject.Service.ReviewService;
import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class reivewController {

    @Autowired
    ReviewService rs;
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
