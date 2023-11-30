package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
    static int T, temp, max = Integer.MIN_VALUE;
    static int[][] counseling;
    static int[] dp;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        counseling = new int[T][T];
        dp = new int[T+1];
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            counseling[t][0] = Integer.parseInt(st.nextToken());
            counseling[t][1] = Integer.parseInt(st.nextToken());
        }
        // 걸리는 시간, 비용
        for(int t = 0; t < T; t++){
            int el = counseling[t][0] + t;
            if(el <= T) dp[el] = Math.max(dp[el], dp[t] + counseling[t][1]);

            dp[t+1] = Math.max(dp[t+1], dp[t]);
        }
        System.out.println(dp[T]);
    }
}
