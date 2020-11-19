SELECT `memeber`.`idx`,
    `memeber`.`userid`,
    `memeber`.`password`,
    `memeber`.`username`,
    `memeber`.`regdate`
FROM `project`.`memeber`;

INSERT INTO `project`.`memeber`
(`idx`, `userid`, `password`, `username`, `regdate`)
VALUES(<{idx: }>, <{userid: }> ,<{password: }> ,<{username: }> ,<{regdate: CURRENT_TIMESTAMP}>)
;

INSERT INTO `project`.`memeber`
(`userid`, `password`, `username`)  # regdate는 default로 
VALUES('king', '1111', 'KING')
;

UPDATE `project`.`memeber`
SET
`password` = '1234',
`username` = 'COOL'
WHERE `idx` = 1;

DELETE FROM `project`.`memeber`
WHERE idx=1;

select * from `project`.`memeber`; # ``가 필수는 아님
select * from project.memeber;

rollback;

commit;