-- 코드를 입력하세요
-- 7월 총 주문량, 상반기 아이스크림 총 주문량 더한 값이 큰 순서대로 상위 3개의 맛
select flavor from (SELECT * 
# from first_half half join july on half.flavor = july.flavor
from  first_half
union
select * from july) sub
group by flavor
order by (sum(total_order)) desc limit 3
