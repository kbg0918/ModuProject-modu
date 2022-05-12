/*유저 테이블*/
create table if not exists user(
    seq int auto_increment primary key,
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


/*리뷰 테이블*/
create table if not exists user_comment(
    uc_seq int auto_increment primary key,
    content varchar(255) not null,
    writer varchar(255) not null,
    user_like int(100),
    user_unlike int(100),
    star_score int(5) not null,
    user_seq int(100) not null,
    add_date datetime DEFAULT null,
    up_date datetime DEFAULT null
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/* 프로필 테이블*/
create table if not exists user_profile(
    profile_seq int auto_increment primary key,
    imgUrl varchar(255),
    user_rank int(100),
    user_comment varchar(255) not null,
    add_date datetime DEFAULT null,
    up_date datetime DEFAULT null
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

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

/*카테고리에 따른 게시판 테이블 */
create table if not exists board(
    board_seq int auto_increment primary key,
    category varchar(255) not null,
    writer varchar(255) not null,
    content varchar(255) not null,
    user_role varchar(255) not null,
    user_like int(100),
    user_unlike int(100),
    user_seq int(100) not null,
    add_date datetime DEFAULT null,
    up_date datetime DEFAULT null
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


/*게시판 댓글*/
create table if not exists board_comment(
    bc_seq int auto_increment primary key,
    writer varchar(255) not null,
    content varchar(255) not null,
    user_like int(100),
    user_unlike int(100),
    user_seq int(100) not null,
    user_rank int(100),
    add_date datetime DEFAULT null,
    up_date datetime DEFAULT null
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
alter table user_comment add up_date datetime DEFAULT null;


create table if not exists board_views(
    view_seq int auto_increment primary key,
    board_seq int(100),
    add_date datetime DEFAULT null comment '조회'

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;









