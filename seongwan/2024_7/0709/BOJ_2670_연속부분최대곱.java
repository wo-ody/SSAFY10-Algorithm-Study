import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double[] dp = new double[N];
        dp[0] = Double.parseDouble(br.readLine());
        double ans = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Double.parseDouble(br.readLine());
            dp[i] = Math.max(dp[i], dp[i - 1] * dp[i]);
            ans = Math.max(ans, dp[i]);
        }

        System.out.printf("%.3f", ans);
    }
}
