package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.Board;
import kbg.modu.moduproject.domain.Member;

import java.util.List;

public interface BoardRepository {
     Member findByMemberSeq(String writer);
     Board findBySeq(Integer boardSeq);
     List<Board> findByCategory(String category);
     List<Board> categoryList();
     Integer countView(Integer boardSeq);
     boolean update(Board b);
     boolean delete(Board b);
     boolean insert(Board b);

}
