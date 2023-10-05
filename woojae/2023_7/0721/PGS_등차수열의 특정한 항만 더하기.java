class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int len = included.length;
        int[] arr = new int[len];  // 초기화된 배열 객체 생성
        for (int i = 0; i < len; i++) {
            arr[i] = (i == 0) ? a : arr[i-1] + d;  // 초항이면 a, 아니라면 이전 항 + 공차
            answer += (included[i]) ? arr[i] : 0;  // 현재 항이 true라면 answer에 누적
        }
        return answer;
    }
}
