package kbg.modu.moduproject.repo.impl;

import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SignUp implements SignUpRepository {

    @Autowired
    JdbcTemplate tp;
    @Override
    public void save(Member m) {
        tp.update("update member set password = ?, name = ?, email = ?, USER_Role =? ,telnum = ?, address=?, addDate =? where id = ?",
                m.getSt_pw(),m.getSt_name(), m.getSt_email(), m.getSt_telNum(), m.getUSER_Role(), m.getSt_address(), m.getSt_addDate(), m.getSt_id());
    }
}
