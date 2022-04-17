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


    }

}
