package kbg.modu.moduproject.controller;


import kbg.modu.moduproject.domain.Board;
import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

    @Autowired
    BoardService bs;

    @RequestMapping("/boardForm")
    public String boardForm(){

        return "Board";
    }
    @RequestMapping("/insertBoard")
    public String insertBoardForm(){

        return "InsertBoard";
    }
    @RequestMapping("/deleteBoard")
    public String deleteBoardForm(){

        return "DeleteBoard";
    }
    @RequestMapping("/updateBoard")
    public String updateBoardForm(){

        return "UpdateBoard";
    }

    @RequestMapping("/insert")
    public String insertBoard(Board b){
        bs.insertBoard(b);
        return "Board";
    }

    @RequestMapping("/delete")
    public String deleteBoard(Board b){
        bs.deleteBoard(b);
        return "Board";
    }
    @RequestMapping("/update")
    public String updateBoard(Board b){
        bs.updateBoard(b);
        return "Board";
    }




}
