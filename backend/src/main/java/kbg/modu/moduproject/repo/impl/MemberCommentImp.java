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
    public MemberComment findById(String St_id) {
        try{
            return tp.queryForObject("select * from member_comment where St_id = ?",
                    new BeanPropertyRowMapper<>(MemberComment.class),St_id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public void insert(MemberComment r) {
        tp.update("insert into member_comment(star_score, content, writer, user_seq, add_date, up_date) values(?,?,?,?,?,?)",
                r.getStar_score(), r.getContent(), r.getWriter(), r.getUser_seq(), r.getAdd_date(), r.getUp_date());

    }

    @Override
    public void delete(MemberComment r) {
        tp.update("delete from member_comment where writer =?",
                r.getWriter());
    }

    @Override
    public void Update(MemberComment r) {
        tp.update("update member_comment set star_score = ?, content = ?, up_date = ? where writer=?",
                r.getStar_score(), r.getContent(), r.getUp_date(), r.getWriter());
    }

}
