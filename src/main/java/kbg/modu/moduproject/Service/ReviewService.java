package kbg.modu.moduproject.Service;

import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.domain.Review;
import kbg.modu.moduproject.repo.ReviewRepository;
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

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
    Date time =new Date();
    String localtime = format.format(time);

    int cnt =0;
    @Transactional
    public void registration(Review r, Member m){
        System.out.println(m.getSt_id());
            cnt += r.getSeq();
            r.setTotal(cnt);
            r.setSt_id(m.getSt_id());
            r.setSt_role(m.getSt_role());
            r.setWriter(m.getSt_id());
            r.setAdd_date(localtime);
            r.setUp_date(localtime);
            rr.save(r);
        }
    }

