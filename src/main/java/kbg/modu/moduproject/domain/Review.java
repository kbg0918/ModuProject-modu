package kbg.modu.moduproject.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
    //리뷰 번호
    private Integer reviewSeq;
    //참조 번호
    private Integer pcSeq;
    //수정한 댓글 번호 참조
    private Integer updateSeq;
    //작성자
    private String writer;
    //내용
    private String content;
    //별점
    private float starScore;
    //수정여부
    private String updateYn;
    //삭제여부
    private String delYn;
    //등록 날짜
    private String addDate;
    //수정날짜
    private String upDate;
}
