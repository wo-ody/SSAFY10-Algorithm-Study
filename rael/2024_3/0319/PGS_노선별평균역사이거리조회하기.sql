select 
    route, 
    concat(round(sum(d_between_dist), 1), "km") as total_distance, 
    concat(round(avg(d_between_dist), 2), "km") as average_distance
from subway_distance
group by route
order by round(sum(d_between_dist), 1) desc
