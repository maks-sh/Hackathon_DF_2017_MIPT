select * from customers;

insert into customers values (1,'Maks','sh',1,sysdate,sysdate,sysdate);
insert into customers values (2,'Tim','kk',2,sysdate,sysdate,sysdate);
insert into customers values (2,'Tim','kk',2,sysdate, default, default);

select * from contracts;
insert into contracts VALUES (1,1,sysdate,default);
commit;