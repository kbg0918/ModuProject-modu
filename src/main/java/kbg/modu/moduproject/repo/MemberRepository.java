package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.Member;


public interface MemberRepository {
    void insert(Member m);
    Member findById(String id);

}
