package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.User;


public interface SignUpRepository {
    void save(User u);
    User findById(String user_id);

}
