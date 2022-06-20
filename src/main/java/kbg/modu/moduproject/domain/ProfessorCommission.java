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
    private Integer pcSeq;
    private String title;
    private String content;
    private String category;
    private Integer memberSeq;
    private String delYn;

}
