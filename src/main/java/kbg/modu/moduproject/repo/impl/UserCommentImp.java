package kbg.modu.moduproject.repo.impl;

import kbg.modu.moduproject.domain.UserComment;
import kbg.modu.moduproject.repo.UserCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserCommentImp implements UserCommentRepository {

    @Autowired
    JdbcTemplate tp;

    @Override
    public UserComment findById(String St_id) {
        try{
            return tp.queryForObject("select * from review where St_id = ?",
                    new BeanPropertyRowMapper<>(UserComment.class),St_id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public void insert(UserComment r) {
        tp.update("insert into user_comment(star_score, content, writer, user_like, user_unlike, user_seq, add_date, up_date) values(?,?,?,?,?,?,?,?)",
                r.getStar_score(), r.getContent(), r.getWriter(), r.getUser_like(), r.getUser_unlike(), r.getUser_seq(), r.getAdd_date(), r.getUp_date());

    }

    @Override
    public void delete(UserComment r) {
        tp.update("delete from user_comment where user_seq =?",
                r.getUser_seq());
    }

    @Override
    public void Update(UserComment r) {
        tp.update("update user_comment set star_score = ?, content = ?, up_date = ? where user_seq=?",
                r.getStar_score(), r.getContent(), r.getUp_date(), r.getUser_seq());
    }

}
