package kbg.modu.moduproject.controller.board;

import kbg.modu.moduproject.domain.BoardComment;
import kbg.modu.moduproject.repo.BoardCommentRepository;
import kbg.modu.moduproject.service.BoardCommentService;
import kbg.modu.moduproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardCommentController {

    @Autowired
    private BoardCommentService bcs;

    @Autowired
    private BoardCommentRepository bcr;

    @Autowired
    private BoardService bs;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    HashMap<String, String> categoryMap = new HashMap<>();

    //댓글 저장 form
    @PostMapping("board/commentSave")
    public ResponseEntity commentSave(@RequestBody BoardComment bc){
        return new ResponseEntity(bcs.save(bc),HttpStatus.OK);
    }

    //댓글 목록 form
    @GetMapping("board/commentList")
    public ResponseEntity<List<BoardComment>> commentList(@RequestParam String boardSeq){
        return new ResponseEntity<>(bcr.findByList(Integer.parseInt(boardSeq)), HttpStatus.OK);
    }

    //댓글 수정 form
    @PostMapping("board/commentUpdate")
    public ResponseEntity commentUpdate(@RequestBody BoardComment bc) {
        bc.setUpdateSeq(bc.getBcSeq());
        return new ResponseEntity(bcs.save(bc), HttpStatus.OK);
    }

    //댓글 삭제 form
    @GetMapping("board/commentDelete/{bcSeq}")
    public ResponseEntity commentDelete(BoardComment bc, @PathVariable String bcSeq){
        bc.setBcSeq(Integer.parseInt(bcSeq));
        return new ResponseEntity(bcs.delete(bc),HttpStatus.OK);
    }

    //댓글 알림 form
    @RequestMapping("board/writeComment")
    public void commentAlert(){
        System.out.println("alarm controller");
    }



}
