select sum(b.score) score, a.emp_no, a.emp_name, a.position, a.email
from hr_employees a join hr_grade b
on a.emp_no = b.emp_no
group by b.emp_no
order by 1 desc
limit 1;
