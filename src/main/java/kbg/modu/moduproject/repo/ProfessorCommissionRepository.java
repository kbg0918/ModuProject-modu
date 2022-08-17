package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.domain.ProfessorCommission;

import java.util.List;

public interface ProfessorCommissionRepository {
    Member findByMemberSeq(String writer);
    Member findByRole(Integer memberSeq);
    List<ProfessorCommission> findByCategory(String category);
    ProfessorCommission findBySeq(Integer pcSeq);
    boolean update(ProfessorCommission pc);
    boolean delete(ProfessorCommission pc);
    boolean insert(ProfessorCommission pc);


}
