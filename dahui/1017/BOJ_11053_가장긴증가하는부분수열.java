package alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열 {
	static int N, ans;
	static int[] input,dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		input = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			dp[i] = 1;
			
			for(int j=0; j<i; j++) {
				if(input[i] > input[j] && dp[j]+1 > dp[i]) {
					dp[i] = dp[j]+1;
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);

	}

}
