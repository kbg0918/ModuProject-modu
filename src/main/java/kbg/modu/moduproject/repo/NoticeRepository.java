package kbg.modu.moduproject.repo;


import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.domain.Notice;

import java.util.List;

public interface NoticeRepository {
    List<Notice> noticeList(String writer);
    Member findBySeq(String userWriter);
    void insert(Notice n);
}
