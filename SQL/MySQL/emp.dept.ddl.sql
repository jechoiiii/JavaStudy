CREATE TABLE project.dept (
  `DEPTNO` int NOT NULL,
  `DNAME` varchar(14),
  `LOC` varchar(13),
  PRIMARY KEY (`DEPTNO`)
)
;


CREATE TABLE project.emp (
  `EMPNO` int NOT NULL,
  `ENAME` varchar(10) NOT NULL,
  `JOB` varchar(9) NOT NULL,
  `MGR` int,
  `HIREDATE` date,
  `SAL` int,
  `COMM` int,
  `DEPTNO` int NOT NULL,
  PRIMARY KEY (`EMPNO`),
  KEY `FK_DEPTNO` (`DEPTNO`),
  CONSTRAINT `FK_DEPTNO` FOREIGN KEY (`DEPTNO`) REFERENCES `dept` (`DEPTNO`)
)
;

select * from project.emp;
select * from project.dept;
drop table project.emp;
drop table dept;


