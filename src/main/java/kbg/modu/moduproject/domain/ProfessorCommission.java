package kbg.modu.moduproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessorCommission {
    //명세 번호
    private Integer pcSeq;
    //명세 번호 참조
    private Integer updateSeq;
    //수정 여부
    private String updateYn;
    //제목
    private String title;
    //작성자 = member id
    private String writer;
    //내용
    private String content;
    //카테고리
    private String category;
    //참조
    private Integer memberSeq;
    //삭제는 했지만 DB엔 남음
    private String delYn;

}
