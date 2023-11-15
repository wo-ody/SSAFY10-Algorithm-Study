-- 코드를 입력하세요
SELECT distinct car.car_id
from CAR_RENTAL_COMPANY_CAR car join CAR_RENTAL_COMPANY_RENTAL_HISTORY history
on car.car_id = history.car_id
where history.start_date like "2022-10-%"
and car.car_type = '세단'
order by car.car_id desc
