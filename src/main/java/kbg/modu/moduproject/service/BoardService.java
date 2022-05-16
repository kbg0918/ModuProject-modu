package kbg.modu.moduproject.service;

import kbg.modu.moduproject.domain.Board;
import kbg.modu.moduproject.domain.User;
import kbg.modu.moduproject.repo.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BoardService {
    List<Board> list = new ArrayList<>();
    @Autowired
    BoardRepository br;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
    Date time =new Date();
    String localtime = format.format(time);


    @Transactional
    public void insertBoard(Board b){
        list = br.findByCategory(1);
        b.setCategory("Education");
        b.setWriter("작성자");
        b.setContent(b.getContent());
        b.setUser_role("student");
        b.setUser_like(b.getUser_like());
        b.setUser_unlike(b.getUser_unlike());
        b.setUser_seq(1);
        b.setAdd_date(localtime);
        b.setUp_date(localtime);

        br.insert(b);
    }

    @Transactional
    public void deleteBoard(Board b){
        b.setUser_seq(1);
        br.delete(b);
    }

    @Transactional
    public void updateBoard(Board b){
        b.setUser_seq(1);
        br.update(b);
    }
}
