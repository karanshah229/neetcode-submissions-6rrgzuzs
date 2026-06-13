select 
    employee_id,
    CASE
        when left(name, 1) != 'M' and employee_id % 2 != 0 then salary
        else 0
    END as bonus
from employees
order by employee_id;