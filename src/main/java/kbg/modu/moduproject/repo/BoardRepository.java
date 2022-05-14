package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.Board;
import kbg.modu.moduproject.domain.User;

public interface BoardRepository {
    public String findCategory(User u);
    public String findId(User u);
    public void insert(Board b);
    public void delete(Board b);
    public void update(Board b);

}
