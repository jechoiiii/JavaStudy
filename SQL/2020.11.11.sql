-- 2020.11.11

-- JOIN

-- CROSS JOIN : 조건 없이 테이블과 테이블을 붙여준다 (컬럼 단위로)
select *
from emp, dept;

-- ANSI JOIN --> CROSS JOIN : 어떤 SQL에서든 동일하게 사용이 가능
select *
from emp cross join dept
;

-- Equi JOIN
select *
from emp, dept
where emp.deptno = dept.deptno -- 외래키 = PK
;

-- SCOTT의 사원번호와 이름, 부서이름, 지역을 출력하자
select empno, ename, emp.deptno, dept.deptno, dname, loc 
from emp, dept
where emp.deptno = dept.deptno and ename = 'SCOTT'
;

-- 컬럼명의 모호성 : 동일한 이름을 가진 칼럼은 소속 테이블 생략 불가 (00918. 00000 -  "column ambiguously defined")
select empno, ename, e.deptno, d.deptno 
from emp e, dept d
where e.deptno = d.deptno and ename = 'SCOTT'
;

-- 테이블에 별칭 부여 : 해당 select문에서만 사용 가능
select empno, ename, e.deptno, d.deptno, dname, loc 
from emp e, dept d
where e.deptno = d.deptno and ename = 'SCOTT'
;

-- ANSI INNER JOIN
--> T1 INNER JOIN T2 ON 조인의 조건
--> T1 INNER JOIN T2 USING (공통 칼럼) : 공통 컬럼은 하나만 가지게 해, 구별할 필요 없다.

select *
from emp INNER JOIN dept
-- ON emp.deptno=dept.deptno
USING (deptno)
;

--> T1 NATURAL JOIN T2 : 동일 컬럼 조건의 조건을 생략, 같은 이름의 컬럼은 하나씩
select ename, deptno, dname
from emp NATURAL JOIN dept
;

-- Non Equi JOIN : 동등 비교가 아닌 비교연산이 가능
-- 급여 등급을 5개로 나누어 놓은 salgrade에서 정보를 얻어 와서 각 사원의 급여 등급을 지정해보도록 하자.
-- 이를 위해 사원(emp) 테이블과 급여 등급(salgrade) 테이블을 조인하여 사원의 급여가 몇 등급인지 살펴보자

-- 1. salgrade 테이블 확인하기
select * from salgrade;

-- 2. CROSS JOIN -> 조건 주기
select *
from emp e, salgrade s
where e.sal BETWEEN s.losal AND s.hisal
;

-- Self JOIN : 자신의 테이블을 조인
-- SMITH의 매니저 이름을 알아보자

select ename, mgrfrom emp where ename = 'SMITH';
select ename from emp where empno=7902;

select e.ename, e.mgr, m.ename
from emp e, emp m
where e.mgr=m.empno
and e.ename='SMITH'
;

-- Outer JOIN : (+) 기호는 출력하지 못하는 쪽에 위치
select e.ename, e.mgr, m.ename
from emp e, emp m
where e.mgr=m.empno(+) -- mgr가 없어 null 값을 가진 PRESIDENT도 출력
;

-- ANSI Outer JOIN
-- T1 [LEFT | RIGHT | FULL] OUTER JOIN T2 : 출력하고 싶은 테이블 위치 쪽으로
select *
from emp e RIGHT OUTER JOIN emp m
on e.mgr=m.empno
;

select *
from emp e LEFT OUTER JOIN emp m
on e.mgr=m.empno
;

-- 회원, 구매
-- customer, orders
select * from customer;
select * from orders order by custid;

select * 
from customer c, orders o
where c.custid=o.custid(+)
;

-- 회원별 구매 횟수
select c.name, count(o.orderid), sum(o.saleprice), avg(o.saleprice)
from customer c, orders o
where c.custid=o.custid(+)
group by c.name
;


-- =====================================================================================

-- 서브 쿼리

-- 스칼라 부속질의 - SELECT 부속질의, 단일 행 단일 열
-- 인라인 뷰      - FROM 부속질의, 복합 행 복합 열
-- 중첩질의       - WHERE 부속질의, 단일 열, 단순비교 -> 단일 행, 집합 비교 -> 복합 행

-- 중첩 질의 : 단순 비교

-- 평균 급여(sub query)보다 더 많은 급여를 받는 사원을 출력
select avg(sal) from emp; -- 2073.214285714285714285714285714285714286

select *
from emp
-- where sal > 2073.214285714285714285714285714285714286 -- 평균 급여
where sal > (select avg(sal) from emp) -- 평균 급여 (suq query)
;


-- SCOTT 사원의 같은 부서에 근무하는 사원의 리스트를 출력하라
select deptno from emp where ename='SCOTT'; -- SCOTT이 소속된 부서 번호

select ename
from emp
where deptno = (select deptno from emp where ename='SCOTT') -- SCOTT이 소속된 부서 번호 (sub query)
;


