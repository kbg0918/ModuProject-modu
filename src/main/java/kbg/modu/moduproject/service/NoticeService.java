package kbg.modu.moduproject.service;

import kbg.modu.moduproject.domain.Notice;
import kbg.modu.moduproject.repo.NoticeRepository;
import org.aspectj.weaver.ast.Not;
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

    @Transactional
    public void update(Notice n){
        nr.updateRead(n);
    }

    @Transactional
    public void delete(Notice n){
        n.setNoticeRead("Y");
        n.setDelYn("Y");
        nr.delete(n);
    }

    @Transactional
    public void readDelete(Notice n){
        if(nr.findReadNotice(n.getWriter()).getNoticeRead().equals("Y")){
            nr.delete(n);
        }else{
            System.out.println("읽은 알림이 없습니다.");
        }
    }

    @Transactional
    public void allRead(Notice n){
        nr.allRead(n);
    }
}
