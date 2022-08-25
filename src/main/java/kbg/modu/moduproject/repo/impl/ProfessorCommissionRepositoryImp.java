package kbg.modu.moduproject.repo.impl;

import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.domain.ProfessorCommission;
import kbg.modu.moduproject.repo.ProfessorCommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfessorCommissionRepositoryImp implements ProfessorCommissionRepository {

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
    public List<ProfessorCommission> findByCategory(String category) {
        return tp.query("select * from professor_commission where category=? ", new BeanPropertyRowMapper<>(ProfessorCommission.class), category);
    }

    @Override
    public ProfessorCommission findBySeq(Integer pcSeq) {
        return tp.queryForObject("select * from professor_commission where pc_seq=?", new BeanPropertyRowMapper<>(ProfessorCommission.class),pcSeq);
    }

    @Override
    public boolean update(ProfessorCommission pc) {
        return tp.update("update professor_commission set  update_seq=?, update_Yn=?, del_yn=? where pc_seq = ?",
                pc.getUpdateSeq(), pc.getUpdateYn(), pc.getDelYn(), pc.getPcSeq())==1;
    }

    @Override
    public boolean delete(ProfessorCommission pc) {
        return tp.update("update professor_commission set del_yn=? where pc_seq = ?",
                pc.getDelYn(), pc.getPcSeq())==1;
    }

    @Override
    public boolean insert(ProfessorCommission pc) {
        return tp.update("insert into professor_commission(category, title, writer, content, update_seq, member_seq) values(?,?,?,?,?,?)",
                pc.getCategory(), pc.getTitle(),pc.getWriter(), pc.getContent(), pc.getUpdateSeq(), pc.getMemberSeq())==1;
    }
}
