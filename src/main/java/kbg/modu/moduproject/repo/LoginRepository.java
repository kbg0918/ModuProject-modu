package kbg.modu.moduproject.repo;

public interface LoginRepository {
    public String findById(String id);
    public String findByPw(String pw);
}
