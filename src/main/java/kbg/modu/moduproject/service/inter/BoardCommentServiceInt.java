package kbg.modu.moduproject.service.inter;

import kbg.modu.moduproject.domain.BoardComment;

import java.util.List;

public interface BoardCommentServiceInt {
    boolean save(BoardComment bc);
    boolean delete(BoardComment bc);
}
