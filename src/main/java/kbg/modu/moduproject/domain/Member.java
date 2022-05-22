package kbg.modu.moduproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    private int user_seq;
    private String user_id;
    private String user_password;
    private String user_name;
    private String user_address;
    private String user_telno;
    private String user_email;
    private String user_role;
    private String category;
}

