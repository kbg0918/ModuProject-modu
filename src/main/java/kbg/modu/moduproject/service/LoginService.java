package kbg.modu.moduproject.service;


import kbg.modu.moduproject.domain.LoginLog;
import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.LoginLogRepository;
import kbg.modu.moduproject.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    MemberRepository mr;

    @Autowired
    LoginLogRepository llr;

    @Transactional
    public boolean checkLogin(String id, String pwd){
        Member member = mr.findById(id);
        //DB에 사용자가 없거나, 비밀번호가 지정이 안되있거나
        if(ObjectUtils.isEmpty(member) || !StringUtils.hasText(member.getPwd()))
            return false;

        // 비밀번호 5회 실패해서 useYN이 N인 경우
        if(member.getUseYn().equals("N")){
            return false;
        }


        return member.getPwd().equals(pwd);
    }

    @Transactional
    public boolean login(String id, String pwd, String ip){

        //로그 저장
        boolean  result = checkLogin(id, pwd);

        LoginLog log = LoginLog.builder()
                .id(id)
                .loginStatus(result ? "Y" : "N")
                .ip(ip).build();
        llr.save(log);


        // useYN 설정
        List<LoginLog> lastLogs = llr.lastNumLogs(id, 5);

        if(lastLogs.size() < 5) return result;
        // 불러온 5개의 log의 성공 여부가 모두 n일 경우 계정 비활성화
        if(lastLogs.stream().allMatch(tempLog -> tempLog.getLoginStatus().equals("N") )){

            Member member = mr.findById(id);
            if(member != null){
                member.setUseYn("N");
                mr.useYnUpdate(member);
            }

        }
        return result;
    }
}

