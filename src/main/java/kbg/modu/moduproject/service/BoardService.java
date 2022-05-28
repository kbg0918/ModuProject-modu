package kbg.modu.moduproject.service;

import kbg.modu.moduproject.domain.Board;
import kbg.modu.moduproject.domain.Member;
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

    @Autowired
    BoardRepository br;


    @Transactional
    public void insertBoard(Board b, Member m){
        //Member member = br.findByName(m.getUser_id);
        b.setWriter("gd");
        b.setContent(b.getContent());
        b.setMemberRole("student");
        br.insert(b);
    }

    @Transactional
    public void deleteBoard(Board b){
        b.setWriter(b.getWriter());
        br.delete(b);
    }

    @Transactional
    public void updateBoard(Board b){
        b.setWriter("gd");
        br.update(b);
    }
}
