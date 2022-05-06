package kbg.modu.moduproject.Service;

import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.SignUpRepository;
import kbg.modu.moduproject.repo.impl.SignUpImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignUpService {

    @Autowired
    SignUpRepository sr;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
    Date time =new Date();
    String localtime = format.format(time);

    public boolean checkId(String St_id){
        Member m = sr.findById(St_id);
        if(m != null){
            System.out.println("중복!!");
            System.out.println(St_id);
            return false;
        }else {
            System.out.println("중복안됨");
            return true;
        }

    }

    @Transactional
    public void joinSignUp(Member m){
        if(checkId(m.getSt_id())){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            m.setSt_pw(passwordEncoder.encode(m.getSt_pw()));
            m.setSt_role("Student");
            m.setAdd_date(localtime);
            m.setUp_date(localtime);
            sr.save(m);
        }
    }

    public boolean checkPassword (String St_id, String St_pw){
        Member m = sr.findById(St_id);
        //DB에 사용자가 없거나, 비밀번호가 지정이 안되있거나
        if(ObjectUtils.isEmpty(m) || StringUtils.hasText(m.getSt_pw()) == false)
            return false;
        return m.getSt_pw().equals(St_pw);
    }




}
