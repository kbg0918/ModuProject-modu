package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.Review;

import java.util.List;

public interface ReviewRepository {
    List<Review> reviewList(Integer pcSeq);
    boolean update(Review r);
    boolean delete(Review r);
    boolean insert(Review r);
}
