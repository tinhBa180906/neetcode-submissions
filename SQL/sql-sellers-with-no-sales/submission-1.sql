-- Write your query below
select  seller_name 
from seller
where seller_id not in (
    select distinct s.seller_id 
    from seller s 
    left join orders o 
    on s.seller_id = o.seller_id
    where o.sale_date >= '2020-01-01'  and o.sale_date <= '2020-12-31'
) order by seller_name