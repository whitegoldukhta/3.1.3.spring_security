insert into spring_web.users2 (name, last_name, password, username)
values ('Oleg', 'Petrov' , '$2a$12$rxXnG3TM3GXY2JiwPtStK.9Mdy9lMDkCg.L7gqbDp9HHkHCqto8Pm', 'oleg');
#pass: 1234
insert into spring_web.users2 (name, last_name, password, username)
values ('Elena', 'Sidorova' , '$2a$12$5UJWvGe7.xiLmFrzjxyIO.K06JP.LsJPQ0hgS7BnQzgcdUqoQrAHW', 'elena');
#pass: 1111
insert into spring_web.roles value (1, 'USER');
insert into spring_web.roles value (2, 'ADMIN');
insert into spring_web.users2_roles (users_id, roles_id) values (1,2);
insert into spring_web.users2_roles (users_id, roles_id) values (2,1);

