package kbg.modu.moduproject.repo.impl;

import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

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
    @Override
    public void update(Member m) {
        tp.update("update member set pwd = ?, memberName = ?, address = ?, telNo = ?, email = ?, memeberRole = ?, category = ?, useyn = ?" +
                        "where seq = ?",
                m.getPwd(), m.getMemberName(), m.getAddress(), m.getTelNo(), m.getEmail() , m.getMemberRole() ,m.getCategory() ,m.getUseYn(), m.getSeq());
    }
    @Override
    public void useYnUpdate(Member m) {
        tp.update("update member set useyn = ? where id = ?",
                m.getUseYn(), m.getId());
    }

    @Override
    public List<Member> findAll() {
        return tp.query("select * from member",
                new BeanPropertyRowMapper<>(Member.class));
    }

}
