SELECT COUNT(*) COUNT
FROM ECOLI_DATA
WHERE !(GENOTYPE & 2) AND (GENOTYPE & 5)
# AND 연산을 이용해 비트의 유무를 확인 -> 있다면 0이 아닌 True
