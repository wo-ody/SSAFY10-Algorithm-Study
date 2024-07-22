import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static StringTokenizer st;
    static int[][] input, dp;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        input = new int[N][3];
        dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[0], Integer.MAX_VALUE / 2);
            dp[0][i] = input[0][i];

            for (int j = 1; j < N; j++) {
                dp[j][0] = input[j][0] + Math.min(dp[j - 1][1], dp[j - 1][2]);
                dp[j][1] = input[j][1] + Math.min(dp[j - 1][0], dp[j - 1][2]);
                dp[j][2] = input[j][2] + Math.min(dp[j - 1][0], dp[j - 1][1]);
            }

            for (int j = 0; j < 3; j++) {
                if (i == j)
                    continue;

                ans = Math.min(ans, dp[N - 1][j]);
            }
        }

        System.out.println(ans);
    }
}