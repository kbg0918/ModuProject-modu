package kbg.modu.moduproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    private int seq;
    private int total;
    private int star;
    private String content;
    private String writer;
    private String St_id;
    private String St_role;
    private String add_date;
    private String up_date;

}
