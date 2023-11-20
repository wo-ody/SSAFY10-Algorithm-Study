# 20231120

* 오늘 한 것
  * Pagination 완성
    * 도시 및 구군 정보 변경에 따른  index 및 offset 초기화
  * 카카오맵 라이브러리 추가 작업 진행 중
  * Troubleshooting
    * 데이터 검색 요청이 두 번 발생하는 문제
      * @click.prevent를 사용하여 이벤트 전파를 막으면 기본 동작 제어, 
      * 기본 동작을 제어했으므로 이벤트 핸들러를 통해 수동으로 v-model 갱신
      *  v-model 로 바인딩되면 해당 값이 변경될 때마다 v-model이 자동으로 갱신되어야 하는데 기본 동작이 제어당하므로 불가능