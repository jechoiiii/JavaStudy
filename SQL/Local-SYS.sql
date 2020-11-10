select * from dba_users;

select * from all_users;

create user scott identified by tiger;

grant connect, resource to scott;


CONN scott/tiger
@/Users/christine/GitHub/JavaStudy/SQL/demobld.sql.txt;

grant 
select, insert, update, delete
on 
system.demobld.sql.txt
to
scott;

start demobld.sql;

show user;

