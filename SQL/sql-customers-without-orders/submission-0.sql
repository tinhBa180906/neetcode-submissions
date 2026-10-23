-- Write your query below
select name
from customers 
where id not in (
    select distinct customer_id as id
    from orders

)

