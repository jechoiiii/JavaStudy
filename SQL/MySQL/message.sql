-- 입력 sql
INSERT INTO `open`.`guestbook_message` (guest_name, password, message) VALUES ('test','1234','반갑습니다');
-- INSERT INTO `open`.`guestbook_message` (guest_name, password, message) VALUES (?,?,?)

-- 질의 sql
SELECT * FROM open.guestbook_message;
-- SELECT * FROM open.guestbook_message

-- 삭제 sql 
DELETE FROM `open`.`guestbook_message` WHERE message_id=1;
-- DELETE FROM `open`.`guestbook_message` WHERE message_id=?


-- 전체 게시물의 개수 구하기 
SELECT count(*) FROM open.guestbook_message;
-- SELECT count(*) FROM open.guestbook_message

--  페이지 별 메시지 리스트 
SELECT * FROM open.guestbook_message ORDER BY message_id desc limit 3, 3;
-- SELECT * FROM open.guestbook_message ORDER BY message_id desc limit ?, ?