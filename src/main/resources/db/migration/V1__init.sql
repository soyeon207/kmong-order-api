-- 회원 테이블
create table members
(
    id                bigint auto_increment comment 'PK',
    user_role         varchar(10)  null comment '권한',
    email             varchar(255) not null comment '회원별 고유 이메일 주소',
    password          varchar(255) not null comment '비밀번호',
    name              varchar(255) null comment '회원이름',
    phone             varchar(255) null comment '전화번호',
    created_date_time datetime     not null,
    updated_date_time datetime     not null,
    constraint members_pk primary key (id)
);
create unique index members_email_uindex on members (email);

-- 상품 테이블
create table products
(
    id                bigint auto_increment comment 'PK',
    name              varchar(255) not null comment '상품이름',
    price             int          not null comment '상품가격',
    status            varchar(10)  null comment '상태',
    created_date_time datetime     not null,
    updated_date_time datetime     not null,
    constraint products_pk primary key (id)
);

-- 주문 테이블
create table orders
(
    id                bigint      null comment 'PK',
    member_id         bigint      not null,
    product_id        bigint      not null,
    status            varchar(10) null,
    created_date_time datetime    not null,
    updated_date_time datetime    not null,
    constraint orders_products_id_fk foreign key (product_id) references products (id),
    constraint orders_members_id_fk foreign key (member_id) references members (id)
);





