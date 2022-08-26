package kbg.modu.moduproject.service.inter;

import kbg.modu.moduproject.domain.Board;

import java.util.List;

public interface BoardServiceInt {
    Integer countView(Integer boardSeq);
    boolean save(Board b);
    boolean delete(Board b);
}
