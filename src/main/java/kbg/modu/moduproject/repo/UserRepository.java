package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.User;


public interface UserRepository {
    void save(User u);
    User findById(String user_id);

}
