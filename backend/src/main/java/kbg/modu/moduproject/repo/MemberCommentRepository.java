package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.MemberComment;

public interface MemberCommentRepository {
    MemberComment findById(String St_id);
    void insert(MemberComment r);
    void delete(MemberComment r);
    void Update(MemberComment r);
}
