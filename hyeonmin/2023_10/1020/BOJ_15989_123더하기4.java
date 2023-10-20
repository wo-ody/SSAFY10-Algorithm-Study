package month10.day20;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15989_123더하기4 {

	static int T, ans;
	static int[] dp = new int[10001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for (int i = 4; i < 10001; i++) {
			dp[i] = 1 + (i / 2) + dp[i-3];
		}
		
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}
		
		System.out.println(sb);
	}
}
