package report;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11055_가장큰증가하는부분수열 {
	static int N, max;
	static int[] input;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		dp = new int[N]; // 각 자리수까지의 가장 큰 증가하는 부분수열의 합을 담
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			dp[i] = input[i]; //우선 자기자신은 다 넣어주기 
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(input[j] < input[i] && dp[j] + input[i] > dp[i]) {
					dp[i] = dp[j] + input[i];
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}
