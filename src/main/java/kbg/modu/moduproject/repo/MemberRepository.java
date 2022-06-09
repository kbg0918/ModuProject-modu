package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.Member;

import java.util.List;


public interface MemberRepository {
    void insert(Member m);
    Member findById(String id);
    void update(Member m);
    void useYnUpdate(Member m);
    List<Member> findAll();


}
