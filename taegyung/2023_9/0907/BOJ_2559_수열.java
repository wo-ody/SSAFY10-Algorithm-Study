package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559_수열 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int [] arrDegree = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i ++) {
			arrDegree[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		
		int sum = 0;
		int max_sum = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < K ; i ++) {
			sum += arrDegree[end ++];
		}
		
		for(int i = 0 ; i < N-K ; i ++) {
			if (sum > max_sum) {
				max_sum = sum;
				
			}
			
			sum -= arrDegree[start++];
			sum += arrDegree[end++];
			
		}
		if (sum > max_sum) {
			max_sum = sum;
			
		}
		
		System.out.println(max_sum);
	}
}
