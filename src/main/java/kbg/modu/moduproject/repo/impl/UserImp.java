package kbg.modu.moduproject.repo.impl;

import kbg.modu.moduproject.domain.User;
import kbg.modu.moduproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserImp implements UserRepository {

    @Autowired
    JdbcTemplate tp;

    @Override
    public void save(User u) {
        tp.update("insert into user(user_id, user_password, user_name, user_address, user_telno, user_email, user_role, category, add_date, up_date) values(?,?,?,?,?,?,?,?,?,?)",
                u.getUser_id(), u.getUser_password(), u.getUser_name(), u.getUser_address(), u.getUser_telno(), u.getUser_email(), u.getUser_role(), u.getCategory(),
                u.getAdd_date(), u.getUp_date());
    }
    @Override
    public User findById(String user_id) {
        try{
            return tp.queryForObject("select * from user where user_id = ?",
                    new BeanPropertyRowMapper<>(User.class), user_id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }
}
