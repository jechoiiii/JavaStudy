INSERT INTO open.member (memberid, password, membername) values ('cool@gmail.com', '1111', 'COOL');
-- INSERT INTO open.member (memberid, password, membername) values (?, ?, ?)

SELECT * FROM open.member;
SELECT * FROM member;
-- SELECT * FROM member;

SELECT count(*) FROM open.member;
-- SELECT count(*) FROM member

SELECT * FROM open.member order by memberid limit 0,3;
-- SELECT * FROM member order by memberid limit ?,?