-- 다중 행 서브 쿼리
-- sal 3000 이상 받는 사원이 소속된 부서
select deptno from emp where sal >= 3000;

select *
from emp
--where deptno=10 or deptno=20
where deptno IN (select deptno from emp where sal >= 3000) 
;


-- 30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사람의 이름, 급여를 출력하는 쿼리문을 작성하자

select max(sal) from emp where deptno=30;
select sal from emp where deptno=30;

select ename, sal
from emp
--where sal > 2850
--where sal > (select max(sal) from emp where deptno=30)
--where sal > ALL(select sal from emp where deptno=30)  -- ALL : 모두 만족하면 출력
where sal > ANY(select sal from emp where deptno=30)    -- ANY : 하나라도 만족하면 출력
;



-- ROWNUM : insert된 순서
select rownum, empno, ename, hiredate
from emp
where rownum < 4
order by hiredate
;

select rownum, empno, ename, hiredate from emp order by hiredate;

select rownum, empno, ename, hiredate
from (select rownum, empno, ename, hiredate from emp order by hiredate) -- 인라인 뷰 (가상 테이블?)
where rownum<4
;

-- 가장 급여를 많이 받는 사원 5명을 출력하자
select rownum, ename, sal from emp order by sal desc;

select rownum, ename, sal
from (select rownum, ename, sal from emp order by sal desc)
where rownum<6
;


-- mysql --> top        select * from emp limit 0,3

select name from customer where custid=1;

select custid
from orders
;


-- 스칼라 부속질의 : select 절 프리젠테이션 영역에 쓸 수 있는 부속질의, 단일행, 단일열, 단일값의 결과만 나와야 한다.

select custid, (select name from customer where customer.custid=orders,custid))
        saleprice, orderdate
from orders
;

-- 마당서점의 고객별 group by 판매액을 보이라. orders (결과는 고객이름과 고객별 판매액을 출력)
-- 흐름 만들고, 필요한 거 뽑고, 앞에 이용해서 출력 (??다시 듣기)
select c.custid, c.name, sum(o.saleprice)
from customer c, orders o
where c.custid = o.custid(+)
group by c.custid, c.name -- "ORA-00979: GROUP BY 표현식이 아닙니다."
order by sum(o.saleprice)
;

select o.custid, sum(o.saleprice)
from orders o
group by o.custid 
;

select o.custid, (
        select name from customer c where o.custid=c.custid
        )  
        ,  sum(o.saleprice)
from orders o
group by o.custid
;


-- 인라인 뷰 : FROM 절 이후에 들어가는 서브 쿼리, 가상 테이블, rownum 이 새롭게 생성된다.

-- 고객번호가 2 이하인 고객의 판매액을 보여라 (결과는 고객이름, 고객별 판매액과 평균 판매액 출력)
select custid, name
from customer
where custid<=2
;

select c.name, sum(o.saleprice), avg(o.saleprice)
from orders o, (
        select custid, name
        from customer
        where custid<=2) c
where o.custid=c.custid
group by c.name
;


-- 중첩질의 : WHERE 절 이후에 들어가는 서브 쿼리

-- 비교연산 -> 반드시 단일 행, 단일 열을 반환, 아닐 경우 질의 처리 불가
-- 평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오
select avg(saleprice) from orders;

select orderid, saleprice
from orders
--where saleprice <= 11800
where saleprice <= (select avg(saleprice) from orders) -- 평균 주문 금액
;

-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 보이시오.
select avg(saleprice) from orders where custid=1;

select orderid, custid, saleprice
from orders o1      -- o1과 o2는 상관관계
where saleprice > 
(select avg(saleprice) from orders o2 where o2.custid=o1.custid) -- custid=1이면 1번 고객의 평균과 비교해서 큰 주문 금액만 출력
;

-- IN, NOT IN --> 반드시 다중 행, 단일 열을 반환
-- 대한민국에 거주하는 고객에게 판매한 도서의 총판매액을 구하시오
select * from customer where address like '%대한민국%';

select sum(saleprice)
from orders
-- where custid IN(select * from customer where address like '%대한민국%') -- 다중 열 출력 불가
where custid IN (select custid from customer where address like '%대한민국%') 
;

-- ALL, SOME(ANY) --> 반드시 다중 행, 단일 열을 반환
-- 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 주문번호와 금액을 보이시오
select max(saleprice) from orders where custid=3;

select orderid, saleprice
from orders
--where saleprice > (select max(saleprice) from orders where custid=3)
where saleprice > ALL (select saleprice from orders where custid=3)
;

-- EXISTS, NOT EXISTS : 데이터의 존재 유무를 확인
-- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
select * from customer where address like '%대한민국%';

select sum(saleprice)
from orders o
where EXISTS (select * from customer c where address like '%대한민국%' and o.custid=c.custid)
;


