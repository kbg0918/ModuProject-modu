package kbg.modu.moduproject.service;

import kbg.modu.moduproject.domain.User;
import kbg.modu.moduproject.repo.UserRepository;
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

    @Autowired
    UserRepository sr;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
    Date time =new Date();
    String localtime = format.format(time);

    // Id 중복체크
    public boolean checkId(String user_id){
        User u = sr.findById(user_id);
        if(u != null || user_id == null){
            System.out.println("중복!!");
            System.out.println(user_id);
            return false;
        }else {
            System.out.println("중복안됨");
            return true;
        }
    }

    //회원가입
    @Transactional
    public void joinSignUp(User u){
        if(checkId(u.getUser_id())){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            u.setUser_password(passwordEncoder.encode(u.getUser_password()));
            u.setAdd_date(localtime);
            u.setUp_date(localtime);
            sr.save(u);
        }
    }

}
