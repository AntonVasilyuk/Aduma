create table transmission (
	id serial primary key,
	name varchar(300),
	mileage integer
);

create table engine (
	id serial primary key,
	name varchar(300),
	power integer,
	mileage integer
);

create table suspension (
	id serial primary key,
	name varchar(300),
	mileage integer
);

create table cars (
	id serial primary key,
	name varchar(300),
	engine integer references engine(id),
	transmission integer references transmission(id),
	suspension integer references suspension(id)
);