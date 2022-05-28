package kbg.modu.moduproject.repo.impl;

import kbg.modu.moduproject.domain.MemberComment;
import kbg.modu.moduproject.repo.MemberCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MemberCommentImp implements MemberCommentRepository {

    @Autowired
    JdbcTemplate tp;

    @Override
    public MemberComment findById(String id) {
        try{
            return tp.queryForObject("select * from member_comment where id = ?",
                    new BeanPropertyRowMapper<>(MemberComment.class),id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public void insert(MemberComment r) {
        tp.update("insert into member_comment(starScore, content, writer) values(?,?,?)",
                r.getStarScore(), r.getContent(), r.getWriter());

    }

    @Override
    public void delete(MemberComment r) {
        tp.update("delete from member_comment where writer =?",
                r.getWriter());
    }

    @Override
    public void Update(MemberComment r) {
        tp.update("update member_comment set starScore = ?, content = ? where writer=?",
                r.getStarScore(), r.getContent(), r.getWriter());
    }

}
