package kbg.modu.moduproject.service;

import kbg.modu.moduproject.domain.Board;
import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    @Autowired
    BoardRepository br;


    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
    Date time =new Date();
    String localtime = format.format(time);

    @Transactional
    public void insertBoard(Board b){
        Member m = br.findByName(b.getMember().getUser_id());
        b.setWriter("Gd");
        b.setContent(b.getContent());
        b.setUser_role("student");
        b.setUser_seq(m.getUser_seq());
        b.setAdd_date(localtime);
        b.setUp_date(localtime);
        br.insert(b);
    }

    @Transactional
    public void deleteBoard(Board b){
        b.setWriter(b.getWriter());
        br.delete(b);
    }

    @Transactional
    public void updateBoard(Board b){
        b.setUp_date(localtime);
        b.setWriter("gd");
        br.update(b);
    }
}
