package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.Board;
import kbg.modu.moduproject.domain.User;

import java.util.List;

public interface BoardRepository {
     List<Board> findByCategory(int user_seq);
     Board findByName(String user_name);
     void insert(Board b);
     void delete(Board b);
     void update(Board b);

}
