package kbg.modu.moduproject.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardComment {
    //댓글 번호
    private Integer bcSeq;
    //수정한 댓글 번호 참조
    private Integer updateSeq;
    //수정 여부
    private String updateYn;
    //작성자
    private String writer;
    //내용
    private String content;
    //카테고리
    private String category;
    //게시판 번호 참조
    private Integer boardSeq;
    //삭제 여부
    private String delYn;
    //등록 날짜
    private String addDate;
    //수정 날짜
    private String upDate;
}
