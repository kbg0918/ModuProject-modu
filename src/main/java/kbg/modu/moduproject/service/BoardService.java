package kbg.modu.moduproject.service;

import kbg.modu.moduproject.domain.Board;
import kbg.modu.moduproject.repo.BoardRepository;
import kbg.modu.moduproject.service.inter.BoardServiceInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class BoardService implements BoardServiceInt {

    @Autowired
    private BoardRepository br;


    @Override
    public Integer countView(Integer boardSeq) {
        return br.countView(boardSeq);
    }

    @Override
    @Transactional
    public boolean save(Board b) {
        if(b.getBoardSeq() == null){
            return br.insert(b);
        }else{
            b.setDelYn("N");
            b.setUpdateYn("Y");
            br.update(b);
            return br.insert(b);
        }
    }

    @Override
    @Transactional
    public boolean delete(Board b) {
        b.setDelYn("Y");
        return br.delete(b);
    }
}
