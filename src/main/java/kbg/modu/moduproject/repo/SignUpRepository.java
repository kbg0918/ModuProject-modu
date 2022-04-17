package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.Member;
import org.springframework.web.bind.annotation.Mapping;


public interface SignUpRepository {
    void save(Member m);
}
