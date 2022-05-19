package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.Board;
import kbg.modu.moduproject.domain.Member;

import java.util.List;

public interface BoardRepository {
     Member findByName(String user_name);
     void insert(Board b);
     void delete(Board b);
     void update(Board b);

}
