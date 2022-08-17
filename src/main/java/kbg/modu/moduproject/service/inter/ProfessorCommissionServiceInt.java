package kbg.modu.moduproject.service.inter;


import kbg.modu.moduproject.domain.ProfessorCommission;

import java.util.List;

public interface ProfessorCommissionServiceInt {
    List<ProfessorCommission> findByCategory(String category);
    ProfessorCommission findBySeq(Integer pcSeq);
    boolean save(ProfessorCommission pc);
    boolean delete(ProfessorCommission pc);
}
