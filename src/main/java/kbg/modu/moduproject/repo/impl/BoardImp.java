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
    public Member findByName(String user_id) {
        return tp.queryForObject("select user_name from member where user_id = ?",
                new BeanPropertyRowMapper<>(Member.class),user_id);

    }

    @Override
    public void insert(Board b) {
        tp.update("insert into board(category, writer, content, user_role, user_seq) value(?,?,?,?,?)",
                b.getCategory(), b.getWriter(), b.getContent(), b.getUser_role(), b.getUser_seq());
    }

    @Override
    public void delete(Board b) {
        tp.update("delete from board where writer = ?",
                b.getWriter());
    }

    @Override
    public void update(Board b) {
        tp.update("update board set content=? where writer = ?",
                b.getContent(), b.getWriter());

    }
}
