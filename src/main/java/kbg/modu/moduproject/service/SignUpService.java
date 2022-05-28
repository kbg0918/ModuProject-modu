package kbg.modu.moduproject.service;

import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {

    @Autowired
    MemberRepository sr;

    // Id 중복체크
    public boolean checkId(String id){
        Member m = sr.findById(id);
        if(m != null || id == null){
            System.out.println("중복!!");
            System.out.println(id);
            return false;
        }else {
            System.out.println("중복안됨");
            return true;
        }
    }

    //회원가입
    @Transactional
    public void joinSignUp(Member m){
        /*
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        m.setUser_password(passwordEncoder.encode(m.getUser_password()));
         */
        sr.insert(m);

    }

}
