package kbg.modu.moduproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private int seq;
    private String St_id;
    private String St_pw;
    private String St_name;
    private String St_email;
    private String St_address;
    private String USER_Role;
    private String St_telNum;
    private String St_addDate;
    private String St_upDate;
}

