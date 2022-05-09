package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.Review;

public interface ReviewRepository {
    Review findById(String St_id);
    void insert(Review r);
    void delete(Review r);
    void Update(Review r);
}
