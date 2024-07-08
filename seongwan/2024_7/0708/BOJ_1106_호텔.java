import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[C + 101];
        Arrays.fill(dp, 10000000);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int upCount = Integer.parseInt(st.nextToken());

            for (int j = upCount; j <= C + 100; j++) {
                dp[j] = Math.min(dp[j], dp[j - upCount] + price);
            }
        }

        int ans = 10000000;
        for (int j = C; j <= C + 100; j++) {
            ans = Math.min(ans, dp[j]);
        }

        System.out.println(ans);
    }
}
