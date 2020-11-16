-- 2020.11.16

-- PhoneBook DDL : 테이블 정의서를 참고해서 DDL SQL문을 작성하자. 

drop table PHONEINFO_BASIC;

-- CREATE
create table PHONEINFO_BASIC ( 
    IDX number(6) constraint PI_BASIC_IDX_PK primary key,
    FR_NAME varchar2(20) not null,
    FR_PHONENUMBER varchar2(20) not null,
    FR_EMAIL varchar2(20),
    FR_ADDRESS varchar2(20),
    FR_REGDATE date default sysdate
);

desc PHONEINFO_BASIC;

-- 제약 조건 확인 user_constraints 
desc user_constraints;

select constraint_name, constraint_type
from user_constraints
where table_name='PHONEINFO_BASIC' -- 메타데이터 안에는 모두 대문자로 들어있으니 주의!
;

-- 시퀀스 : 숫자 재생기
-- 시퀀스 특징 : 이전 Data로 돌아가지 않는다. 가장 최근 숫자에서 숫자 재생한다.
-- drop sequence SEQ_PIBASIC_IDX;
create sequence SEQ_PIBASIC_IDX
minvalue 0
start with 0
increment by 1
;


-- 질의 : READ
SELECT * FROM phoneinfo_basic;

-- INSERT : CREATE
insert into PHONEINFO_BASIC
VALUES (1, 'SCOTT', '010-0000-0000', 'SCOTT@GMAIL.COM', '서울', sysdate);

insert into PHONEINFO_BASIC
values (SEQ_PIBASIC_IDX.nextval, 'SCOTT', '010-0000-0000', 'SCOTT@GMAIL.COM', '서울', sysdate);

insert into PHONEINFO_BASIC (IDX, fr_name, fr_phonenumber)
values (SEQ_PIBASIC_IDX.nextval, 'KING', '010-9999-9999');

-- 데이터 삭제 : DELETE
delete from PHONEINFO_BASIC;

-- 데이터 업데이트 : UPDATE
update PHONEINFO_BASIC
set FR_EMAIL='KING@NAVER.COM', FR_ADDRESS='부산'
where IDX=9
;

-- C(CREATE), R(READ), U(UPDATE), D(DELETE) 
--> INSERT, SELECT, UPDATE, DELETE

-- PHONEINFO_BASIC의 IDX를 외래키로 참조하는 이유? 
-- UNIV 와 COM은 둘 중 하나는 null 값이 들어가야 한다. 



-- PHONEINFO_UNIV
drop table PHONEINFO_UNIV;

create table PHONEINFO_UNIV (
    IDX number(6),
    FR_U_MAJOR varchar2(20) default 'N', 
    FR_U_YEAR number(1) default 1 check (FR_U_YEAR between 1 and 4),
    FR_REF number(6) not null,
    constraint PI_UNIV_IDX_PK primary key (IDX),
    constraint PI_UNIV_REF_FK foreign key (FR_REF) references PHONEINFO_BASIC (IDX)
);

desc PHONEINFO_UNIV;
select * from user_constraints where table_name='PHONEINFO_UNIV';

-- CRUD
-- create : 대학친구 입력
-- 기본 정보
insert into PHONEINFO_BASIC (IDX, FR_NAME, FR_PHONENUMBER) 
values (SEQ_PIBASIC_IDX.nextval, 'KING', '010-9999-9999');
-- 대학 정보
insert into PHONEINFO_UNIV values (3, '컴퓨터공학', 2, SEQ_PIBASIC_IDX.currval);

-- read
select * from PHONEINFO_BASIC;
select * from PHONEINFO_UNIV;

select *
from PHONEINFO_BASIC pb, PHONEINFO_UNIV pu
where pb.IDX=pu.FR_REF
;

-- update 
update PHONEINFO_UNIV
set FR_U_MAJOR ='체육', FR_U_YEAR=4
where IDX=3;

-- delete : IDX=10인 행을 삭제 -> 외래키부터 삭제해야 함. 
-- 트랜젝션. UNIV 삭제 후 BASIC 삭제 (UNIV부터 삭제되어야 함)
delete PHONEINFO_UNIV where FR_REF=11;
delete PHONEINFO_BASIC where IDX=3;



-- PHONEINFO_COM
drop table PHONEINFO_COM;

create table PHONEINFO_COM (
    IDX number(6) constraint PI_COM_IDX_PK primary key,
    FR_C_COMPANY varchar2(20) default 'N',
    FR_REF number(6) constraint PI_COM_REF_FK REFERENCES PHONEINFO_BASIC (IDX)
);

-- 회사 친구 정보 입력
-- 기본 정보
insert into PHONEINFO_BASIC (IDX, FR_NAME, FR_PHONENUMBER)
VALUES (SEQ_PIBASIC_IDX.nextval, '손흥민', '010-1111-1111');

-- 회사 정보 
insert into PHONEINFO_COM values (1, '토트넘', SEQ_PIBASIC_IDX.currval);

-- Read
-- 회사 친구
select *
from PHONEINFO_BASIC pb, PHONEINFO_COM pc
where pb.IDX=pc.FR_REF
and pb.FR_NAME='손흥민'
;

-- update
update PHONEINFO_COM
set FR_C_COMPANY='레알'
where IDX=1;

-- delete
-- 자식테이블의 행부터 삭제하고 부모테이블 행을 삭제
delete from PHONEINFO_COM where FR_REF=13;
delete from PHONEINFO_BASIC where IDX=1;
