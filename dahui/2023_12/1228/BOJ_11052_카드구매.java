package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052_카드구매하기 {
	static int[] dp, amount;
	static int N,ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		amount = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N ;i++) {
			amount[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = amount[1];
		
		for(int i=2; i<=N; i++) {
			dp[i] = amount[i];
			for(int j=1; j<=(i/2);j++) {
				dp[i] = Math.max(dp[j]+dp[i-j], dp[i]);
			}
		}
		
		System.out.println(dp[N]);

	}

}
