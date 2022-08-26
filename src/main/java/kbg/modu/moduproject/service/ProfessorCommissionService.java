package kbg.modu.moduproject.service;


import kbg.modu.moduproject.domain.ProfessorCommission;
import kbg.modu.moduproject.repo.ProfessorCommissionRepository;
import kbg.modu.moduproject.service.inter.ProfessorCommissionServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorCommissionService implements ProfessorCommissionServiceInt {

    @Autowired
    private ProfessorCommissionRepository pr;


    @Override
    public boolean save(ProfessorCommission pc) {
        if(pc.getPcSeq() == null){
            return pr.insert(pc);
        }else{
            pc.setDelYn("N");
            pc.setUpdateYn("Y");
            pr.update(pc);
            return pr.insert(pc);
        }
    }

    @Override
    public boolean delete(ProfessorCommission pc) {
        pc.setDelYn("Y");
        return pr.delete(pc);
    }



}
