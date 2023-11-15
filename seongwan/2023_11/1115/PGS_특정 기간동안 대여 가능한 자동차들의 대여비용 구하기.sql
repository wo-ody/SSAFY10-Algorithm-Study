SELECT distinct c.CAR_ID,c.CAR_TYPE,floor(c.daily_fee*30*((100-p.DISCOUNT_RATE)/100)) FEE from CAR_RENTAL_COMPANY_CAR c 
join (select car_id,max(end_date) end_date from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID) h using(car_id)
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p using(car_type)
where c.car_type in('세단','SUV') and h.END_DATE<20221101 and DURATION_TYPE='30일 이상' 
and c.daily_fee*30*((100-p.DISCOUNT_RATE)/100)>=500000 and c.daily_fee*30*((100-p.DISCOUNT_RATE)/100)<2000000
ORDER BY FEE DESC,CAR_TYPE ASC,CAR_ID DESC
