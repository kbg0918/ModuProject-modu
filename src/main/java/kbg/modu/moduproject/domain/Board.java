package kbg.modu.moduproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    //게시글 조회
    private Integer boardSeq;
    //제목
    private String title;
    //작성자
    private String writer;
    //내용
    private String content;
    //카테고리로
    private String category;
    //참조
    private Integer memberSeq;
    //삭제는 했지만 DB엔 남아있음
    private String delYn;
    //등록 시간
    private String addDate;
}
