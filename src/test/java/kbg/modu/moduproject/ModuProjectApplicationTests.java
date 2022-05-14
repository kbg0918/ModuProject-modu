package kbg.modu.moduproject;

import kbg.modu.moduproject.domain.Review;
import kbg.modu.moduproject.repo.ReviewRepository;
import kbg.modu.moduproject.repo.SignUpRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ModuProjectApplicationTests {
    @Autowired
    SignUpRepository sr;

    @Autowired
    ReviewRepository rr;
    @Test
    void contextLoads() {
        rr.insert(new Review(1,5,3,"내용","길동","길동","Student","11/11/11","11/11/11"));

    }


}
