-- 코드를 입력하세요
SELECT fp.product_id as PRODUCT_ID, fp.product_name as PRODUCT_NAME, sum(fp.price * fo.amount) as TOTAL_SALES
from food_product as fp
inner join food_order as fo
on fp.product_id = fo.product_id
where fo.produce_date like '2022-05-%'
group by fo.product_id
order by total_sales desc, fp.product_id;
