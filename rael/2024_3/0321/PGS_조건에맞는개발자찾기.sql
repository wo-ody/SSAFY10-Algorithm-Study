select id, email, firstname, lastname
from developers
where skill_code & (select sum(code) 
                    from skillcodes
                    where name
                    in ('Python', 'C#'))
order by id;
