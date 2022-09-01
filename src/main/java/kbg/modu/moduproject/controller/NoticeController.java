package kbg.modu.moduproject.controller;


import kbg.modu.moduproject.domain.Notice;
import kbg.modu.moduproject.repo.NoticeRepository;
import kbg.modu.moduproject.service.NoticeService;
import lombok.RequiredArgsConstructor;
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
        System.out.println(writer);
        System.out.println(ns.noticeList(writer)+"이거나옴?");
        return new ResponseEntity<>(ns.noticeList(writer),HttpStatus.OK);
    }

}
