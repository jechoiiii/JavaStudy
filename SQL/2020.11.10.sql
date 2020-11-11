-- 2020.11.10
-- 함수

-- 단일행, 집합함수

-- 단일행 함수 : 숫자, 문자, 날짜, 변환

desc dual;

-- 숫자 함수

select ABS(-15.5) from dual; -- 15.5        (ABS : 절대값)
select FLOOR(15.7) from dual; -- 15         (FLOOR : 소수점 버림)
select ROUND(15.193) from dual; -- 15	    (Round : 반올림)
select ROUND(15.693,2) from dual; -- 15.69  (Round(m,n) : m을 소수점 n번째 자리까지 반올림)
select LOG(10,100) from dual; -- 2          (LOG(m,n) : 밑을 m으로 한 n의 로그값 반환)
select POWER(3,2) from dual; -- 9           (POWER(m,n) : m^n 반환)
 

-- 문자 함수
select concat('나는', '손흥민 입니다.') from dual; -- 나는손흥민 입니다. (CONCAT : 문자의 값 연결)
select concat('제 이름은 ',ename) from emp; -- 제 이름은 SMITH
select LOWER('MR SCOTT') "Lowercase" from DUAL; -- mr scott       (LOWER : 소문자로 변환)
select lower(ename) from emp; 
select LPAD('Page 1',15,'*')from dual; -- *********Page 1         (LPAD : 입력 받은 문자열과 기호를 정렬해 특정 길이의 문자열로 반환)
select RPAD('001212-1',15,'*')from dual; -- Page 1*********
select substr('001212-3001247',1,8)from dual; -- 001212-3 -- 1자리부터 8자리, 
select substr('001212-3001247',5,2)from dual; -- 12 -- 5번째 자리부터 2자리
select RPAD(substr('001212-3001247',1,8),14,'*') from dual; -- 001212-3******

-- MOD(m,n) : m을 n 으로 나누었을 때 나머지를 반환

