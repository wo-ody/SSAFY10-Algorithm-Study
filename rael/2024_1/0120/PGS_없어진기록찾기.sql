-- 코드를 입력하세요
SELECT ao.animal_id, ao.name
FROM ANIMAL_INS as ai
RIGHT JOIN ANIMAL_OUTS as ao
ON ai.animal_id = ao.animal_id
where ai.animal_id is null
order by ao.animal_id;
