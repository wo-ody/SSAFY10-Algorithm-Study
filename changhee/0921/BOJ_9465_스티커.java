import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][N];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[3][N];  //0: left, 1: right, 2: none
            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];
            dp[2][0] = 0;

            for (int i = 1; i < N; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], +dp[2][i - 1]) + stickers[1][i];
                dp[2][i] = Math.max(dp[0][i - 1], Math.max(dp[1][i - 1], dp[2][i - 1]));
            }
            answer.append(Math.max(Math.max(dp[0][N - 1], dp[1][N - 1]), dp[2][N - 1])).append("\n");
        }
        System.out.println(answer.toString());
    }
}
