package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.LoginLog;

import java.util.List;

public interface LoginLogRepository {
    // 로그 Num개 불러오기
    List<LoginLog> lastNumLogs(String id, int num);
    //로그 저장
    void save(LoginLog log);
}
