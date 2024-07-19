import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] matrix;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        matrix = new int[N][2];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            //행렬별 행과 열 입력
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int term = 1; term < N; term++) {
            for (int i = 0; i < N - term; i++) {
                int j = i + term;

                if (term == 1) {
                    dp[i][j] = matrix[i][0] * matrix[i][1] * matrix[j][1];
                    continue;
                }

                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1]);
                }
            }
        }

        System.out.println(dp[0][N - 1]);
    }
}