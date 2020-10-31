/*
SDEV 350 Database Security
Prof Eyler
Coe, Joshua
31 October 2020
SQL script for project 2
*/

--clean up the database and prep for creation
drop view enrolled;
drop table classenrollments;
drop table Engineers;
drop table faculty;
drop table classes;

-- create the engineer table and fill with 15 records
create table Engineers(
    EID NUMBER GENERATED ALWAYS as IDENTITY,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    email VARCHAR(50),
    graddate DATE,
    CONSTRAINT pk_engineers PRIMARY KEY(EID)
);

insert into Engineers (firstname, lastname, email, graddate) VALUES ('Josh', 'Coe', 'J@c.com', TO_DATE('12-Dec-2021','DD-Mon-YYYY'));
insert into Engineers (firstname, lastname, email, graddate) VALUES ('Jack', 'Coe', 'J1@c.com', TO_DATE('12-Dec-2020','DD-Mon-YYYY'));
insert into Engineers (firstname, lastname, email, graddate) VALUES ('John', 'Coe', 'J2@c.com', TO_DATE('12-Dec-2020','DD-Mon-YYYY'));
insert into Engineers (firstname, lastname, email, graddate) VALUES ('James', 'Coe', 'J3@c.com', TO_DATE('12-Dec-2022','DD-Mon-YYYY'));
insert into Engineers (firstname, lastname, email, graddate) VALUES ('Jerrel', 'Coe', 'J4@c.com', TO_DATE('12-Dec-2020','DD-Mon-YYYY'));
insert into Engineers (firstname, lastname, email, graddate) VALUES ('Jennifer', 'Coe', 'J5@c.com', TO_DATE('12-Dec-2023','DD-Mon-YYYY'));
insert into Engineers (firstname, lastname, email, graddate) VALUES ('Jason', 'Coe', 'J6@c.com', TO_DATE('12-Dec-2000','DD-Mon-YYYY'));
insert into Engineers (firstname, lastname, email, graddate) VALUES ('Jackie', 'Coe', 'J7@c.com', TO_DATE('12-Dec-2001','DD-Mon-YYYY'));
insert into Engineers (firstname, lastname, email, graddate) VALUES ('Jaxson', 'Coe', 'J8@c.com', TO_DATE('12-Dec-2003','DD-Mon-YYYY'));
insert into Engineers (firstname, lastname, email, graddate) VALUES ('Jordan', 'Coe', 'J9@c.com', TO_DATE('12-Dec-2004','DD-Mon-YYYY'));
insert into Engineers (firstname, lastname, email, graddate) VALUES ('Joan', 'Coe', 'J11@c.com', TO_DATE('12-Dec-2005','DD-Mon-YYYY'));
insert into Engineers (firstname, lastname, email, graddate) VALUES ('Jimmy', 'Coe', 'J12@c.com', TO_DATE('12-Dec-2021','DD-Mon-YYYY'));
insert into Engineers (firstname, lastname, email, graddate) VALUES ('Jane', 'Coe', 'J13@c.com', TO_DATE('12-Dec-2022','DD-Mon-YYYY'));
insert into Engineers (firstname, lastname, email, graddate) VALUES ('Jill', 'Coe', 'J14@c.com', TO_DATE('12-Dec-2023','DD-Mon-YYYY'));
insert into Engineers (firstname, lastname, email, graddate) VALUES ('Jexboss', 'Coe', 'J15@c.com', TO_DATE('12-Dec-2020','DD-Mon-YYYY'));

-- create the faculty table and fill with 3 records
create table faculty(
    FID NUMBER GENERATED ALWAYS as IDENTITY,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    email VARCHAR(50),
    hiredate DATE,
    CONSTRAINT pk_faculty PRIMARY KEY(FID)
);

