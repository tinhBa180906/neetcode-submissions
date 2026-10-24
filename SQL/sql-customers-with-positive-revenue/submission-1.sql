-- Write your query below
select distinct customer_id
from customers
where year = 2020 and customer_id not in (
    select customer_id
    from customers
    where revenue <= 0 and year = 2020
 
)