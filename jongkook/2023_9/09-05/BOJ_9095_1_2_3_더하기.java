package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_1_2_3_더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= 11; i++) dp[i] = dp[i-1] + dp[i-2] + dp[i-3];

        for(int i = 0; i < T; i++){
            int index = Integer.parseInt(br.readLine());
            System.out.println(dp[index]);
        }
    }
}
