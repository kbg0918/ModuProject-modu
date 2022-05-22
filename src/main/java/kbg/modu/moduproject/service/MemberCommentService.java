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
    

    int cnt =0;
    int total = 0;
    @Transactional
    public void insertContent(MemberComment r){
            total += cnt;
            r.setWriter("홍길동");
            rr.insert(r);

            cnt++;
    }

    @Transactional
    public void deleteContent(MemberComment r){
        rr.delete(r);

    }

    @Transactional
    public void UpdateContent(MemberComment r){
        rr.Update(r);
    }


    }

