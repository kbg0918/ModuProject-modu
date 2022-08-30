package kbg.modu.moduproject.repo.impl;

import kbg.modu.moduproject.domain.Review;
import kbg.modu.moduproject.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewImp implements ReviewRepository {

    @Autowired
    JdbcTemplate tp;

    @Override
    public List<Review> reviewList(Integer pcSeq) {
        return tp.query("select * from review where pc_seq = ?", new BeanPropertyRowMapper<>(Review.class), pcSeq);
    }

    @Override
    public boolean update(Review r) {
        return tp.update("update review set update_seq=?, update_Yn=?, del_Yn=? where review_seq = ?",
                r.getUpdateSeq(), r.getUpdateYn(), r.getDelYn(), r.getReviewSeq())==1;
    }

    @Override
    public boolean delete(Review r) {
        return tp.update("update review set del_Yn=? where review_seq=?",
                r.getDelYn(), r.getReviewSeq())==1;
    }

    @Override
    public boolean insert(Review r) {
        return tp.update("insert into review(writer, content, star_score, update_seq, pc_seq) values(?,?,?,?,?)",
                r.getWriter(), r.getContent(), r.getStarScore(), r.getUpdateSeq(), r.getPcSeq())==1;
    }
}
