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
    private Integer bcSeq;
    private String writer;
    private String content;
    private String category;
    private Integer boardSeq;
    private String delYn;
    private String addDate;
    private String upDate;
}
