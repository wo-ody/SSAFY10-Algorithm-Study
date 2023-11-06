import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정 {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // 끝시간 기준으로 오름차순 정렬 (끝시간이 같다면 시작시간 오름차순)
        Arrays.sort(arr, (e1, e2) -> e1[1] == e2[1] ? e1[0] - e2[0] : e1[1] - e2[1]);
        int ans = 0;

        // 회의실을 사용한 0번째 회의 개수추가
        int end = arr[0][1];
        ans++;

        // 그 다음부터
        for (int i = 1; i < N; i++) {
            if (end <= arr[i][0]) { // 만약 끝시간보다 첫시간이 더 나중이거나 같으면 회의 개수 추가
                end = arr[i][1]; // 회의 끝시간 업데이트
                ans++; // 개수 세기
            }
        }
        System.out.println(ans);
    }
}
