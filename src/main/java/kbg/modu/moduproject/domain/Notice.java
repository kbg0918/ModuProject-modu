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
    //알람 온 곳의 seq
    private Integer typeSeq;
    //알람 온 곳
    private String writeType;
    //게시물에 무언가를 한사람
    private String userWriter;
    //게시물 작성자
    private String writer;
    private String title;
    private String category;
    //알람 읽음 여부
    private String noticeRead;
    private String addDate;
    //알람 삭제
    private String delYn;
}
