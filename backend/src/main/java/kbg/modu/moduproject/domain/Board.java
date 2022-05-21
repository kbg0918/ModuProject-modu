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
    private int board_seq;
    private String title;
    private String category;
    private String writer;
    private String content;
    private String user_role;
    private int user_seq;
    private String add_date;
    private String up_date;
    private Member member;

}
