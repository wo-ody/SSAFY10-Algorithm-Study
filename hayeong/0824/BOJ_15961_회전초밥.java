import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥 {
    static int N, d, k, c;
    static int[] arr;
    static int[] eaten;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 리스트 생성
        // N뒤에 k-1개를 더크게 잡아 연속된 경우를 모두 따질 수 있도록 해줌
        arr = new int[N + k - 1];
        // N개 입력
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 앞쪽 k-1개를 뒤쪽에 붙여줌
        for (int i = N; i < arr.length; i++) {
            arr[i] = arr[i - N];
        }

        // 초밥 개수별 먹은 횟수(방문여부) 체크를 위한 eaten배열
        eaten = new int[d + 1];
        eaten[c] += 1; // 쿠폰 초밥 먹었다고체크(따질 경우는 모두 연속된 초밥을 k개 먹은 경우이므로 먼저 서비스 초밥을 먹었다고 체크해둠)
        int max = 1; // 초밥 종류의 개수

        // 처음 k개
        for (int i = 0; i < k; i++) {
            if (eaten[arr[i]] == 0) { // 한번도 먹은적 없는 초밥이면
                max++; // 종류의 개수 늘림
            }
            eaten[arr[i]] += 1; // 먹었다고 체크
        }

        int start = 0;
        int end = k;

        // 슬라이딩 윈도우
        int result = max; // 한 윈도우에 대해 종류 개수 셀 변수
        for (int i = end; i < arr.length; i++) {
            // 앞쪽꺼 삭제
            eaten[arr[start]] -= 1; // 맨앞 초밥 삭제
            if (eaten[arr[start]] == 0) { // 삭제해서 하나도 없다면 종류도 줄여줌
                result--;
            }

            // 뒤쪽꺼 더하기
            if (eaten[arr[i]] == 0) { // 한번도 먹은적 없는 초밥이면 종류에 추가
                result++;
            }
            eaten[arr[i]] += 1;

            start++; // 앞쪽 인덱스 업데이트
            max = Math.max(max, result); // 현 윈도의 종류개수와 max중 큰걸로 업데이트
        }

        System.out.println(max);

    }
}
