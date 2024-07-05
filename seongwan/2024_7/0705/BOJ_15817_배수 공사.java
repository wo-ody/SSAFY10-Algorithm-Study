import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            for (int k = x; k >= 0; k--) {
                for (int j = 1; j <= count; j++) {
                    int multiL = L * j;

                    if (k - multiL < 0)
                        break;
                    
                    dp[k] += dp[k - multiL];
                }
            }
        }
        System.out.println(dp[x]);
    }
}