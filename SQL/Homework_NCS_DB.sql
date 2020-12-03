-- NCS 평가
-- 데이터베이스구현_문제해결시나리오_제출용

-- #2 요구사항에 맞는 오브젝트를 생성하는 sql을 작성하시오.

-- 1. 대리키 IDX, 회원 아이디, 이름, 비밀번호, 사진이름, 가입일 을 저장할 수 있는 이름이 MEMBER인 테이블을 생성하세요.
--    회원 아이디에는 기본 키 제약설정을 하고, 이름과 비밀번호에는 not null, 가입 일은 기본 값으로 sysdate가 입력되도록 하시오.

create table MEMBER(
    IDX int unique not null,
    ID varchar2(10) constraint MEM_ID_PK primary key,
    NAME varchar2(10) not null,
    PASSWORD varchar2(20) not null,
    IMAGENAME varchar2(20),
    REGDATE date default sysdate
);

drop table MEMBER;

-- 2. MEMBER 테이블에서 이름 컬럼으로 인덱스 객체를 생성하시오.

create index MEMBER_NAME_I on MEMBER (NAME);


-- 3. MEMBER 테이블에서 회원 아이디, 이름, 사진 정보만을 출력하는 view 객체를 생성하시오. view의 이름은 member_view 로 생성하시오.

create or replace view MEMBER_VIEW
as 
select ID, NAME, IMAGENAME
from MEMBER;

select * from dba_users;
grant create view to scott;

conn system/oracle as sysdba;

select username, account_status, lock_date from dba_users;