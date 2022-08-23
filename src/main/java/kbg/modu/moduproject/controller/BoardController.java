package kbg.modu.moduproject.controller;


import kbg.modu.moduproject.domain.Board;
import kbg.modu.moduproject.repo.BoardRepository;
import kbg.modu.moduproject.service.BoardCommentService;
import kbg.modu.moduproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class BoardController {

    @Autowired
    BoardService bs;

    @Autowired
    BoardRepository br;

    @Autowired
    private BoardCommentService bcs;

    @RequestMapping(value="board/InsertForm", method = RequestMethod.GET)
    public String boardInsertForm(){
        return "board/InsertForm";
    }

    //카테고리로 분류
    @RequestMapping(value="board/boardSave")
    public String save(Board b){
        b.setMemberSeq(br.findByMemberSeq(b.getWriter()).getSeq());
        bs.save(b);
        return "redirect:/board/Post?category="+b.getCategory();
    }

    //게시물 목록
    @RequestMapping("board/Post")
    public String postForm(@RequestParam(required = false) String category, ModelMap mm){
        if(category == null){
            mm.put("post",br.categoryList());
        }else{
            mm.put("post",bs.findByCategory(category));

        }
        return "board/Post";
    }

    //게시물 상세
    @RequestMapping("board/PostDetail")
    public String detailForm(@RequestParam int boardSeq, ModelMap mm){
        mm.put("post", br.findBySeq(boardSeq));
        return "board/PostDetail";
    }







}
