package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.Member;


public interface MemberRepository {
    void save(Member u);
    Member findById(String user_id);

}
