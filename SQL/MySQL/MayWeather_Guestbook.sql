-- 입력 sql (공개글)
INSERT INTO open.guestbook (memIdx, writerIdx, writerName, writerPhoto, writerLoc, content, contentPhoto)
VALUES('0010','1110','테스트1', '포토1', '위치1', '반갑습니다1', '첨부사진1');
-- INSERT INTO guestbook (mem_idx, writer_idx, writer_name, writer_photo, writer_loc, content) VALUES(?,?,?,?,?,?)

-- 입력 sql (비밀글)
INSERT INTO open.guestbook (memIdx, writerIdx, writerName, writerPhoto, writerLoc, content, contentPhoto, secret)
VALUES ('0020','1120','테스트2', '포토2', '위치2', '반갑습니다2', '첨부사진2', 'Y');
-- INSERT INTO guestbook (mem_idx, writer_idx, writer_name, writer_photo, writer_loc, content) VALUES(?,?,?,?,?,?,?); 

-- 질의 sql
SELECT * FROM open.guestbook;
-- SELECT * FROM guestbook

-- 삭제 sql 
DELETE FROM guestbook WHERE memberNo=1;
-- DELETE FROM guestbook WHERE idx=?


-- 전체 게시물의 개수 구하기 
SELECT count(*) FROM open.guestbook;
-- SELECT count(*) FROM guestbook

--  페이지 별 메시지 리스트 
SELECT * FROM open.guestbook ORDER BY idx desc limit 3, 3;
-- SELECT * FROM guestbook ORDER BY idx desc limit ?, ?

-- 게시물 하나를 검색하는 질의 
SELECT * FROM open.guestbook where idx=11;
-- SELECT * FROM guestbook where idx=?
