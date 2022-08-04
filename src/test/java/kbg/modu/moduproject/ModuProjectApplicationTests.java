package kbg.modu.moduproject;

import kbg.modu.moduproject.domain.Board;
import kbg.modu.moduproject.domain.ProfessorCommission;
import kbg.modu.moduproject.repo.BoardRepository;
import kbg.modu.moduproject.repo.MemberCommentRepository;
import kbg.modu.moduproject.repo.MemberRepository;
import kbg.modu.moduproject.repo.ProfessorCommissionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ModuProjectApplicationTests {
    @Autowired
    MemberRepository sr;

    @Autowired
    BoardRepository br;

    @Autowired
    MemberCommentRepository rr;

    @Autowired
    ProfessorCommissionRepository pc;
    @Test
    void contextLoads() {
    }


}
