--The output correct display of the table items
select i.id_item, ap.description, ua.name_user, up.name_user, c.name_category, s.name_status  from items as i
inner join applications as ap on i.description_application = ap.id_a
inner join users as ua on i.user_applicant = ua.id_u
inner join users as up on i.user_perfomers = up.id_u
inner join categorys as c on i.category = c.id_c
inner join status_application as s on i.status = s.id_s;

--The output all items where applicant is Andrey
select ua.name_user, c.name_category, s.name_status from items as i
inner join users as ua on i.user_applicant = ua.id_u
inner join categorys as c on i.category = c.id_c
inner join status_application as s on i.status = s.id_s
where ua.name_user = 'Andrey';

--The output all items where id is from 2 to 5
select i.id_item, ap.description, c.name_category, s.name_status  from items as i
inner join applications as ap on i.description_application = ap.id_a
inner join categorys as c on i.category = c.id_c
inner join status_application as s on i.status = s.id_s
where i.id_item between 2 and 5; 


--The output count items where user applicant is Anton
select count(i.id_item) from items as i
inner join users as ua on i.user_applicant = ua.id_u
where ua.name_user = 'Anton';

--The output correct display of the table items
select ap.id_a, f.link_to_file from applications as ap
inner join files as f on ap.file = f.id_f
where ap.description like '%computer%';