package kbg.modu.moduproject.Service;

import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.domain.Review;
import kbg.modu.moduproject.repo.ReviewRepository;
import kbg.modu.moduproject.repo.SignUpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ReviewService {

    @Autowired
    ReviewRepository rr;

    @Autowired
    SignUpRepository sr;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
    Date time =new Date();
    String localtime = format.format(time);

    int cnt =0;
    @Transactional
    public void insertContent(Review r){
            cnt += r.getSeq();
            r.setTotal(cnt);
            r.setSt_id("김길동");
            r.setSt_role("student");
            r.setWriter("홍길동");
            r.setAdd_date(localtime);
            r.setUp_date(localtime);
            rr.insert(r);
    }

    @Transactional
    public void deleteContent(Review r){
        r.setSt_id("김길동");
        rr.delete(r);

    }

    @Transactional
    public void UpdateContent(Review r){
        r.setUp_date(localtime);
        r.setSt_id("김길동");
        rr.Update(r);
    }


    }

