package algorithm2023.sep.day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17404_RGB거리2 {
	static int N, cost[][], dp[][], ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		dp = new int[N][3];
		ans = Integer.MAX_VALUE;
		for(int i =0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j= 0;j<3;j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		dp[0][0] = 100000;
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		
		for(int i = 1;i<N;i++) {
			dp[i][0] = cost[i][0]+Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = cost[i][1]+Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = cost[i][2]+Math.min(dp[i-1][1], dp[i-1][0]);
		}
		ans = Math.min(ans, dp[N-1][0]);
		
		dp[0][0] = cost[0][0];
		dp[0][1] = 1000000;
		dp[0][2] = cost[0][2];
		
		for(int i = 1;i<N;i++) {
			dp[i][0] = cost[i][0]+Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = cost[i][1]+Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = cost[i][2]+Math.min(dp[i-1][1], dp[i-1][0]);
		}
		
		ans = Math.min(ans, dp[N-1][1]);
		
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = 1000000;
		
		for(int i = 1;i<N;i++) {
			dp[i][0] = cost[i][0]+Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = cost[i][1]+Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = cost[i][2]+Math.min(dp[i-1][1], dp[i-1][0]);
		}
		
		ans = Math.min(ans, dp[N-1][2]);
		
		System.out.println(ans);
	}
}
