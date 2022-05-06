package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;
import java.util.Optional;


public interface SignUpRepository {
    void save(Member m);
    Member findById(String St_id);

}
