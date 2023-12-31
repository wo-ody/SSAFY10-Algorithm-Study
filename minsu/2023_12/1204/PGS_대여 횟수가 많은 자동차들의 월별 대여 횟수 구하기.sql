SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(HISTORY_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE month(start_date) >= 8 AND month(start_date) < 11 AND
    CAR_ID IN 
    (SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    WHERE month(start_date) >= 8 AND month(start_date) < 11
    GROUP BY CAR_ID
    HAVING COUNT(CAR_ID) >= 5)
GROUP BY MONTH, CAR_ID
HAVING RECORDS > 0
ORDER BY MONTH ASC, CAR_ID DESC
