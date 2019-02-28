Insert into course(id,name , created_time , updated_time) values(1001,'Jpa in 50 steps',sysdate() , sysdate());
Insert into course (id,name ,created_time  , updated_time) values(1002,'Spring in 70 steps',sysdate(),sysdate());
Insert into course(id,name ,created_time  , updated_time) values(1003,'Hibernate in 40 steps',sysdate(),sysdate());
Insert into course (id,name ,created_time  , updated_time) values(1004,'Liqubase in 20 steps',sysdate(),sysdate());



insert into Passport (id , number)
values(4001,'K1s4454');
insert into Passport (id , number)
values(4002,'S8S145');
insert into Passport (id , number)
values(4003,'MN0014');


insert into Student (id , name ,passport_id)
values(2001,'Pruthwee',4001);
insert into Student (id , name,passport_id)
values(2002,'Pupa',4002);
insert into Student (id , name,passport_id)
values(2003,'Pr' ,4003);





insert into Review (id , rating , description , course_id)
values(5001,'5' ,'Very Good' ,1001);
insert into Review (id ,  rating , description, course_id)
values(5002,'4' , 'Excellent',1001);
insert into Review (id ,  rating , description, course_id)
values(5003,'5' ,'OutStanding' ,1003);