insert into faculty (firstname, lastname, email, hiredate) VALUES ('Brent', 'Cole', 'b@c.com', TO_DATE('12-Dec-2000','DD-Mon-YYYY'));
insert into faculty (firstname, lastname, email, hiredate) VALUES ('Brian', 'Cope', 'b1@c.com', TO_DATE('12-Dec-1999','DD-Mon-YYYY'));
insert into faculty (firstname, lastname, email, hiredate) VALUES ('Brenda', 'Coke', 'b2@c.com', TO_DATE('12-Dec-1957','DD-Mon-YYYY'));

-- create the classes table and fill with 3 records
create table classes(
    CID NUMBER GENERATED ALWAYS as IDENTITY,
    subject VARCHAR(10),
    catalognbr NUMBER,
    title VARCHAR(50),
    CONSTRAINT pk_classes PRIMARY KEY(CID)
);

insert into classes (subject, catalognbr, title) VALUES ('SDEV', '350', 'Secure Database Design');
insert into classes (subject, catalognbr, title) VALUES ('SDEV', '300', 'Developing Secure Applications');
insert into classes (subject, catalognbr, title) VALUES ('SDEV', '370', 'Computers, What if One Day They Were In Charge?');

-- create the classenrollments and fill with 15 records from other tables
create table classenrollments(
    EnID NUMBER GENERATED ALWAYS as IDENTITY,
    CID NUMBER not null,
    FID NUMBER not null,
    EID NUMBER not null,
    FOREIGN KEY(CID) REFERENCES classes(CID),
    FOREIGN KEY(FID) REFERENCES faculty(FID),
    FOREIGN KEY(EID) REFERENCES Engineers(EID)
);

insert into classenrollments (CID, FID, EID) VALUES (1, 1, 1);
insert into classenrollments (CID, FID, EID) VALUES (1, 1, 2);
insert into classenrollments (CID, FID, EID) VALUES (1, 1, 3);
insert into classenrollments (CID, FID, EID) VALUES (1, 1, 4);
insert into classenrollments (CID, FID, EID) VALUES (1, 1, 5);
insert into classenrollments (CID, FID, EID) VALUES (2, 3, 6);
insert into classenrollments (CID, FID, EID) VALUES (2, 3, 7);
insert into classenrollments (CID, FID, EID) VALUES (2, 3, 8);
insert into classenrollments (CID, FID, EID) VALUES (2, 3, 9);
insert into classenrollments (CID, FID, EID) VALUES (2, 3, 10);
insert into classenrollments (CID, FID, EID) VALUES (3, 2, 11);
insert into classenrollments (CID, FID, EID) VALUES (3, 2, 12);
insert into classenrollments (CID, FID, EID) VALUES (3, 2, 13);
insert into classenrollments (CID, FID, EID) VALUES (3, 2, 14);
insert into classenrollments (CID, FID, EID) VALUES (3, 2, 15);

-- update statements per the instructions
update faculty
set lastname = 'Friendship'
where FID = 1;

update Engineers
set firstname = 'Amadeus'
where EID = 1;

update classes
set subject = 'IOT Cyber'
where CID = 1;

-- delete the record with the lowest enid
delete from classenrollments
where enid = (select min(enid) from classenrollments);

-- select all records from each table and display in descending order by PK
select * from Engineers ORDER BY EID DESC;
select * from classes ORDER BY CID DESC;
select * from faculty ORDER BY FID DESC;
select * from classenrollments ORDER BY EnID DESC;

-- create the enrolled view
create view enrolled
--concatenate names into one with comma
as select b.lastname||', '||b.firstname as enname,
-- professors name and email
c.lastname as professor, c.email as prof_email,
-- class information
d.subject, d.title
-- assign variables
from classenrollments a, engineers b,
faculty c, classes d
-- join based on the classenrollments table
where a.eid = b.eid
and a.fid = c.fid
and a.cid = d.cid;
column enname format A15
column professor format A15
column prof_email format A30;

--show the view
select * from enrolled;