
insert into role(rolename) values ('Administrateur');
insert into role(rolename) values ('Utilisateur');
insert into role(rolename) values ('Modérateur');


insert into person (name, alias, datecreation, roleid) values('Valentin', 'Nawak Chevelu', current_date, 1);
insert into person (name, alias, datecreation, roleid) values('Solenne ', 'Solinouk', current_date, 1);
insert into person (name, alias, datecreation, roleid) values('Grégary', 'Gudule', current_date, 2);
insert into person (name, alias, datecreation, roleid) values('Kevin', 'Batman', current_date, 2);
insert into person (name, alias, datecreation, roleid) values('Samuel', 'Sam', current_date, 3);
insert into person (name, alias, datecreation, roleid) values('Médéric', 'Médou', current_date, 3);
insert into person (name, alias, datecreation, roleid) values('Hector', 'Thor', current_date, 3);

insert into status (statusname) values ('en cours');
insert into status (statusname) values ('terminée');
insert into status (statusname) values ('à planifier');

insert into task (taskname, creationdate, statusid, personid) values ('faire les courses', current_date, 1, 1);
insert into task (taskname, creationdate, statusid, personid) values ('travailler son piano', current_date, 2, 3);
insert into task (taskname, creationdate, statusid, personid) values ('madera', current_date, 1, 2);
insert into task (taskname, creationdate, statusid, personid) values ('faire des pompes', current_date, 3, 7);
insert into task (taskname, creationdate, statusid, personid) values ('sauver le monde', current_date, 3, 3);
insert into task (taskname, creationdate, statusid, personid) values ('conduire un tracteur', current_date, 2, 6);


select * from person;
select * from task ;
select * from status;
select * from role;
