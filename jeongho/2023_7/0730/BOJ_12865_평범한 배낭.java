package algorithm2023.jul.day30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_BOJ12865 {
	static int N, K, knapsack[][], dp[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		knapsack = new int[N][2];
		dp = new int[K+1];
		
		for(int i = 0;i<N;i++) {
			s = br.readLine().split(" ");
			knapsack[i][0] = Integer.parseInt(s[0]);
			knapsack[i][1] = Integer.parseInt(s[1]);
		}
		
		for(int i= 0;i<N;i++) {
			int W = knapsack[i][0];
			int V = knapsack[i][1];
			for(int j = K;j>=W;j--) {
				dp[j] = Math.max(dp[j], dp[j-W]+V);
			}
		}
		System.out.println(dp[K]);
	}
}
