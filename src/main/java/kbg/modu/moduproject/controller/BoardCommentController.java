package kbg.modu.moduproject.controller;

import kbg.modu.moduproject.domain.BoardComment;
import kbg.modu.moduproject.repo.BoardCommentRepository;
import kbg.modu.moduproject.service.BoardCommentService;
import kbg.modu.moduproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class BoardCommentController {

    @Autowired
    private BoardCommentService bcs;

    @Autowired
    private BoardCommentRepository bcr;

    @Autowired
    private BoardService bs;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @ResponseBody
    @PostMapping("board/commentSave")
    public String commentSave(@RequestBody BoardComment bc, ModelMap mm){
        bcs.save(bc);
        System.out.println(bc);
        return "redirect:/board/PostDetail?boardSeq="+bc.getBoardSeq();
    }




}
