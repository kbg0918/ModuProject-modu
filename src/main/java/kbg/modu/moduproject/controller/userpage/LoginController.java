package kbg.modu.moduproject.controller.userpage;


import kbg.modu.moduproject.domain.LoginLog;
import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.MemberRepository;
import kbg.modu.moduproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    LoginService ls;
    @Autowired
    MemberRepository mr;

    @RequestMapping("/LoginForm")
    public String Login(){
        return "login";
    }

    @RequestMapping("/LoginAction")
    public String LoginAction(@RequestParam String id, @RequestParam String pwd, HttpServletRequest request, HttpSession session){

        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        // local host 에서 시도하면 ip v6로 나오기는 하는데 리모트로 시도하면 v4로 나온답니다
        // 테스트 필요.


        // login 시도. if안의 함수에서 로그인 로그를 자동으로 남긴다.

        if(!ls.login(id, pwd, ip) ) {
            //로그인 실패시
            return "login";
            //로그인 페이지로 돌아감.
        }




        Member m = mr.findById(id);
        // 로그인 성공시 session에 member m을 집어넣음
        session.setAttribute("member", m);


        return "Main";
    }
    @RequestMapping("/Logout")
    public String logout(HttpSession session){
        session.removeAttribute("member");
        return "Main";
    }
}
