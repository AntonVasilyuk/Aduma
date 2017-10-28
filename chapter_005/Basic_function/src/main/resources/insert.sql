insert into right_roles (name_rr) values ('admin');
insert into right_roles (name_rr) values ('user');

insert into roles (name_roles) values ('economist');
insert into roles (name_roles) values ('network_administrator');

insert into users (name_user, login, password, right_role, role) 
values ('Anton', 'login', 'password', 5, 6);
insert into users (name_user, login, password, right_role, role) 
values ('Andrey', 'login', 'password', 6, 5);

insert into categorys (name_category) values ('network_setup');
insert into categorys (name_category) values ('payroll');

insert into status_application (name_status) values ('runs');
insert into status_application (name_status) values ('made');

insert into files (link_to_file) values ('c:\dir\instruction.txt');

insert into applications (description, comment, file) 
values ('installation of a new computer', 'needs to be done very quickly!',
1);

insert into applications (description, comment) 
values ('to calculate annual salary', 'asked the network administrator');

insert into items (description_application, user_applicant, user_perfomers, category, status)
values (1, 4, 5, 1, 1);
insert into items (description_application, user_applicant, user_perfomers, category, status)
values (2, 5, 4, 2, 1);
