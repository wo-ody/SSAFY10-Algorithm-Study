* 오늘 한 것
  * 카카오맵 라이브러리 추가 완료
  * 세부적인 부분 조정
    * 북마크 로그인 여부 판단 추가
      * bookmarkValidate 수정
        * 반환 타입 boolean -> int
          * -1: 세션 확인 실패
          * 0: 삭제 요청
          *  1: 등록 요청
    * 템플릿 수정 과정에서 기존 태그가 상실돼서 발생하는 에러 해결
      * try - catch를 이용해 동작 강제 수행 후, 에러 발생시 throw
    * 사이트 통일을 위한 alert 전역 메시지 추가
    * 최종 Pagination 적용
    * footer 하단 고정에 따른 footer 겹침 문제 해결
    * 회원가입 및 정보 수정 유효성 체크 보완
      * 이름 입력시 공백 미포함 한글만 입력받도록 설정
      * 정보 수정시 페이지 진입 후 기본값 false에서 랜더링 과정에서 체크해서 갱신하도록 변경
