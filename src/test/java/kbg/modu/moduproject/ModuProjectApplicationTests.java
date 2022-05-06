package kbg.modu.moduproject;

import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.SignUpRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;

@SpringBootTest
class ModuProjectApplicationTests {
    @Autowired
    SignUpRepository sr;
    @Test
    void contextLoads() {
        sr.save(new Member(1,"ss22","1234","길동","ss@naver.cm","ㅇ","1111-11-11","1111-11-11"));

    }

}
