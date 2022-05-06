package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.Review;

public interface ReviewRepository {
    Review findById(String St_id);
    void save(Review r);
    void contentDelete(Review r);
}
