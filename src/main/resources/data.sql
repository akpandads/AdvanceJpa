insert into course(id,name,created_date,last_updated) values (10001,'ms in 10 days',sysdate(),sysdate());
insert into course(id,name,created_date,last_updated) values (10002,'kubernetes',sysdate(),sysdate());
insert into course(id,name,created_date,last_updated) values (10003,'linux advanced',sysdate(),sysdate());

insert into passport(id,number) values (400001,'L31212');
insert into passport(id,number) values (400002,'E2212312');
insert into passport(id,number) values (400003,'vsasa121');


insert into student(id,name,passport_id) values (200001,'James Bond',400001);
insert into student(id,name,passport_id) values (200002,'Uselss Bond',400002);
insert into student(id,name,passport_id) values (200003,'Kvothe Bond',400003);


insert into review(id,rating,description) values (600001,'3','good');
insert into review(id,rating,description) values (600002,'2','');
insert into review(id,rating,description) values (600003,'5','excellent');