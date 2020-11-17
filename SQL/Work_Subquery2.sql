-- [실습] join & sub query
select * from orders o; -- orderid, custid, bookid, saleprice, orderdate
select * from customer c; -- custid, name, address, phone
select * from book b; -- bookid, bookname, publisher, price

-- 1. 마당서점의 고객이 요구하는 다음 질문에 대해 SQL 문을 작성하시오.
-- (5) 박지성이 구매한 도서의 출판사 수 -- c.name, b.publisher, b.bookid
select *
from orders o, customer c
where c.custid=o.custid and name='박지성';-- 박지성이 구매한 도서

select count(publisher)
from book
where bookid = ANY(select bookid
                from orders o, customer c
                where c.custid=o.custid and name='박지성')
-- where bookid IN (select o.bookid from orders o, customer c where c.custid=o.custid and c.name='박지성')
;

--OR 조인을 이용한 해결
select count(distinct b.publisher) 
from customer c, book b, orders o
where o.custid=c.custid and o.bookid=b.bookid
and c.name='박지성'
;

-- (6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이 -- c.name, b.bookname, o.saleprice, b.price-o.saleprice
select b.bookname, b.price, b.price-o.saleprice as pricegap -- 정가와 판매가격의 차이
from orders o, book b
where o.bookid=b.bookid 
and o.custid=(select custid from customer where name='박지성');

--OR 조인을 이용한 해결
select b.bookname, b.price, b.price-o.saleprice as pricegap
from customer c, book b, orders o
where o.custid=c.custid and o.bookid=b.bookid
and c.name='박지성'
;

-- (7) 박지성이 구매하지 않은 도서의 이름 - c.name, b.bookname

-- 서브쿼리 1개 
select distinct bookname from book b, orders o 
where o.bookid = b.bookid 
and o.custid != (select custid from customer where name='박지성');

-- OR 조인 3개 --> 결과 5개
select distinct b.bookname
from orders o, customer c, book b
where o.custid=c.custid and b.bookid=o.bookid
and c.name!='박지성'
;

-- OR 서브쿼리 2개 --> 결과 7개???
select distinct bookname
from book
where bookid NOT IN (
                select bookid -- 박지성이 구매한 도서 id
                from orders
                where custid=(
                                select custid from customer where name='박지성')
);

-- 2. 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL 문을 작성하시오.

-- (8) 주문하지 않은 고객의 이름(부속질의 사용)
select name 
from customer 
where custid != ALL(select o.custid 
                    from orders o, customer c 
                    where o.custid = c.custid);
-- OR Outer 조인
select c.name
from orders o, customer c
where o.custid(+)=c.custid
and o.custid is null;

-- OR
select distinct name
from customer
where custid NOT IN(select distinct custid from orders);

-- (9) 주문금액의 총액과 주문의 평균 금액
select sum(saleprice), avg(saleprice) from orders;

-- (10) 고객의 이름과 고객별 구매액
select c.name, sum(o.saleprice)
from customer c, orders o
where c.custid=o.custid
group by c.name
;

-- (11) 고객의 이름과 고객이 구매한 도서목록
select c.name, (select b.bookname from book b where o.bookid=b.bookid)
from customer c, orders o
where c.custid=o.custid
order by c.name
;
-- OR
select c.name, b.bookname
from customer c, orders o, book b
where c.custid=o.custid and b.bookid=o.bookid
;

-- (12) 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문

select *
from orders o, book b
where o.bookid=b.bookid 
--and b.price-o.saleprice >= ALL(select b.price-o.saleprice from orders o, book b where o.bookid=b.bookid)
and b.price-o.saleprice = (select MAX(b.price-o.saleprice)from orders o, book b where o.bookid=b.bookid)
;

-- (13) 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름
select c.name
from customer c, orders o
where o.custid=c.custid 
group by c.name
having avg(o.saleprice) > (select avg(saleprice) from orders)
;

-- ***********************************************************************
-- 3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
-- (1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
select c.name
from orders o, customer c, book b
where o.custid=c.custid and b.bookid=o.bookid
and b.publisher IN(select b.publisher
                        from orders o, customer c, book b
                        where o.custid=c.custid and b.bookid=o.bookid
                        and c.name='박지성')
and c.name!='박지성'
;

-- (2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
select c.name, count(distinct publisher)
from orders o, customer c, book b
where o.custid=c.custid and b.bookid=o.bookid
--and count(distinct publisher)>1 -- XXXXXXX 그룹핑한 값의 조건은 ** HAVING **
group by c.name
having count(distinct publisher)>1
;
