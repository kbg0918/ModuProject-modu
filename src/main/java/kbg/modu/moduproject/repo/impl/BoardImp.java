package kbg.modu.moduproject.repo.impl;

import kbg.modu.moduproject.domain.Board;
import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BoardImp implements BoardRepository {

    @Autowired
    JdbcTemplate tp;


    @Override
    public Member findByMemberSeq(String writer) {
        return tp.queryForObject("select * from member where member_name =?", new BeanPropertyRowMapper<>(Member.class), writer);
    }

    @Override
    public Member findByRole(Integer memberSeq) {
        return tp.queryForObject("select * from member where seq=?", new BeanPropertyRowMapper<>(Member.class), memberSeq);
    }

    @Override
    public List<Board> findByCategory(String category) {
        return tp.query("select * from board where category =?", new BeanPropertyRowMapper<>(Board.class), category);
    }

    @Override
    public Board findBySeq(Integer boardSeq) {
        return tp.queryForObject("select * from board where board_seq = ?", new BeanPropertyRowMapper<>(Board.class), boardSeq);
    }

    @Override
    public List<Board> categoryList() {
        return tp.query("select * from board", new BeanPropertyRowMapper<>(Board.class));
    }

    @Override
    public boolean update(Board b) {
        return tp.update("update board set title=?, content=?, del_Yn=? where board_seq =?",
                b.getTitle(), b.getContent(), b.getDelYn(), b.getBoardSeq())==1;
    }

    @Override
    public boolean delete(Board b) {
        return tp.update("update board set del_yn=? where board_seq = ?",
                b.getDelYn(), b.getBoardSeq())==1;
    }

    @Override
    public boolean insert(Board b) {
        return tp.update("insert into board(title, category, writer, content) values(?,?,?,?)",
                b.getTitle(), b.getCategory(), b.getWriter(), b.getContent())==1;
    }
}
