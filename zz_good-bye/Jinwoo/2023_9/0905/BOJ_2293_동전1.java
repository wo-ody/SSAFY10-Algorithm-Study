import java.io.*;
import java.util.*;
public class BOJ_2293_동전1 {
	static long[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		for (int i=0; i<n; i++) coins[i] = Integer.parseInt(br.readLine());
		
		dp = new long[k+1];
		dp[0] = 1;
		
		for (int coin : coins) {
			for (int i=1; i<=k; i++) {
				if (i-coin >=0) dp[i] += dp[i-coin];
			}
		}
		System.out.println(dp[k]);
	} // main

}
