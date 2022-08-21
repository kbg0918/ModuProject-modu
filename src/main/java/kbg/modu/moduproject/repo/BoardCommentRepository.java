package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.BoardComment;

import java.util.List;

public interface BoardCommentRepository {
    List<BoardComment> findByCategory(String category);
    BoardComment findByBoardComment(Integer bcSeq);
    List<BoardComment> findByList(Integer boardSeq);
    boolean update(BoardComment bc);
    boolean delete(BoardComment bc);
    boolean insert(BoardComment bc);
}
