package kbg.modu.moduproject.repo.impl;

import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MemberImp implements MemberRepository {

    @Autowired
    JdbcTemplate tp;

    @Override
    public void save(Member m) {
        tp.update("insert into member(user_id, user_password, user_name, user_address, user_telno, user_email, user_role, category) values(?,?,?,?,?,?,?,?)",
                m.getUser_id(), m.getUser_password(), m.getUser_name(), m.getUser_address(), m.getUser_telno(), m.getUser_email(), m.getUser_role(), m.getCategory());
    }
    @Override
    public Member findById(String user_id) {
        try{
            return tp.queryForObject("select * from member where user_id = ?",
                    new BeanPropertyRowMapper<>(Member.class), user_id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }
}
