--Sentencia SQL ENTREGA 2 
select task.id_urgency, max(urgency.name) as urgency_name, 
	max(urgency.description) as urgency_description,
	max(urgency.start_date) as start_date,
	max(urgency.end_date) as end_date,
	max(st_y(st_astext(location))) AS latitude, 
	max(st_x(st_astext(location))) AS longitude,
	count(task.id) as cantidadTask, sum(task.num_vol_signin) as cantidadVolunteer
from urgency
join task on urgency.id = task.id_urgency
where urgency.end_date is not NULL and urgency.delete = false
group by task.id_urgency
order by task.id_urgency

--Esta consulta toma en cuenta SOLO AQUELLOS VOLUNTARIOS INSCRITOS
select urgency.id, max(urgency.name) as urgency_name,
	max(urgency.description) as urgency_description,
	max(urgency.start_date) as start_date,
	max(urgency.end_date) as end_date,
	max(st_y(st_astext(location))) as latitude, 
	max(st_x(st_astext(location))) as longitude,
	count(distinct task.id) as cantidadTask,
	count(distinct ranking.id_volunteer) as cantidadVolunteer
from urgency
join task on task.id_urgency = urgency.id
join ranking on ranking.id_task = task.id
where urgency.end_date is not NULL and urgency.delete = false
group by urgency.id