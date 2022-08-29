package kbg.modu.moduproject.service.inter;

import kbg.modu.moduproject.domain.Review;

public interface ReviewServiceInt {
    boolean save(Review r);
    boolean delete(Review r);
}
