public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t, n, m, coin;
        int[] coins, dp;
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            coins = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }
            m = Integer.parseInt(br.readLine());

            // DP
            dp = new int[m + 1];
            dp[0] = 1;
            for (int j = 0; j < n; j++) {
                coin = coins[j];
                for (int k = coin; k <= m; k++) {
                    dp[k] += dp[k - coin];
                }
            }
            sb.append(dp[m]).append(lineSeparator());
        }

        System.out.println(sb);
    }
}
