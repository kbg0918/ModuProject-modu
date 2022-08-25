package kbg.modu.moduproject.service;

import kbg.modu.moduproject.domain.BoardComment;
import kbg.modu.moduproject.repo.BoardCommentRepository;
import kbg.modu.moduproject.service.inter.BoardCommentServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardCommentService implements BoardCommentServiceInt {

    @Autowired
    BoardCommentRepository bcr;

    @Override
    public List<BoardComment> findByCategory(String category) {
        return bcr.findByCategory(category);
    }

    @Override
    public BoardComment findByBoardComment(Integer bcSeq) {
        return bcr.findByBoardComment(bcSeq);
    }

    @Override
    public List<BoardComment> findByList(Integer boardSeq) {
        return bcr.findByList(boardSeq);
    }

    @Override
    @Transactional
    public boolean save(BoardComment bc) {
        if(bc.getBcSeq() == null){
            return bcr.insert(bc);
        }
        bc.setDelYn("N");
        bc.setUpdateYn("Y");
        bcr.update(bc);
        return bcr.insert(bc);
    }

    @Override
    @Transactional
    public boolean delete(BoardComment bc) {
        bc.setDelYn("Y");
        return bcr.delete(bc);
    }
}
