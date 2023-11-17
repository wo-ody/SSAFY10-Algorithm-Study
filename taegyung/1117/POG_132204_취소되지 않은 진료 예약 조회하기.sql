-- 코드를 입력하세요
-- PATIENT, DOCTOR 그리고 APPOINTMENT 테이블에서 2022년 4월 13일 취소되지 않은 흉부외과(CS) 진료 예약 내역을 조회하는 SQL문을 작성해주세요. 진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시 항목이 출력되도록 작성해주세요. 결과는 진료예약일시를 기준으로 오름차순 정렬해주세요.
SELECT APPOINTMENT.APNT_NO,PATIENT.PT_NAME,PATIENT.PT_NO,APPOINTMENT.MCDP_CD,doctor.DR_NAME,APPOINTMENT.APNT_YMD
from APPOINTMENT join doctor
on APPOINTMENT.MDDR_ID = doctor.DR_ID
join PATIENT on APPOINTMENT.PT_NO = PATIENT.PT_NO
where apnt_cncl_yn = 'N'
and apnt_ymd like "2022-04-13%"
and APPOINTMENT.MCDP_CD = "CS"
order by appointment.APNT_YMD
