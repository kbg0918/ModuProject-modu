package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.UserComment;

public interface UserCommentRepository {
    UserComment findById(String St_id);
    void insert(UserComment r);
    void delete(UserComment r);
    void Update(UserComment r);
}
