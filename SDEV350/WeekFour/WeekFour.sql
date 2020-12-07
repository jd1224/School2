/*
SDEV 350 Database Security
Prof Eyler
Coe, Joshua
12 November 2020
SQL script for project 3
*/

-- Clean up for subsequent runs
DROP USER U2JOSHCOE;
DROP USER U1JOSHCOE;
DROP PROFILE PJOSHCOE;
DROP TABLE USER1DATA;
DROP TABLE USER2DATA;
DROP ROLE R1JOSHCOE;

-- Create profile to enforce password settings
CREATE PROFILE PJOSHCOE LIMIT
    FAILED_LOGIN_ATTEMPTS 4
    PASSWORD_LIFE_TIME 120
    PASSWORD_LOCK_TIME 1/24
    SESSIONS_PER_USER 3
    PASSWORD_VERIFY_FUNCTION ora12c_strong_verify_function;

-- Check the settings of the profile
SELECT * FROM DBA_PROFILES WHERE PROFILE = 'PJOSHCOE';

-- CREATE ROLE TO ALLOW CONNECTION AND TABLE CREATE
CREATE ROLE R1JOSHCOE;
GRANT CREATE SESSION TO R1JOSHCOE;
GRANT CREATE TABLE TO R1JOSHCOE;

--create users and assign them to the profile
CREATE USER U1JOSHCOE
    IDENTIFIED BY "P@$$W0rd1234!@#$"
    DEFAULT TABLESPACE USERS
    QUOTA 30M ON USERS
    PASSWORD EXPIRE
    PROFILE PJOSHCOE;
    
CREATE USER U2JOSHCOE
    IDENTIFIED BY "P@$$W0rd1234!@#$"
    DEFAULT TABLESPACE USERS
    QUOTA 30M ON USERS
    PASSWORD EXPIRE
    PROFILE PJOSHCOE;

-- GRANT ROLE TO USERS TO CONNECT AND CREATE TABLES
GRANT R1JOSHCOE TO U1JOSHCOE;
GRANT R1JOSHCOE TO U2JOSHCOE;

-- CREATE TABLES WITH USERDATA AS SPECIFIED
create table user1data(
    CID NUMBER GENERATED ALWAYS as IDENTITY,
    subject VARCHAR(10),
    catalognbr NUMBER,
    title VARCHAR(50),
    CONSTRAINT pk_user1data PRIMARY KEY(CID)
);

insert into user1data (subject, catalognbr, title) VALUES ('SDEV', '350', 'Secure Database Design');
insert into user1data (subject, catalognbr, title) VALUES ('SDEV', '300', 'Developing Secure Applications');
insert into user1data (subject, catalognbr, title) VALUES ('SDEV', '370', 'Computers, What if One Day They Were In Charge?');

create table user2data(
    CID NUMBER GENERATED ALWAYS as IDENTITY,
    subject VARCHAR(10),
    catalognbr NUMBER,
    title VARCHAR(50),
    CONSTRAINT pk_user2data PRIMARY KEY(CID)
);

insert into user2data (subject, catalognbr, title) VALUES ('SDEV', '350', 'Secure Database Design');
insert into user2data (subject, catalognbr, title) VALUES ('SDEV', '300', 'Developing Secure Applications');
insert into user2data (subject, catalognbr, title) VALUES ('SDEV', '370', 'Computers, What if One Day They Were In Charge?');

-- grant read and insert to the respective users
GRANT READ, INSERT ON USER1DATA TO U1JOSHCOE;
GRANT READ ON USER2DATA TO U2JOSHCOE;
GRANT READ ON USER1DATA TO U2JOSHCOE;