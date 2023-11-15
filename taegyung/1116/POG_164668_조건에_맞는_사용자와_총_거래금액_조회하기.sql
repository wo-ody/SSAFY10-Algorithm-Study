select writer_id, user.nickname,sum(price) TOTAL_SALES
from USED_GOODS_BOARD board join USED_GOODS_USER user
on board.writer_id = user.user_id
where status = 'DONE'
group by writer_id
having sum(price) >= 700000
order by total_sales
