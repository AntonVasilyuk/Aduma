create database java_a_to_z;

create table right_roles (
id_rr serial primary key,
name_rr character varying (1000) not null unique
);

create table roles (
id_r serial primary key,
name_roles character varying (1000) not null unique,
id_rr integer references right_roles (id_rr)
);

create table users (
id_u serial primary key,
name_user character varying (1000),
login character varying (100),
password character varying (100),
right_role integer references right_roles (id_rr),
role integer references roles (id_r) 
);

create table categorys (
id_c serial primary key,
name_category character varying (1000) not null unique
);

create table status_application (
id_s serial primary key,
name_status character varying (1000) not null unique
);

create table files (
id_f serial primary key,
link_to_file character varying (1000)
);

create table applications (
id_a serial primary key,
description character varying (1000),
comment character varying (3000),
file integer references files (id_f)
);

create table items (
id_item serial primary key,
description_application integer references applications (id_a),
user_applicant integer references users (id_u),
user_perfomers integer references users (id_u),
category integer references categorys (id_c),
status integer references status_application (id_s)
);