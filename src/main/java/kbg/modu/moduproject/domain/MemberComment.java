package kbg.modu.moduproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberComment {
    //리뷰 조회
    private int memberCommentSeq;
    //전체 리뷰 수
    private int total;
    //작성자
    private String writer;
    //리뷰 내용
    private String content;
    //별점
    private int starScore;
    //member table 참조
    private int memberSeq;


}
