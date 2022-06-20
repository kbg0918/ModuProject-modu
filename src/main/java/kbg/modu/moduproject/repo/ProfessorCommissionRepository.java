package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.ProfessorCommission;

import java.util.List;

public interface ProfessorCommissionRepository {
    List<ProfessorCommission> findByCategory(String category);
    ProfessorCommission findBySeq(Integer pcSeq);
    boolean update(ProfessorCommission pc);
    boolean insert(ProfessorCommission pc);

}
