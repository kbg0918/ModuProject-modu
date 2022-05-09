package kbg.modu.moduproject.repo.impl;

import kbg.modu.moduproject.domain.Review;
import kbg.modu.moduproject.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReviewImp implements ReviewRepository {

    @Autowired
    JdbcTemplate tp;

    @Override
    public Review findById(String St_id) {
        try{
            return tp.queryForObject("select * from review where St_id = ?",
                    new BeanPropertyRowMapper<>(Review.class),St_id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public void insert(Review r) {
        tp.update("insert into review(total, star, content, writer, St_id, St_role, add_date, up_date) values(?,?,?,?,?,?,?,?)",
                r.getTotal(), r.getStar(), r.getContent(), r.getWriter(), r.getSt_id(), r.getSt_role(), r.getAdd_date(), r.getUp_date());

    }

    @Override
    public void delete(Review r) {
        tp.update("delete from review where St_id = ?",
                r.getSt_id());
    }

    @Override
    public void Update(Review r) {
        tp.update("update review set star = ?, content = ?, up_date = ? where St_id = ?",
                r.getStar(), r.getContent(), r.getUp_date(), r.getSt_id());
    }

}
