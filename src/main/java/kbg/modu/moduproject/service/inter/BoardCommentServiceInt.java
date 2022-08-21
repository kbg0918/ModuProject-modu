package kbg.modu.moduproject.service.inter;

import kbg.modu.moduproject.domain.BoardComment;

import java.util.List;

public interface BoardCommentServiceInt {
    List<BoardComment> findByCategory(String category);
    BoardComment findByBoardComment(Integer bcSeq);
    List<BoardComment> findByList(Integer boardSeq);
    boolean save(BoardComment bc);
    boolean delete(BoardComment bc);
}
