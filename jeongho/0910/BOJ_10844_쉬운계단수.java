package algorithm2023.sep.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10844_쉬운계단수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, dp[][];
	
	public static void main(String[] args) throws Exception{
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][10];
		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;
		for(int i = 2;i<=N;i++) {
			dp[i][0] = dp[i-1][1];
			dp[i][9] = dp[i-1][8];
			for(int j = 1;j<=8;j++) {
				dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1_000_000_000;
			}
		}
		int sum = 0;
		for(int i =0;i<=9;i++) {
			sum = (sum+dp[N][i])%1_000_000_000;
		}
		System.out.println(sum);
		
	}
}
