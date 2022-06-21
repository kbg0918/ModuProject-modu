/*유저 테이블*/
create table if not exists member(
    seq int auto_increment primary key,
    id varchar(255) unique,
    pwd varchar(255) not null,
    member_name varchar(255) not null,
    address varchar(255),
    telNo varchar(255) ,
    email varchar(255) ,
    member_role varchar(255) not null,
    category varchar(255) not null,
    useYn varchar(1) default 'Y' not null,
    privacy char(1) default 'N' comment '개인정보 동의',
    add_date datetime not null DEFAULT CURRENT_TIMESTAMP,
    up_date datetime on update CURRENT_TIMESTAMP
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


/*리뷰 테이블*/
create table if not exists memberComment(
    mc_seq int auto_increment primary key,
    content varchar(4096) not null,
    writer varchar(255) not null,
    star_score int not null,
    member_seq int null,
    add_date datetime not null DEFAULT CURRENT_TIMESTAMP,
    up_date datetime on update CURRENT_TIMESTAMP
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/* 프로필 테이블*/
create table if not exists member_profile(
    profile_seq int auto_increment primary key,
    imgUrl varchar(255),
    member_rank int,
    comment varchar(1000) not null comment '리뷰',
    add_date datetime DEFAULT CURRENT_TIMESTAMP,
    up_date datetime on update CURRENT_TIMESTAMP
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*포트폴리오 테이블 role 조건 */
create table if not exists member_portfolio(
    portfolio_seq int auto_increment primary key,
    member_name varchar(255) not null,
    certificate varchar(255) not null,
    member_role varchar(255) not null,
    imgUrl varchar(255),
    add_date datetime DEFAULT CURRENT_TIMESTAMP,
    up_date datetime on update CURRENT_TIMESTAMP
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*카테고리에 따른 게시판 테이블 */
create table if not exists board(
    board_seq int auto_increment primary key,
    category varchar(255) not null,
    writer varchar(255) not null,
    content varchar(4096) not null,
    member_role varchar(255) not null,
    member_seq int null,
    add_date datetime not null DEFAULT CURRENT_TIMESTAMP,
    up_date datetime on update CURRENT_TIMESTAMP
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


/*게시판 댓글*/
create table if not exists board_comment(
    bc_seq int auto_increment primary key,
    writer varchar(255) not null,
    content varchar(4096) not null,
    member_seq int null,
    member_rank int,
    add_date datetime DEFAULT CURRENT_TIMESTAMP,
    up_date datetime on update CURRENT_TIMESTAMP
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



create table if not exists board_views(
    view_seq int auto_increment primary key,
    board_seq int,
    add_date datetime DEFAULT CURRENT_TIMESTAMP comment '조회'

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


/*유저 채팅*/
create table if not exists chatting_matching(
    cm_seq int auto_increment primary key comment 'chatting_matching',
    send varchar(300) not null comment '보내는 채팅',
    receive varchar(300) not null comment '받는 채팅',
    member_role varchar(255) not null,
    add_date datetime DEFAULT CURRENT_TIMESTAMP comment '보낸 시간'
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


/*채팅 기록*/
create table if not exists chatting_log(
    cl_seq int auto_increment primary key comment 'chatting_log',
    send varchar(300) not null comment '보낸 채팅 기록',
    receive varchar(300) not null comment '받은 채팅 기록',
    member_role varchar(255) not null,
    add_date datetime DEFAULT CURRENT_TIMESTAMP comment '보낸 시간'
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*로그인 기록*/
create table if not exists login_log (
    login_seq int auto_increment primary key,
    id varchar(255) not null,
    ip varchar(255),
    member_role varchar(255) not null,
    login_status char(1) not null,
    login_dttm datetime DEFAULT CURRENT_TIMESTAMP comment '로그인 시간'

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


/*좋아요 싫어요*/

create table if not exists member_like(
    like_seq int auto_increment primary key,
    member_seq int,
    flag int(1)

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table if not exists professor_commission(
    pc_seq int auto_increment primary key,
    title varchar(2555) not null,
    writer varchar(100) not null,
    content varchar(10000) not null,
    category varchar(255) not null,
    member_seq int,
    del_yn char(1) DEFAULT 'N' not null,
    add_date datetime DEFAULT CURRENT_TIMESTAMP,
    up_date datetime on update CURRENT_TIMESTAMP

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
