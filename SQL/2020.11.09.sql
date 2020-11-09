-- 2020.11.09
-- Select 기본

-- scott 계정으로 로그인
-- scott 계정이 소유한 테이블 객체를 확인 : Tab -> 사용자가 가지는 테이블의 정보를 저장하는 데이터 딕셔너리
select * from Tab;

-- 테이블의 구조 확인 : DESC
-- 테이블의 데이터를 검색하기 전 구조를 확인 할 때
Desc emp;
desc dept;

-- select hiredate from emp;

-- 데이터의 조회 : Select
-- 기본 문법 : SELECT 컬럼명, ... FROM 테이블 이름(조회대상)
-- * SELECT 의 결과는 TABLE이다 *

SELECT      -- 조회 명령어
    *       -- 표현 영역에 컬럼 이름을 기술 --> 기술하는 순서에 따라 결과도 순서에 맞게 출력
FROM emp    -- 조회하고자 하는 테이블 이름을 기술
;           -- sql의 종료

-- 부서 테이블의 모든 데이터를 조회하자
select *
from dept
;

-- 부서 테이블에서 --> FROM
-- 부서의 이름과 위치를 출력 --> SELECT
select dname,loc
from dept
;

-- 원하는 순서대로 결과 출력, 데이터 편집
select loc,dname,deptno,dname
from dept
;

-- 모든 사원의 정보를 출력하자
select *
from emp
;

-- 사원의 이름, 사원번호, 직급(직무)를 포함하는 리스트 출력
select ename,empno,job
from emp
;

-- Select 절의 컬럼의 사칙연산 가능
-- 임시 테이블 dual : 컬럼은 x를 가지는 테이블
select 100+200, 200-100, 100*10, 100/10
from dual
;

select empno,sal,sal*12
from emp
;
-- null : 존재하지만 정해지지 않은 값
-- 연산이 불가 : 사칙연산, 비교연산

-- 연봉의 계산을 sal*12+comm으로 계산하자
select ename, sal, sal*12, comm, sal*12+comm
from emp
;

-- nvl 함수 : null값을 치환해주는 함수
-- nvl(컬럼, 대체값) : 컬럼의 값이 null일 때 대체값으로 치환, 이 때 대체값은 컬럼의 타입에 맞는 타입이어야 한다.
select ename, sal, sal*12 as sal12, nvl(comm,0) as comm, nvl(sal*12+comm,0) as "12개월 연봉"
from emp
;

-- 데이터베이스의 sql 내부의 문자열 처리는 작은따옴표 ''
-- 데이터 처리는 작은따옴표 '', 별칭은 큰따옴표 "" (한글 처리는 AS 생략 불가)
-- 사용은 가능하나 서버에서 한글처리 안되는 경우가 있어 별칭으로 한글 잘 사용하지 않음

-- 문자열의 조합
select ename || '의 직무는 ' || job ||'입니다.'
from emp;

-- Distinct : 데이터의 중복값을 제외하고 출력
select deptno
from emp;

select DISTINCT deptno
from emp;


-- 특정 데이터를 추출하는 Where 절

-- 급여가 3000 이상인 사원의 리스트틀 출력하자
select ename, job, sal  -- 2) 열을 선택해 결과 Table 출력
from emp
where sal>= 3000;       -- 1) 행을 찾고

select ename --, job, sal
from emp
where sal > 4000;


-- 10번 부서에 소속된 사원들의 리스트를 출력
select *
from emp
where deptno=10;

-- 사원이름이 FORD 인 사원의 정보를 출력
select *
from emp
where ename='FORD'; -- Where절은 대소문자 구별 --> 작은따옴표 '' 표현

-- 81/11/17에 입사한 사원의 정보를 출력
select *
from emp
where hiredate='81/11/17'   -- 날짜 비교에서도 날짜를 작은 따옴표로 묶어서 사용
;


-- 10번 부서 소속인 사원들 중에서 직급이 MANAGER인 사람을 검색하여 사원명, 부서번호, 직급을 출력하자
-- [조건 1] 10번 부서 소속인 사원  : DEPNO=10
-- [조건 2] 직급이 MANAGER인 사원 : JOB='MANAGER'
select ename,deptno,job
from emp
where deptno=10 AND job='MANAGER'
;

select ename, deptno, job
from emp
where deptno=10 or job='MANAGER'
;

-- 부서번호가 10번이 아닌 사원의 사원이름, 부서번호, 직급을 출력하자
select *
from emp
--where not deptno = 10
--where deptno != 10
where deptno <> 10
;

select *
from emp
where sal between 2000 and 3000 -- 2000 이상 3000 이하
;

-- 1987년에 입사한 사원을 출력하자
-- 1987/01/01 ~ 1987/12/31
select *
from emp
--where hiredate between '1987/01/01' and '1987/12/31'
where hiredate >= '87/01/01' and hiredate <= '87/12/31'
;

-- IN
-- 커미션이 300이거나 500이거나 1400인 사원을 검색
select *
from emp
--where comm=300 or comm=500 or comm=1400;
where comm IN(300, 500, 1400, 100);

-- LIKE : 검색하고자 하는 값을 정확히 모를 때 와일드카드(%, _)를 사용하여 검색
-- 찾으려는 이름이 A로 시작하는 것은 알지만 그 뒤의 문자는 모를 경우
select *
from emp
--where ename like 'A%'             -- A로 시작하고 뒤에는 어떤 문자가 와도 상관 없다
--where ename like '%S'             -- S로 끝나는 이름 검색
--where ename like '%E%'            -- E를 포함하는 이름 검색
--where ename like '_L%'            -- 두 번째 문자가 L인 이름 검색
--where ename like '__R%'           -- 세 번째 문자가 R인 이름 검색
--where ename like '_______1%'      -- 000000-1000000
--where hiredate like '___04%'      -- '87/04/19'
--where mgr like '_78_'             -- '7788'
--where ename not like '%E%'        -- E를 포함하지 않은 이름 검색
;

-- 커미션을 받지 않은 사원 검색
select *
from emp
--where comm=null     -- NULL 값은 연산 불가
where comm is null or comm=0
;

-- 커미션을 받은 사원 검색
select *
from emp
where comm is not null and comm>0
;

-- ORDER BY : 크기 순서대로 정렬
-- 사원의 리스트를 급여의 오름차순으로 정렬해보자
select *
from emp
--order by sal asc      -- 오름차순(작은 값부터)
--order by sal desc     -- 내림차순(큰 값부터)
--order by sal          -- 생략 시 ASC 오름차순
--order by ename desc
--order by comm desc    -- null은 ASC에 가장 마지막에, DESC에 가장 먼저 (null은 크다고 이해하자)
--order by hiredate     -- 날짜의 작다는 표현은 오래된 날짜 : 오름차순은 오래된 날짜부터 최근 날짜로 정렬
order by hiredate desc, sal asc -- hiredate 내림차순으로 순차적으로 출력하다가 값이 동일할 경우에 sal 오름차순
;
