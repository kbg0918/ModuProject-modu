package kbg.modu.moduproject.repo.impl;

import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.domain.Notice;
import kbg.modu.moduproject.repo.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoticeImp implements NoticeRepository {

    @Autowired
    JdbcTemplate tp;

    @Override
    public List<Notice> noticeList(String writer) {
        return tp.query("select * from notice where writer = ?", new BeanPropertyRowMapper<>(Notice.class), writer);
    }

    @Override
    public Member findBySeq(String writer) {
        return tp.queryForObject("select * from notice where writer = ?",
                new BeanPropertyRowMapper<>(Member.class), writer);
    }

    @Override
    public Notice findReadNotice(String writer) {
        return tp.queryForObject("select * from notice where writer =?",
                new BeanPropertyRowMapper<>(Notice.class), writer);
    }

    @Override
    public void insert(Notice n) {
        tp.update("insert into notice(member_seq, type_seq, write_type, user_writer, writer, title, category) values(?,?,?,?,?,?,?)",
                n.getMemberSeq(), n.getTypeSeq(), n.getWriteType(), n.getUserWriter(), n.getWriter(), n.getTitle(), n.getCategory());
    }

    @Override
    public void updateRead(Notice n) {
        tp.update("update notice set notice_read = ? where notice_seq =?",
                n.getNoticeRead(), n.getNoticeSeq());
    }

    @Override
    public void delete(Notice n){
        tp.update("update notice set del_Yn = ?, notice_read = ? where writer = ?",
                n.getDelYn(), n.getNoticeRead(), n.getWriter());
    }

    @Override
    public void allRead(Notice n) {
        tp.update("update notice set notice_read = ? where writer =?",
                n.getNoticeRead(), n.getWriter());
    }
}
