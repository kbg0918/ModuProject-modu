package kbg.modu.moduproject.repo.impl;

import kbg.modu.moduproject.domain.Board;
import kbg.modu.moduproject.domain.User;
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
    public List<Board> findByCategory(int user_seq) {
        return tp.query("select u.category from board b join user u on b.user_seq=u.user_seq where b.user_seq = ?",
                new BeanPropertyRowMapper(Board.class), user_seq);
    }

    @Override
    public Board findByName(String user_name) {
        return tp.queryForObject("select user_name from user u join board b on u.user_seq=b.user_seq where user_name = ?",
                new BeanPropertyRowMapper<>(Board.class), user_name );

    }

    @Override
    public void insert(Board b) {
        tp.update("insert into board(category, writer, content, user_role, user_like, user_unlike, user_seq, add_date, up_date) value(?,?,?,?,?,?,?,?,?)",
                b.getCategory(), b.getWriter(), b.getContent(), b.getUser_role(), b.getUser_like(), b.getUser_unlike(), b.getUser_seq(), b.getAdd_date(), b.getUp_date());
    }

    @Override
    public void delete(Board b) {
        tp.update("delete from board where user_seq = ?",
                b.getUser_seq());
    }

    @Override
    public void update(Board b) {
        tp.update("update board set content=?, user_like=?, user_unlike=?, up_date=? where user_seq = ?",
                b.getContent(), b.getUser_like(), b.getUser_unlike(), b.getUser_seq());

    }
}
