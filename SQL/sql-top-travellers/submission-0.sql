-- Write your query below
select 
    u.name,
    COALESCE(sum(r.distance), 0) travelled_distance
from users u 
left join rides r 
on u.id = r.user_id
group by ( u.name)
order by COALESCE(sum(r.distance), 0) desc