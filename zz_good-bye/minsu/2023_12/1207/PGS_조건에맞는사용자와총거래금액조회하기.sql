SELECT B.USER_ID, B.NICKNAME, sum(price) as TOTAL_PRICE
from USED_GOODS_BOARD as A join USED_GOODS_USER as B on A.WRITER_ID = B.USER_ID
where status = 'done'
group by a.writer_id
having TOTAL_PRICE >= 700000
order by TOTAL_PRICE
