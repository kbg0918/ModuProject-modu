package kbg.modu.moduproject.service.inter;

import kbg.modu.moduproject.domain.Review;
import kbg.modu.moduproject.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ReviewService implements ReviewServiceInt {
    @Autowired
    ReviewRepository rr;

    @Override
    @Transactional
    public boolean save(Review r) {
        if(r.getReviewSeq() == null){
            return rr.insert(r);
        }
        r.setDelYn("N");
        r.setUpdateYn("Y");
        rr.update(r);
        return rr.insert(r);
    }


    @Override
    @Transactional
    public boolean delete(Review r) {
        r.setDelYn("Y");
        return rr.delete(r);
    }


}
