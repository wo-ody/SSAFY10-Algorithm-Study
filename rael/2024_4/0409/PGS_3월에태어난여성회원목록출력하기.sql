-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE TLNO <> 'NULL' AND DATE_OF_BIRTH LIKE '____-03-__' AND GENDER = 'W'
ORDER BY MEMBER_ID;
