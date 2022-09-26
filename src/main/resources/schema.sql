/*유저 테이블 clear*/
create table if not exists member(
    seq int auto_increment primary key,
    id varchar(255) unique,
    pwd varchar(255) not null,
    member_name varchar(255) unique,
    address varchar(255),
    telNo varchar(255) ,
    email varchar(255) ,
    member_role varchar(255) not null,
    category varchar(255) not null,
    useYn varchar(1) default 'Y' not null,
    add_date datetime not null DEFAULT CURRENT_TIMESTAMP,
    up_date datetime on update CURRENT_TIMESTAMP
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*실시간 알람 테이블 clear*/
create table if not exists notice(
 notice_seq int auto_increment primary key,
 member_seq int,
 type_seq int,
 write_type varchar(20) not null,
 user_writer varchar(20) not null,
 writer varchar(20) not null,
 title varchar(100) not null,
 category varchar(20) not null,
 notice_read char(1) default 'N',
 del_Yn char(1) default 'N',
 add_date datetime not null DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


/*리뷰 테이블*/
create table if not exists review(
    review_seq int auto_increment primary key,
    content varchar(4096) not null,
    writer varchar(20) not null,
    star_score float not null,
    pc_seq int null,
    update_seq int null,
    update_Yn char(1) default 'N' not null ,
    del_Yn char(1) default 'N' not null ,
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

/*카테고리에 따른 게시판 테이블 clear*/
create table if not exists board(
    board_seq int auto_increment primary key,
    update_yn char(1) DEFAULT 'N' not null,
    update_seq int,
    title varchar(255) not null,
    writer varchar(10) not null,
    content varchar(4096) not null,
    category varchar(30) not null,
    member_seq int,
    del_yn char(1) DEFAULT 'N' not null,
    board_view int DEFAULT 0,
    add_date datetime not null DEFAULT CURRENT_TIMESTAMP,
    up_date datetime on update CURRENT_TIMESTAMP
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


/*게시판 댓글 clear*/
create table if not exists board_comment(
    bc_seq int auto_increment primary key,
    update_seq int,
    board_seq int,
    writer varchar(10) not null,
    content varchar(4096) not null,
    category varchar(30) not null,
    del_yn char(1) DEFAULT 'N' not null,
    update_yn char(1) DEFAULT 'N' not null,
    add_date datetime DEFAULT CURRENT_TIMESTAMP,
    up_date datetime on update CURRENT_TIMESTAMP
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



create table if not exists board_views(
    view_seq int auto_increment primary key,
    board_seq int,
    add_date datetime DEFAULT CURRENT_TIMESTAMP comment '조회'

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


/*채팅 방 clear*/
create table if not exists chatting_room(
    cr_seq int auto_increment primary key comment 'chatting_matching',
    room_name varchar(300) not null comment '채팅방 이름',
    room_id varchar(100) not null comment '룸 아이디',
    professor_name varchar(25) not null comment '방을 만든 교수의 이름',
    user_writer_name varchar(30) not null comment '요청 보낸 학생의 이름',
    pc_seq int not null,
    add_date datetime DEFAULT CURRENT_TIMESTAMP comment '방 만들어진 시간'
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


/*채팅 로그 clear*/
create table if not exists chatting_log(
    cl_seq int auto_increment primary key comment 'chatting_log',
    sender varchar(100) not null comment '보낸 사람',
    message varchar(300) not null comment '보낸 채팅 기록',
    room_id varchar(300) not null comment '방 id',
    member_seq int not null,
    pc_seq int not null,
    add_date datetime DEFAULT CURRENT_TIMESTAMP comment '보낸 시간'
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*로그인 기록 clear*/
create table if not exists login_log (
    login_seq int auto_increment primary key,
    id varchar(255) not null,
    ip varchar(255),
    login_status char(1) not null,
    login_dttm datetime DEFAULT CURRENT_TIMESTAMP comment '로그인 시간'

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


/*좋아요 싫어요*/

create table if not exists member_like(
    like_seq int auto_increment primary key,
    member_seq int,
    flag int(1)

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*교수의 명세서 clear*/
create table if not exists professor_commission(
    pc_seq int auto_increment primary key,
    update_yn char(1) DEFAULT 'N' not null,
    update_seq int,
    title varchar(2555) not null,
    writer varchar(100) not null,
    content varchar(10000) not null,
    category varchar(255) not null,
    member_seq int,
    del_yn char(1) DEFAULT 'N' not null,
    add_date datetime DEFAULT CURRENT_TIMESTAMP,
    up_date datetime on update CURRENT_TIMESTAMP

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
