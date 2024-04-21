package algorithm2023.nov.day15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2637_줄세우기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, arr[], dp[];
	

	public static void main(String[] args) throws Exception {
		N =Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.fill(dp, 1);
		int max = 0;
		
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<i;j++) {
				if(arr[j]<arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(N-max);
	}

}