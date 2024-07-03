import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int max = 101;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int content = Integer.parseInt(st.nextToken());
            for (int j = K; j >= content; j--) {
                dp[j] = Math.min(dp[j], dp[j - content] + 1);
            }
        }

        System.out.println(dp[K] == 101 ? -1 : dp[K]);
    }
}