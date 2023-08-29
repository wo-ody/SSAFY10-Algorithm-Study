package bj.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15989_123더하기4 {
	static int T, n;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		dp = new int[10001][4];
		dp[1][1] = 1;
		dp[1][2] = 0;
		dp[1][3] = 0;
		
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[2][3] = 0;
		
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		for (int i = 4; i <= 10000; i++) {
			dp[i][1] = dp[i - 1][1];
			dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
			dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
		}
		
		for (int i = 0; i < T; i++) {
			int s = Integer.parseInt(br.readLine());
			int sum = dp[s][1] + dp[s][2] + dp[s][3];
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
