package kbg.modu.moduproject.repo.impl;

import kbg.modu.moduproject.domain.BoardComment;
import kbg.modu.moduproject.repo.BoardCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardCommentImp implements BoardCommentRepository {

    @Autowired
    JdbcTemplate tp;

    @Override
    public List<BoardComment> findByCategory(String category) {
        return tp.query("select * from board_comment where category =?", new BeanPropertyRowMapper<>(BoardComment.class), category);
    }

    @Override
    public BoardComment findByBoardComment(Integer bcSeq) {
        return tp.queryForObject("select * from board_commnet where bc_seq = ?", new BeanPropertyRowMapper<>(BoardComment.class), bcSeq);
    }

    @Override
    public List<BoardComment> findByList(Integer boardSeq) {
        return tp.query("select * from board_comment where board_seq = ?", new BeanPropertyRowMapper<>(BoardComment.class),boardSeq);
    }

    @Override
    public boolean update(BoardComment bc) {
        return tp.update("update board_comment set update_seq=?, update_Yn=?, del_Yn =? where bc_seq=?",
                bc.getBoardSeq(), bc.getUpdateYn(), bc.getDelYn(), bc.getBcSeq())==1;
    }

    @Override
    public boolean delete(BoardComment bc) {
        return tp.update("update board_comment set del_Yn=? where bc_seq = ?",
                bc.getDelYn(), bc.getBcSeq())==1;
    }

    @Override
    public boolean insert(BoardComment bc) {
        return tp.update("insert into board_comment(writer, content, category, update_seq, board_seq) values(?,?,?,?,?)",
                bc.getWriter(), bc.getContent(), bc.getCategory(), bc.getUpdateSeq(), bc.getBoardSeq())==1;
    }
}
