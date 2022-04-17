package kbg.modu.moduproject.Service;

import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.SignUpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class SignUpService {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
    Date time =new Date();
    String localtime = format.format(time);


    @Autowired
    SignUpRepository sr;

    @Transactional
    public void joinSignUp(Member m){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        m.setSt_pw(passwordEncoder.encode(m.getSt_pw()));
        m.setUSER_Role("Student");
        m.setSt_addDate(localtime);
        sr.save(m);


    }




}
