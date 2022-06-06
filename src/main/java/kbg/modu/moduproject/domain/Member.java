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
    //회원 조회
    private Integer seq;
    //회원 아이디
    private String id;
    //회원 패스워드
    private String pwd;
    //회원 이름
    private String memberName;
    //회원 주소
    private String address;
    //회원 전화번호
    private String telNo;
    //회원 이메일
    private String email;
    //회원 권한
    private String memberRole;
    //회원 카테고리
    private String category;
    //개인정보 동의
    private String privacy;
    //개정 활성화 여부
    private String useYn;
}

