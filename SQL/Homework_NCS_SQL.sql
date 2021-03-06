-- NCS 평가

-- #1 아래 요구사항에 맞도록 기본 SQL 문을 작성하시오.

-- 1. 아래 조건에 맞는 DDL을 작성하시오.
--===== 전화번호 부( 테이블 이름 : Contact )
------ 기본정보(not null)
-- 대리키 : 일련번호 -> pIdx 기본키로 설정
-- 이름, 전화번호, 주소, 이메일
-- 주소값과 이메일은 입력이 없을 때 기본값 입력
-- 친구의 타입 (카테고리) : univ, com, cafe 세가지 값만 저장 가능
------ 선택 정보
-- 전공, 학년
-- 회사이름, 부서이름, 직급
-- 모임이름, 닉네임
--=============================

create table CONTACT(
    PIDX            number(6)           constraint CONTACT_PIDX_PK primary key,
    FR_NAME         varchar2(20)        not null,
    FR_PHONENUMBER  varchar2(20)        not null,
    FR_EMAIL        varchar2(20)        default 'email@google.com',
    FR_ADDRESS      varchar2(20)        default '대한민국',
    FR_REGDATE      date                default sysdate
);

create table CONTACT_UNIV (
    IDX             number(6),
    FR_U_MAJOR      varchar2(20)        default 'N', 
    FR_U_YEAR       number(1)           default 1       check (FR_U_YEAR between 1 and 4),
    CONTACT_PIDX     number(6)          not null,
    constraint CONTACT_UNIV_IDX_PK      primary key (IDX),
    constraint CONTACT_UNIV_PIDX_FK     not null        foreign key (CONTACT_PIDX) references CONTACT (PIDX)
);

create table CONTACT_COM (
    IDX             number(6)       constraint CONTACT_COM_IDX_PK primary key,
    FR_C_COMPANY    varchar2(20)    default 'N',
    FR_C_DEPT       varchar2(20),
    FR_C_JOB        varchar2(20),
    CONTACT_PIDX    number(6)       not null    constraint CONTACT_COM_PIDX_FK references CONTACT (PIDX)
);

create table CONTACT_CAFE (
    IDX             number(6)       constraint CONTACT_CAFE_IDX_PK primary key,
    FR_CAFENAME     varchar2(20)    default 'N',
    FR_NICKNAME     varchar2(20),
    CONTACT_PIDX    number(6)       not null    constraint CONTACT_CAFE_PIDX_FK references CONTACT (PIDX)    
);

-- 2. DEPT 테이블에 데이터를 삽입하는 SQL을 작성하시오. 입력 데이터는 임의로 작성하시오.

insert into DEPT (deptno, dname, loc) values ('50','DEV','역삼');

-- 3. DEPT 테이블에 위에서 삽입한 데이터의 dname, loc 데이터를 변경하는 SQL을 작성하시오. 입력 데이터는 임의로 작성하시오.

update DEPT set dname='DESIGN', loc='서초' where deptno=50;

-- 4. DEPT 테이블에 위에서 삽입한 데이터를 deptno 컬럼의 값을 기반으로 삭제하는 SQL을 작성하시오.

delete from dept where deptno=50;

-- 5. 사용자가 보유한 테이블 목록을 확인하는 SQL문을 작성하시오.

select * from USER_TABLES;

-- 6. EMP 테이블의 구조를 확인하는 SQL을 작성하시오.

desc EMP;

-- 7. 사용자가 정의한 제약조건들을 확인하는 SQL문을 작성하시오.

select * from USER_CONSTRAINTS;



-- #2 아래 요구사항에 맞도록 고급 SQL 문을 작성하시오.

-- 1. EMP 테이블의 ename 컬럼에 인덱스를 생성하는 SQL을 작성하시오. 인덱스의 이름은 emp_index

create index EMP_ENAME_INDEX on EMP(ENAME);

-- 2. EMP 테이블과 DEPT 테이블을 조인하는 SQL을 기반으로 view 객체를 생성하는 SQL을 작성하시오. view 의 이름은 emp_view 로 하시오.

select * from emp inner join dept using (deptno);

create or replace view EMP_VIEW as
select  deptno, empno, ename, job, mgr, hiredate, sal, comm, dname, loc
        from emp inner join dept
        using (deptno);

-- 3. EMP 테이블에서 모든 사원의 부서번호를 이름이 'SCOTT'인 사원의 부서번호로 변경하는 SQL을 작성하시오.

update EMP set DEPTNO= (select DEPTNO from EMP where ENAME='SCOTT');