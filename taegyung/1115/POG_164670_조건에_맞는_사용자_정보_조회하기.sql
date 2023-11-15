-- 코드를 입력하세요
select USER_ID,NICKNAME,concat(city," ",street_address1," " ,street_address2) as 전체주소, 
concat(substring(tlno from 1 for 3),"-", substring(tlno from 4  for length(tlno)-7),"-", substring(tlno from -4 for 4)) as 전화번호 
from USED_GOODS_USER
where USER_ID in (
    SELECT writer_id from 
    USED_GOODS_BOARD board
    group by writer_id
    having count(*) >= 3
)
order by user_id desc
