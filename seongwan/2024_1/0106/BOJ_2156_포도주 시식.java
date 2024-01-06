import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, ans;
    static int[] input, dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        input = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }//포도주의 양 입력

        dp[1] = input[1];
        ans = dp[1];
        if (N >= 2) {
            dp[2] = input[1] + input[2];
            ans = dp[2];
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(input[i] + dp[i - 2], input[i] + input[i - 1] + dp[i - 3]);
            //i를 고르고 i-1번째를 고르지 않는 경우와
            //i와 i-1을 고르고 i-2번째를 고르지 않는 경우 중 최대를 구함
            dp[i] = Math.max(dp[i], dp[i - 1]);
            //최대로 갱신
        }
        System.out.println(dp[N]);
    }
}