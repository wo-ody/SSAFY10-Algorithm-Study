SELECT ANIMAL_ID, ANIMAL_TYPE,NAME
FROM ANIMAL_INS
WHERE SEX_UPON_INTAKE LIKE '%Intact%'
INTERSECT
SELECT ANIMAL_ID, ANIMAL_TYPE,NAME
FROM ANIMAL_OUTS
WHERE SEX_UPON_OUTCOME LIKE '%Spayed%' OR SEX_UPON_OUTCOME LIKE '%Neutered%';
