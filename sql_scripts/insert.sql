SELECT * from customers;

INSERT INTO customers
VALUES (1, 'Artem', 'Volodin', '4687342565', '12.08.2016', default, default);
INSERT INTO customers
VALUES (2, 'Vladimir', 'Khrunov', '4332333333', '19.12.2001', default, default);
INSERT INTO customers
VALUES (3, 'Ivan', 'Lebedev', '4313125989', '20.07.2016', default, default);
INSERT INTO customers
VALUES (4, 'Maksim', 'Shevchenko', '4515679008', '21.06.2016', default, default);
INSERT INTO customers
VALUES (5, 'Nikita', 'Ivanov', '4325169345', '20.01.2009', default, default);
INSERT INTO customers
VALUES (6, 'Fedor', 'Lopuhov', '422156732', '18.09.2009', default, default);
INSERT INTO customers
VALUES (7, 'Denis', 'Merkushin', '4612456432', '19.12.2016', default, default);
INSERT INTO customers
VALUES (8, 'Timur', 'Kikichev', '4615234786', '01.06.2017', '01.06.2017', default);
INSERT INTO customers
VALUES (8, 'Timur', 'Kikichev', '4618945576', '20.06.2017', default, default);

commit;




SELECT * from contracts;

INSERT INTO contracts
VALUES (1, 2, '20.07.2016', default);
INSERT INTO contracts
VALUES (2, 2, '25.07.2016', default);
INSERT INTO contracts
VALUES (3, 2, '10.09.2016', default);
INSERT INTO contracts
VALUES (4, 3, '08.08.2017', default);
INSERT INTO contracts
VALUES (5, 4, '01.03.2017', default);
INSERT INTO contracts
VALUES (6, 5, '03.01.2016', default);
INSERT INTO contracts
VALUES (7, 6, '06.07.2016', default);

commit;

SElect * from ACCOUNTS;

insert into ACCOUNTS values (1,1,'Депозитный счет','22-07-16','22-04-20',200000); 
insert into ACCOUNTS values (2,1,'Депозитный счет','22-07-16','22-04-20',200010); 
insert into ACCOUNTS values (3,3,'Бюджетный счет','12-07-16','22-04-20',2000500); 
insert into ACCOUNTS values (4,3,'Бюджетный счет','12-07-16','22-04-20',200000); 
insert into ACCOUNTS values (5,4,'Текущий счет','10-08-17','22-04-20',110000); 
insert into ACCOUNTS values (6,5,'Депозитный счет','03-03-17','22-04-20',200000); 
insert into ACCOUNTS values (7,5,'Депозитный счет','03-03-17','22-04-20',200300); 
insert into ACCOUNTS values (8,6,'Текущий счет','05-01-16','22-04-20',2000000); 
insert into ACCOUNTS values (9,7,'Депозитный счет','08-07-16','22-04-20',200000); 
insert into ACCOUNTS values (10,7,'Текущий счет','08-07-16','22-04-20',200000);






SELECT * from operations;

INSERT INTO operations
VALUES (1, 'Real estate', 1, 2, 4500000, '17.04.17');
INSERT INTO operations
VALUES (2, 'Real estate', 1, 2, 12096321, '18.04.17');
INSERT INTO operations
VALUES (3, 'Real estate', 1, 3, 3000000, '01.04.17');
INSERT INTO operations
VALUES (4, 'Real estate', 1, 5, 1575398, '05.04.17');
INSERT INTO operations
VALUES (5, 'Real estate', 7, 1, 9076225, '27.04.17');
INSERT INTO operations
VALUES (6, 'Real estate', 5, 10, 32300280, '19.04.17');
INSERT INTO operations
VALUES (7, 'Real estate', 5, 12, 5456039, '20.04.17');
INSERT INTO operations
VALUES (8, 'Goods, works and services', 2, 1, 12000, '15.03.2017');
INSERT INTO operations
VALUES (9, 'Goods, works and services', 3, 1, 15000, '15.03.2017');
INSERT INTO operations
VALUES (10, 'Goods, works and services', 4, 1, 39000, '15.03.2017');
INSERT INTO operations
VALUES (11, 'Goods, works and services', 5, 1, 25021, '15.03.2017');
INSERT INTO operations
VALUES (12, 'Goods, works and services', 6, 1, 27987, '15.03.2017');
INSERT INTO operations
VALUES (13, 'Goods, works and services', 7, 1, 39339, '15.03.2017');
INSERT INTO operations
VALUES (14, 'Goods, works and services', 8, 1, 5000, '15.03.2017');
INSERT INTO operations
VALUES (15, 'Goods, works and services', 3, 1, 3498, '15.03.2017');
INSERT INTO operations
VALUES (16, 'Goods, works and services', 5, 1, 14759, '15.03.2017');
INSERT INTO operations
VALUES (17, 'Goods, works and services', 1, 1, 39843, '15.03.2017');
INSERT INTO operations
VALUES (18, 'Goods, works and services', 6, 1, 12846, '15.03.2017');
INSERT INTO operations
VALUES (19, 'Goods, works and services', 7, 1, 35083, '15.03.2017');
INSERT INTO operations
VALUES (20, 'Goods, works and services', 6, 1, 27987, '15.03.2017');
INSERT INTO operations
VALUES (21, 'Goods, works and services', 7, 1, 39339, '15.03.2017');
INSERT INTO operations
VALUES (22, 'Goods, works and services', 8, 1, 5000, '15.03.2017');
INSERT INTO operations
VALUES (23, 'Goods, works and services', 3, 1, 3498, '15.03.2017');
INSERT INTO operations
VALUES (24, 'Goods, works and services', 5, 1, 14759, '15.03.2017');
INSERT INTO operations
VALUES (25, 'Goods, works and services', 10, 1, 39843, '15.03.2017');
INSERT INTO operations
VALUES (26, 'Goods, works and services', 6, 1, 12846, '15.03.2017');
INSERT INTO operations
VALUES (27, 'chattel', 7, 4, 350083, '15.03.2017');
INSERT INTO operations
VALUES (28, 'chattel', 3, 10, 1356483, '15.03.2017');
INSERT INTO operations
VALUES (29, 'chattel', 9, 2, 2709843, '15.03.2017');
INSERT INTO operations
VALUES (30, 'chattel', 4, 7, 124572, '15.03.2017');
INSERT INTO operations
VALUES (31, 'chattel', 2, 8, 987653, '15.03.2017');
INSERT INTO operations
VALUES (32, 'chattel', 8, 2, 213532, '15.03.2017');
INSERT INTO operations
VALUES (33, 'chattel', 9, 4, 7904321, '15.03.2017');

