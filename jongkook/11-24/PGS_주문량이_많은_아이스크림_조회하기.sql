SELECT j.flavor
FROM first_half AS f join july AS j
USING (flavor) group by flavor order by (sum(f.total_order) + sum(j.total_order))
DESC LIMIT 3;
