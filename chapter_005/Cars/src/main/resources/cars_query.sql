--The output all cars
select c.id, c.name, e.name, t.name, s.name  from cars as c
inner join engine as e on c.engine = e.id
inner join transmission as t on c.transmission = t.id
inner join suspension as s on c.suspension = s.id;

--The output of all the unused engine
select e.name from engine as e left outer join cars as c on c.engine = e.id where c.id is null;

--The output of all the unused transmission
select s.name from suspension as s left outer join cars as c on c.suspension = s.id where c.id is null;

--The output of all the unused suspension
select t.name from transmission as t left outer join cars as c on c.transmission = t.id where c.id is null;