package boj;

import java.util.*;
import java.io.*;

public class BOJ_1003_피보나치_함수 {
	static int zero, one, dp[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp = new int[41][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for(int i = 2; i < 41; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}
		
		for(int t = 0; t < T; t++) {
			int idx = Integer.parseInt(br.readLine());
			System.out.println( dp[idx][0] +" " +dp[idx][1]);
		}
	}
}
