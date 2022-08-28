package kbg.modu.moduproject.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
    private Integer noticeSeq;
    private Integer memberSeq;
    private Integer typeSeq;
    private String writeType;
    private String userWriter;
    private String writer;
    private String title;
    private String category;
    private String addDate;
}
