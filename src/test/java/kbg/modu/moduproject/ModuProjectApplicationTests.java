package kbg.modu.moduproject;

import kbg.modu.moduproject.domain.Board;
import kbg.modu.moduproject.repo.BoardRepository;
import kbg.modu.moduproject.repo.UserCommentRepository;
import kbg.modu.moduproject.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ModuProjectApplicationTests {
    @Autowired
    UserRepository sr;

    @Autowired
    BoardRepository br;

    @Autowired
    UserCommentRepository rr;
    @Test
    void contextLoads() {
        br.insert(new Board(1,"응","a","a","a",1,2,1,"11","11"));
    }


}
