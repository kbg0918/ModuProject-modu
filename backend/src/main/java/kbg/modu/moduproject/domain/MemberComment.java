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
    private int mc_seq;
    private int total;
    private int star_score;
    private int user_seq;
    private String content;
    private String writer;
    private String add_date;
    private String up_date;

}