INSERT INTO operations
VALUES (34, 'Real estate', 1, 10, 4504600, '01.05.17');
INSERT INTO operations
VALUES (35, 'Real estate', 1, 8, 32090321,'03.05.17' );
INSERT INTO operations
VALUES (36, 'Real estate', 1, 7, 4563790, '15.05.17');
INSERT INTO operations
VALUES (37, 'Real estate', 1, 7, 145621, '08.05.17');
INSERT INTO operations
VALUES (38, 'Real estate', 5, 9, 23451252, '18.05.17');
INSERT INTO operations
VALUES (39, 'Real estate', 7, 2, 980472, '22.05.17');
INSERT INTO operations
VALUES (40, 'Real estate', 8, 1, 6674639,'23.05.17' );
INSERT INTO operations
VALUES (41, 'Goods, works and services', 2, 5, 22000, '06.04.17' );
INSERT INTO operations
VALUES (42, 'Goods, works and services', 3, 5, 15003, '06.04.17');
INSERT INTO operations
VALUES (43, 'Goods, works and services', 4, 5, 37892, '06.04.17');
INSERT INTO operations
VALUES (44, 'Goods, works and services', 1, 5, 7600, '06.04.17');
INSERT INTO operations
VALUES (45, 'Goods, works and services', 6, 5, 6359, '06.04.17');
INSERT INTO operations
VALUES (46, 'Goods, works and services', 7, 5, 32451, '06.04.17');
INSERT INTO operations
VALUES (47, 'Goods, works and services', 8, 5, 32457, '06.04.17');
INSERT INTO operations
VALUES (48, 'Goods, works and services', 3, 5, 13, '06.04.17');
INSERT INTO operations
VALUES (49, 'Goods, works and services', 9, 5, 2456, '06.04.17');
INSERT INTO operations
VALUES (50, 'Goods, works and services', 1, 5, 12367, '06.04.17');
INSERT INTO operations
VALUES (51, 'Goods, works and services', 6, 5, 9764, '06.04.17');
INSERT INTO operations
VALUES (52, 'Goods, works and services', 7, 5, 3467, '06.04.17');
INSERT INTO operations
VALUES (53, 'Goods, works and services', 6, 1, 8765, '06.04.17');
INSERT INTO operations
VALUES (54, 'Goods, works and services', 7, 1, 4368, '06.04.17');
INSERT INTO operations
VALUES (55, 'Goods, works and services', 8, 1, 9831, '06.04.17');
INSERT INTO operations
VALUES (56, 'Goods, works and services', 3, 1, 12461, '06.04.17');
INSERT INTO operations
VALUES (57, 'Goods, works and services', 5, 1, 13468, '06.04.17');
INSERT INTO operations
VALUES (58, 'Goods, works and services', 10, 1, 1234578, '06.04.17');
INSERT INTO operations
VALUES (59, 'Goods, works and services', 6, 1, 12245702, '06.04.17');
INSERT INTO operations
VALUES (60, 'chattel', 3, 2, 222222, '05.04.17');
INSERT INTO operations
VALUES (61, 'chattel', 5, 1, 1356483, '09.04.17');
INSERT INTO operations
VALUES (62, 'chattel', 4, 10, 23209843, '10.04.17');
INSERT INTO operations
VALUES (63, 'chattel', 4, 7, 3954572, '15.04.17');
INSERT INTO operations
VALUES (64, 'chattel', 3, 1, 986953, '17.04.17');
INSERT INTO operations
VALUES (65, 'chattel', 8, 2, 243532, '20.04.17');
INSERT INTO operations
VALUES (66, 'chattel', 10, 3, 7302321, '22.04.17');

commit;
