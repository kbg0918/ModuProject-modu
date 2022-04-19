package kbg.modu.moduproject.repo.impl;

import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SignUpImp implements SignUpRepository {

=======
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SignUp implements SignUpRepository {
>>>>>>> 8c59a67 (0419)

    @Autowired
    JdbcTemplate tp;

    @Override
    public void save(Member m) {
<<<<<<< HEAD
        tp.update("insert into member(St_id, St_pw, St_name, St_email, St_role, add_date, up_date) values(?,?,?,?,?,?,?)",
                m.getSt_id(), m.getSt_pw(), m.getSt_name(), m.getSt_email(), m.getSt_role(), m.getAdd_date(), m.getUp_date());
    }
    @Override
    public Member findById(String St_id) {
        try{
            return tp.queryForObject("select * from member where St_id = ?",
                    new BeanPropertyRowMapper<>(Member.class), St_id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }


=======
        tp.update("insert into member values(?,?)",
                m.getSt_id(), m.getSt_id());
    }
>>>>>>> 8c59a67 (0419)
}
