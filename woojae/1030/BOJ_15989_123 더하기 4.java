package practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_15989 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int t;

	static int[][] dp = new int[10001][4]; // 10000을 1, 2, 3순으로 만드는 법
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		dp[1][1]=1; // 1
		dp[2][1]=1; // 1 + 1
		dp[2][2]=1; // 2
		dp[3][1]=1; // 1 + 1 + 1
		dp[3][2]=1; // 1 + 2 -> 2 + 1은 안 됨 -> 모든 수는 오름차순의 형태만 허용
		dp[3][3]=1; // 3;
		
		for(int i = 4; i <= 10000; i++) {
			dp[i][1] = dp[i-1][1];
			dp[i][2] = dp[i-2][1] + dp[i-2][2];
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
		}
		t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n][1] + dp[n][2] + dp[n][3]).append("\n");
		}
		System.out.println(sb);
	}
}
