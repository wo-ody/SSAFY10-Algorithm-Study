import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] coins = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            int[][] dp = new int[N + 1][M + 1];

            for (int i = 1; i <= N; i++) {
                int coin = coins[i - 1];
                dp[i][0] = 1;

                for (int j = 1; j <= M; j++) {
                    if (coin > j) {
                        dp[i][j] = dp[i - 1][j];
                        continue;
                    }
                    
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
                }
            }

            sb.append(dp[N][M]).append("\n");
        }
        System.out.println(sb);
    }
}