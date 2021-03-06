--drop table if exists Restaurant, quartier, categorie, note, sondage, votant, Sondage_restaurant cascade;

--DROP TABLE if exists Role;
CREATE TABLE Role
(
    Id       SERIAL PRIMARY KEY,
    RoleName VARCHAR(50) not null

);

--DROP TABLE if exists Person;
CREATE TABLE Person
(
    Id           SERIAL PRIMARY KEY,
    Name         VARCHAR(50) not null,
    Alias        VARCHAR(50),
    CreationDate DATE   not null,
    UpdatedOn    Date,
    RoleId       integer    not null,
    CONSTRAINT Role_Id_fkey FOREIGN KEY (RoleId) REFERENCES Role (Id)

);

--DROP TABLE if exists Status;
CREATE TABLE Status
(
    ID         SERIAL PRIMARY KEY,
    StatusName VARCHAR(50)

);

--DROP TABLE if exists Task;
CREATE TABLE Task
(
    Id           SERIAL PRIMARY KEY,
    TaskName     VARCHAR(50) not null,
    CreationDate date        Not null,
    UpdatedOn    Date        ,
    StatusId     int     not null,
    PersonId     int     not null,
    CONSTRAINT Status_Id_fkey FOREIGN KEY (StatusId) REFERENCES Status (Id),
    CONSTRAINT Person_Id_fkey FOREIGN KEY (PersonId) REFERENCES Person (Id)

);






