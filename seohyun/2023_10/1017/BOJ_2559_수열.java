package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2559_수열 {
	static int N,K;
	static int[] num;
	
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		num = new int[N];
		result = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += num[i];
		}
		result = Math.max(result, sum);
		
		for (int i = 1; i <= N - K; i++) {
			sum = sum - num[i-1] + num[i+K-1];
			result = Math.max(result, sum);
		}
		
		System.out.println(result);
		
	}

}
