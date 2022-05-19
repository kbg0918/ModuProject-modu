package kbg.modu.moduproject.service;

import kbg.modu.moduproject.domain.MemberComment;
import kbg.modu.moduproject.repo.MemberCommentRepository;
import kbg.modu.moduproject.repo.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class MemberCommentService {

    @Autowired
    MemberCommentRepository rr;

    @Autowired
    MemberRepository sr;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
    Date time =new Date();
    String localtime = format.format(time);
    

    //만들고 싶은 것 : St_id에 김길동이 아닌 Member 테이블에 있는 St_id값과 일치하는 것이 표시되도록
    int cnt =0;
    int total = 0;
    @Transactional
    public void insertContent(MemberComment r){
            total += cnt;
            r.setWriter("홍길동");
            r.setUser_seq(1);
            r.setAdd_date(localtime);
            r.setUp_date(localtime);
            rr.insert(r);

            cnt++;
    }

    @Transactional
    public void deleteContent(MemberComment r){
        r.setUser_seq(1);
        rr.delete(r);

    }

    @Transactional
    public void UpdateContent(MemberComment r){
        r.setUp_date(localtime);
        r.setUser_seq(1);
        rr.Update(r);
    }


    }

