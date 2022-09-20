package kbg.modu.moduproject.repo;


import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.domain.Notice;

import java.util.List;

public interface NoticeRepository {
    List<Notice> noticeList(String writer);
    Member findBySeq(String userWriter);
    Notice findReadNotice(String writer);
    void insert(Notice n);
    void updateRead(Notice n);
    public void delete(Notice n);
    public void allRead(Notice n);
}
