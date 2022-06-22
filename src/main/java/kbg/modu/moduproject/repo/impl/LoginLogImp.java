package kbg.modu.moduproject.repo.impl;

import kbg.modu.moduproject.domain.LoginLog;
import kbg.modu.moduproject.repo.LoginLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginLogImp implements LoginLogRepository {
    @Autowired
    JdbcTemplate template;

    @Override
    public List<LoginLog> lastNumLogs(String id, int num) {
        return template.query("select * from login_log where id = ? order by login_dttm desc limit ?",
                new BeanPropertyRowMapper<>(LoginLog.class), id, num);
    }

    @Override
    public void save(LoginLog log) {
        template.update("insert into login_log(id, ip, login_status) values (?,?,?)",
                log.getId(), log.getIp(), log.getLoginStatus());
    }
}