select trim() from dual;
select Ltrim('    =from=', '') from dual; --    =from=
select Rtrim('    = from=====    ', '' from dual; --   = from=====.
select trim('=' from '     ====From====') as "from" from dual; --       FROM

select REPLACE('JACK and JUE','J','BL') from dual; -- BLACK and BLUE
select REPLACE('000000-000000','-','') from dual; -- 000000000000(주민번호 - 빼기) 


-- 날짜 함수

select sysdate+14 from dual;
select sysdate+21 from dual;
select sysdate from dual;

select add_months(sysdate, -4) from dual; -- 20/07/10
select last_day(sysdate) from dual;



-- 변환 함수
-- TO_CHAR : 날짜 -> 문자, 숫자 -> 문자

-- 날짜 -> 문자
select sysdate, to_char(sysdate, 'YYYY.MM.DD day dy') from dual; -- 20/11/10 2020.11.10 화요일 화 
select sysdate, to_char(sysdate, 'YYYY.MM.DD day dy AM PH HH HH24') from dual;

-- 숫자 -> 문자
select to_char(100000, '000,000') from dual; -- 100,000
select to_char(100000.123, '000,000.00') from dual; -- 100,000.12
select to_char(1000000, '000,000') from dual; -- ####### (십만 이상은 표현할 수 없음)

select sal from emp; -- 숫자만
select sal, to_char(sal*1100, 'L00,000,000') from emp; -- 1600 (원화표시)1,760,000
select ename, job, sal, to_char(sal*1100*12+nvl(comm,0)*1100, 'L00,000,000') from emp order by sal desc; -- 사원 월급여 내림차순

-- 문자 -> 날짜
-- 2020.11.01
select TO_DATE('2009/09/05','YYYY/MM/DD') from dual;
select TO_DATE('2020/11/01','YYYY.MM.DD') from dual; -- 20/11/01

-- 오늘이 2020년 1월 1일에서 몇일이 지났는지 확인
select trunc(sysdate - to_date('20-01-01', 'YY-MM-DD')) from dual; -- 314

-- 내가 몇일을 살았는지 확인
select trunc(sysdate - to_date('12-05-07', 'YY-MM-DD')) from dual; -- 3099

-- 문자 -> 숫자
select TO_NUMBER('100.00','999.99') from dual; -- 100
select TO_NUMBER('100.00','999.99')-TO_NUMBER('10.00','999.99') from dual; -- 90
select TO_NUMBER('100.00','999.99')*TO_NUMBER('10.00','999.99') from dual; -- 1000



-- DECODE 함수 : switch 문과 비슷하다
-- 사원이름, 부서번호, 부서이름 출력
select ename, deptno,
   decode( deptno, 
       10, 'ACCOUNTING', -- DEPTNO=10 이면 출력하자 
       20, 'RESEARCH',   -- DEPTNO=20 이면
       30, 'SALES',      -- DEPTNO=30 이면
       40, 'OPERATIONS'  -- DEPTNO=40 이면
   ) AS dname
from emp order by deptno
;

-- 직급에 따라 급여를 인상하도록 하자.
   직급이 'ANALYST'인 사원은 5%
        'SALESMAN'인 사원은 10%
        'MANAGER'인 사원은 15%
        'CLERK'인 사원은 20% 인상한다.
       
select ename, sal,
	decode( job,
    	'ANALYST', sal*1.05
        'SALESMAN', sal*1.1
        'MANAGER', sal*1.15
        'CLERK', sal*1.20
    ) as upsal
from emp
order by sal
;
select distinct job from emp;
  
  
 -- CASE 문 
 select emp.ename as name, deptno, 
 	case
 		when deptno=10 then 'ACCOUNTING'
    	when deptno=20 then 'RESEARCH'
    	when deptno=30 then 'SALES'
    	when deptno=50 then 'OPERATIONS'
  	end as dname -- 컬럼의 이름 별칭 붙임
from emp
--order by dname
;
-- 변환 함수
-- TO_CHAR : 날짜 -> 문자, 숫자 -> 문자

-- 날짜 -> 문자
select sysdate, to_char(sysdate, 'YYYY.MM.DD day dy') from dual; -- 20/11/10 2020.11.10 화요일 화 
select sysdate, to_char(sysdate, 'YYYY.MM.DD day dy AM PH HH HH24') from dual;

-- 숫자 -> 문자
select to_char(100000, '000,000') from dual; -- 100,000
select to_char(100000.123, '000,000.00') from dual; -- 100,000.12
select to_char(1000000, '000,000') from dual; -- ####### (십만 이상은 표현할 수 없음)

select sal from emp; -- 숫자만
select sal, to_char(sal*1100, 'L00,000,000') from emp; -- 1600 (원화표시)1,760,000
select ename, job, sal, to_char(sal*1100*12+nvl(comm,0)*1100, 'L00,000,000') from emp order by sal desc; -- 사원 월급여 내림차순

-- 문자 -> 날짜
-- 2020.11.01
select TO_DATE('2009/09/05','YYYY/MM/DD') from dual;
select TO_DATE('2020/11/01','YYYY.MM.DD') from dual; -- 20/11/01

-- 오늘이 2020년 1월 1일에서 몇일이 지났는지 확인
select trunc(sysdate - to_date('20-01-01', 'YY-MM-DD')) from dual; -- 314

-- 내가 몇일을 살았는지 확인
select trunc(sysdate - to_date('12-05-07', 'YY-MM-DD')) from dual; -- 3099


-- 문자 -> 숫자
select TO_NUMBER('100.00','999.99') from dual; -- 100
select TO_NUMBER('100.00','999.99')-TO_NUMBER('10.00','999.99') from dual; -- 90
select TO_NUMBER('100.00','999.99')*TO_NUMBER('10.00','999.99') from dual; -- 1000


-- DECODE 함수 : switch 문과 비슷하다
-- 사원이름, 부서번호, 부서이름 출력
select ename, deptno,
   decode( deptno, 
       10, 'ACCOUNTING', -- DEPTNO=10 이면 출력하자 
       20, 'RESEARCH',   -- DEPTNO=20 이면
       30, 'SALES',      -- DEPTNO=30 이면
       40, 'OPERATIONS'  -- DEPTNO=40 이면
   ) AS dname
from emp order by deptno
;

-- 직급에 따라 급여를 인상하도록 하자.
   직급이 'ANALYST'인 사원은 5%
        'SALESMAN'인 사원은 10%
        'MANAGER'인 사원은 15%
        'CLERK'인 사원은 20% 인상한다.
       
select enmae, sal,
	decode( job,
    	'ANALYST', sal*1.05
        'SALESMAN', sal*1.1
        'MANAGER', sal*1.15
        'CLERK', sal*1.20
    ) as upsal
from emp
order by sal
;
select distinct job from emp;
  
  
 -- CASE 문 
 select emp.ename as name, deptno, 
 	case
 		when deptno=10 then 'ACCOUNTING'
    	when deptno=20 then 'RESEARCH'
    	when deptno=30 then 'SALES'
    	when deptno=50 then 'OPERATIONS'
  	end as dname -- 컬럼의 이름 별칭 붙임
from emp
--order by dname
;


----------------------------------------------------------------------------


-- 그룹 함수

-- SUM 함수 : : 해당 칼럼 값들에 대한 총합을 구하는 함수
SELECT SUM(SAL) 
FROM EMP;

-- 특징 : null 값은 제외하고 연산한다.
select comm from emp;-- SUM 함수
SELECT SUM(SAL) 
FROM EMP;


-- AVG 함수 : : 해당 칼럼 값들에 대해 평균을 구하는 함수
SELECT AVG(SAL) FROM EMP;

-- 그룹 함수 : 하나의 행의 컬럼을 대상이 아닌 행의 그룹의 컬럼들을 묶어 그룹화하고 연산하는 함수
-- 그룹함수 : SUM, AVG, COUNT, MAX, MIN

select
	to_char(sum(sal)*1100, 'L999,999,999') as "월 급여 총액",
    round(avg(sal))*1100 as "월급여 평균",
    count(sal) as "전체 사원의 수",
	count(comm) as "커미션을 받는 사원의 수", -- 4 (null은 세지 않음)
	max(sal) as "가장 큰 급여 금액",
    min(sal) as "가장 작은 급여 금액"
from emp
;

select
	sum(comm),
    avg(nvl(comm,0)),   -- 전체대상의 평균 - nvl함수는 null값 0으로 치환
    count(nvl(comm,0)), -- 전체대상으로 카운트
    max(comm),
    min(comm)
from emp
;

-- 전체 행을 구한다
select 
	count(*) as "전체 MANAGER의 수",
    avg(sal) as "매니저의 평균 급여",
    max(sal),
    min(sal)
from emp
where job='MANAGER'
;

-- 직무의 개수
select count(distinct job)
from emp
order by job
;



-- GRUOP BY : 그룹핑 함수
-- 각 부서의 소속 인원을 구하자
select deptno, count(*) as 'cnt'
from emp 
group by deptno
--order by count(*) desc
order by deptno
;

-- 각 부서별 총 급여액 출력
-- group by deptno : 부서별로 그룹핑
select deptno, sum(sal)
from emp
group by deptno
order by deptno
;

-- 부서별 급여 평균
select deptno, round(avg(sal))
from emp
group by deptno
order by deptno
;

-- 부서별 급여 최고 금액과 최소 금액을 출력
select deptno, max(sal), min(sal)
from emp
group by deptno
order by deptno
;

-- 부서별로 그룹지은 후 (group by),
-- 그룹지어진 부서별 평균 급여가 2000 이상인 (having)
-- 부서 번호와 부서별 평균 급여 출력
select deptno, avg(sal)
from emp
group by deptno
--having avg(sal)>=2000
having not avg(sal)<2000
order by deptno
;

-- 부서별 급여의 최대값과 최소값을 구하되 최대 급여가 2900 이상인 부서만 출력
select deptno, max(sal), min(sal)
from emp
group by deptno
having max(sal)>=2900
order by deptno
;

-- 직무별 지표 : 사원의 수, 급여의 총합, 평균 급여, 최대 급여, 최소 급여
select job, 
    count(*) || ' 명' as "사원의 수", 
    --??concat(count(*) '명') as "사원의 수",
    --sum(sal) as "급여의 총합",
    to_char(sum(sal)*1100, 'L999,999,999') as "급여의 총합",
    --avg(sal) as "평균 급여",
    to_char(avg(sal)*1100, 'L999,999,999') as "평균 급여",
    to_char(max(sal), 'L999,999,999') as "최대 급여",
    to_char(min(sal), 'L999,999,999') as "최소 급여"
from emp
where job!='PRESIDENT' -- WHERE 절 : 그룹하기 전에, 그룹하기 위한 행을 선택하는 기준
group by job
order by job
;


select * from tab;
desc book;




