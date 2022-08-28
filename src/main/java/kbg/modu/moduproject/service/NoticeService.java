package kbg.modu.moduproject.service;

import kbg.modu.moduproject.domain.Notice;
import kbg.modu.moduproject.repo.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoticeService{

    @Autowired
    NoticeRepository nr;

    public List<Notice> noticeList(String writer){
        return nr.noticeList(writer);
    }


    @Transactional
    public void save(Notice n) {
        nr.insert(n);
    }
}
