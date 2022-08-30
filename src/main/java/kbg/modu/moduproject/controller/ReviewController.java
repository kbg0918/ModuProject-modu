package kbg.modu.moduproject.controller;


import kbg.modu.moduproject.domain.Review;
import kbg.modu.moduproject.repo.ReviewRepository;
import kbg.modu.moduproject.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReviewController {

    @Autowired
    private ReviewService rs;

    @Autowired
    private ReviewRepository rr;

    @RequestMapping("commission/reviewSave")
    public ResponseEntity reviewSave(@RequestBody Review r){
        return new ResponseEntity(rs.save(r), HttpStatus.OK);
    }

    @RequestMapping("commission/reviewList")
    public ResponseEntity<List<Review>> reviewList(@RequestParam int pcSeq){
        return  new ResponseEntity(rr.reviewList(pcSeq), HttpStatus.OK);
    }


}
