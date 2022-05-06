create table if not exists member (
    seq int auto_increment primary key,
    id varchar(255) unique ,
    name varchar(255) not null,
    password varchar(255) not null,
    role varchar(255) not null,
    address varchar(255),
    telno varchar(255) ,
    email varchar(255) ,
    logDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );