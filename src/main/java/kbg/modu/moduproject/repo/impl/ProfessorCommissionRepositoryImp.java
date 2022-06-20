package kbg.modu.moduproject.repo.impl;

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
    public List<ProfessorCommission> findByCategory(String category) {
        return tp.query("select * from professor_commission where category=? ", new BeanPropertyRowMapper<>(ProfessorCommission.class), category);
    }

    @Override
    public ProfessorCommission findBySeq(Integer pcSeq) {
        return tp.queryForObject("select * from professor_commission where pc_seq=?", new BeanPropertyRowMapper<>(ProfessorCommission.class),pcSeq);
    }

    @Override
    public boolean update(ProfessorCommission pc) {
        return tp.update("update professor_commission set title=?, content=?, del_yn=? where pc_seq = ?",
                pc.getTitle(), pc.getContent(), pc.getContent(), pc.getDelYn(), pc.getPcSeq())==1;
    }

    @Override
    public boolean insert(ProfessorCommission pc) {
        return tp.update("insert into professor_commission(category, title, content) values(?,?,?)",
                pc.getCategory(), pc.getTitle(), pc.getContent())==1;
    }
}
