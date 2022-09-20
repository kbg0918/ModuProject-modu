package kbg.modu.moduproject.controller.chat;


import kbg.modu.moduproject.domain.Notice;
import kbg.modu.moduproject.repo.NoticeRepository;
import kbg.modu.moduproject.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NoticeController {

    @Autowired
    NoticeService ns;
    @Autowired
    NoticeRepository nr;

    //알람 DB 저장
    @PostMapping("noticeSave")
    public void noticeSave(@RequestBody Notice n){
        ns.save(n);
    }


    //알람 목록
    @GetMapping("noticeList")
    public ResponseEntity<List<Notice>> noticeList(@RequestParam String writer){
        return new ResponseEntity<>(ns.noticeList(writer),HttpStatus.OK);
    }

    @PostMapping("noticeRead")
    public void noticeRead(@RequestBody Notice n){
        ns.update(n);
    }

    @PostMapping("noticeAllRead")
    public void noticeAllRead(@RequestBody Notice n){
        ns.allRead(n);
    }

    @GetMapping("noticeReadDelete")
    public void noticeAllRead(Notice n, @RequestParam String writer){
        n.setWriter(writer);
        ns.readDelete(n);
    }

    @GetMapping("noticeDelete")
    public void noticeDelete(Notice n, @RequestParam String writer){
        n.setWriter(writer);
        ns.delete(n);
    }

}
