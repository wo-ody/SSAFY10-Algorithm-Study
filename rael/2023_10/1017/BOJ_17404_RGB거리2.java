import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17404_RGB거리2_DP {
    static int N, ans;
    static int[][] map;
    static int[][] dp;
    static final int INF = 1001*1001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][3];     //0 dummy
        dp = new int[N+1][3];       //0 dummy

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = INF;

        // 첫 번째 집을 빨강, 초록, 파랑 중 하나로 고정
        for (int k = 0; k < 3; k++) {
            //시작 색 바르기 - 안 발랐다면 INF로 지정하여 최소 구하도록
            for (int i = 0; i < 3; i++) {
                if (i == k) dp[1][i] = map[1][i];
                else dp[1][i] = INF;
            }

            //0은 dummy, 1은 초기값 저장
            for (int i = 2; i <= N; i++) {
                dp[i][0] = map[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = map[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = map[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }

            for (int i = 0; i < 3; i++) {
                if (i == k) continue;
                ans = Math.min(ans, dp[N][i]);
            }
        }

        System.out.println(ans);
    }
}
