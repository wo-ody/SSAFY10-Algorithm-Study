package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2839_설탕배달 {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+10];

        dp[3] = 1;
        dp[5] = 1;
        for (int i = 3; i <= N; i++) {
            if(dp[i] == 0) continue;
            if(dp[i + 3] == 0) dp[i + 3] = dp[i] + 1;
            else dp[i + 3] = Math.min(dp[i+3] , dp[i] + 1);

            if(dp[i + 5] == 0) dp[i + 5] = dp[i] + 1;
            else dp[i + 5] = Math.min(dp[i+5] , dp[i] + 1);
        }

        if(dp[N] == 0) System.out.println(-1);
        else System.out.println(dp[N]);


    }
}
