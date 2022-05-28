package kbg.modu.moduproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    //게시글 조회
    private int boardSeq;
    //카테고리로 나누기
    private String category;
    //작성자
    private String writer;
    //내용
    private String content;
    //권한(선배, 교수, 학생)
    private String memberRole;
    //member table 참조
    private int memberSeq;
}
