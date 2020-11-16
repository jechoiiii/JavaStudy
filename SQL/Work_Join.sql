-- [실습] JOIN 문제풀이

select * from emp;
select * from dept;

-- 32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.
-- 사원 이름 - emp, 부서 이름 - dept
-- cross join에서 공통 컬럼의 동등 비교로 의미 있는 결과로 만든 JOIN
-- cross join
select *
from emp, dept
;
-- equi join
select ename, e.deptno, d.dname
from emp e, dept d
where e.deptno=d.deptno and ename='SCOTT'
;
-- ANSI join
select *
from emp e join dept d
-- ON e.deptno=d.deptno
USING(deptno)
;
select *
from emp natural join dept
;

-- 33. INNER JOIN과 ON 연산자를 사용하여 사원 이름과 함께 그 사원이 소속된 부서이름과 지역 명을 출력하시오.
select ename, dname, loc
from emp INNER JOIN dept
ON emp.deptno=dept.deptno
;
​
-- 36. 조인과 WildCARD를 사용하여 이름에 ‘A’가 포함된 모든 사원의 이름과 부서명을 출력하시오.
select ename, dname
from emp, dept 
where emp.deptno=dept.deptno and ename like '%A%'
;

-- 37. JOIN을 이용하여 NEW YORK에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오.
select ename, job, deptno, dname
from emp INNER JOIN dept
USING (deptno)
where loc='NEW YORK'
;

-- 38. SELF JOIN을 사용하여 사원의 이름 및 사원번호, 관리자 이름을 출력하시오.
select e.ename, e.empno, m.ename as mgr_name
from emp e, emp m
where e.mgr=m.empno
;

-- 39. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여 사원번호를 기준으로 내림차순 정렬하여 출력하시오.

-- SELF JOIN
select e.ename, e.empno, m.ename as mgr_name
from emp e, emp m
where e.mgr=m.empno(+)
order by e.empno desc
;
-- OUTER JOIN
select e.ename, e.empno, m.ename as mgr_name
from emp e left outer join emp m
on e.mgr=m.empno
order by e.empno desc;

-- 40. SELF JOIN을 사용하여 지정한 사원의 이름, 부서번호, 지정한 사원과 동일한 부서에서 근무하는 사원을 출력하시오. ( SCOTT )
select e.ename as same_dept_ename, e.deptno
from emp e, emp s
where e.deptno=s.deptno and s.ename = 'SCOTT' and e.ename!='SCOTT'
;

-- 41. SELF JOIN을 사용하여 WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.
select e.ename, e.hiredate
from emp w, emp e
where w.ename='WARD' and e.hiredate > w.hiredate
;
​
-- 42. SELF JOIN 을 사용하여 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 출력하시오.
select e.ename, e.hiredate, m.ename as mgr_ename, m.hiredate as mgr_hiredate
from emp e, emp m
where e.mgr=m.empno and e.hiredate < m.hiredate
;

