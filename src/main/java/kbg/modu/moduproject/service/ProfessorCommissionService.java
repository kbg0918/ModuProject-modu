package kbg.modu.moduproject.service;


import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.domain.ProfessorCommission;
import kbg.modu.moduproject.repo.ProfessorCommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorCommissionService implements ProfessorCommissionServiceInt{

    @Autowired
    private ProfessorCommissionRepository pr;



    @Override
    public List<ProfessorCommission> findByCategory(String category) {
        return pr.findByCategory(category);
    }

    @Override
    public ProfessorCommission findBySeq(Integer pcSeq) {
        return pr.findBySeq(pcSeq);
    }

    @Override
    public boolean save(ProfessorCommission pc) {
        if(pc.getPcSeq() == null){
            return pr.insert(pc);
        }else{
            return pr.update(pc);
        }
    }

    @Override
    public boolean delete(ProfessorCommission pc) {
        pc.setDelYn("Y");
        return pr.update(pc);
    }


}
