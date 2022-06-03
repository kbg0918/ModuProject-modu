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
    public void insert(Member m) {
        tp.update("insert into member(id, pwd, member_name, address, telNo, email, member_role, category) values(?,?,?,?,?,?,?,?)",
                m.getId(), m.getPwd(), m.getMemberName(), m.getAddress(), m.getTelNo(), m.getEmail(), m.getMemberRole(), m.getCategory());
    }
    @Override
    public Member findById(String id) {
        try{
            return tp.queryForObject("select * from member where id = ?",
                    new BeanPropertyRowMapper<>(Member.class), id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }
}
