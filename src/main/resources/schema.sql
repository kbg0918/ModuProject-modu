/*유저 테이블*/
create table if not exists user(
    user_seq int auto_increment primary key,
    user_id varchar(255) unique,
    user_password varchar(255) not null,
    user_name varchar(255) not null,
    user_address varchar(255),
    user_telno varchar(255) ,
    user_email varchar(255) ,
    user_role varchar(255) not null,
    category varchar(255) not null,
    add_date datetime DEFAULT null,
    up_date datetime DEFAULT null
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table user;
/*리뷰 테이블*/
create table if not exists user_comment(
    uc_seq int auto_increment primary key,
    content varchar(255) not null,
    writer varchar(255) not null,
    user_like int,
    user_unlike int,
    star_score int not null,
    user_seq int not null,
    add_date datetime DEFAULT null,
    up_date datetime DEFAULT null
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table user_comment;

/* 프로필 테이블*/
create table if not exists user_profile(
    profile_seq int auto_increment primary key,
    imgUrl varchar(255),
    user_rank int,
    user_comment varchar(255) not null,
    add_date datetime DEFAULT null,
    up_date datetime DEFAULT null
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table user_profile;
/*포트폴리오 테이블 role 조건 */
create table if not exists user_portfolio(
    portfolio_seq int auto_increment primary key,
    user_name varchar(255) not null,
    certificate varchar(255) not null,
    user_role varchar(255) not null,
    imgUrl varchar(255),
    add_date datetime DEFAULT null,
    up_date datetime DEFAULT null
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table user_portfolio;
/*카테고리에 따른 게시판 테이블 */
create table if not exists board(
    board_seq int auto_increment primary key,
    category varchar(255) not null,
    writer varchar(255) not null,
    content varchar(255) not null,
    user_role varchar(255) not null,
    user_like int,
    user_unlike int,
    user_seq int not null,
    add_date datetime DEFAULT null,
    up_date datetime DEFAULT null
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table board;

/*게시판 댓글*/
create table if not exists board_comment(
    bc_seq int auto_increment primary key,
    writer varchar(255) not null,
    content varchar(255) not null,
    user_like int,
    user_unlike int,
    user_seq int not null,
    user_rank int,
    add_date datetime DEFAULT null,
    up_date datetime DEFAULT null
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


drop table board_comment;

create table if not exists board_views(
    view_seq int auto_increment primary key,
    board_seq int,
    add_date datetime DEFAULT null comment '조회'

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table board_views;
/*유저 채팅*/
create table if not exists chatting_matching(
    cm_seq int auto_increment primary key comment 'chatting_matching',
    send varchar(300) not null comment '보내는 채팅',
    receive varchar(300) not null comment '받는 채팅',
    user_role varchar(255) not null,
    add_date datetime DEFAULT null comment '보낸 시간'
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table chatting_matching;
/*채팅 기록*/
create table if not exists chatting_log(
    cl_seq int auto_increment primary key comment 'chatting_log',
    send varchar(300) not null comment '보낸 채팅 기록',
    receive varchar(300) not null comment '받은 채팅 기록',
    user_role varchar(255) not null,
    add_date datetime DEFAULT null comment '보낸 시간'
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


/*로그인 기록*/
create table if not exists login_log (
    login_seq int auto_increment primary key,
    user_id varchar(255) not null,
    user_ip varchar(255),
    user_role varchar(255) not null,
    login_status char(1) not null,
    add_date datetime DEFAULT null comment '로그인 시간'

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

delete from user
where user_id= 'k12';

select user_name from board b join user u on b.user_seq=u.user_seq where user_name = 'aa';
select u.category from board b join user u on b.user_seq=u.user_seq where b.user_seq = 1;
