package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_수들의합2 {
	static int N,M,cnt;
	static int[] input;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		input = new int[N];
		
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int sIdx = 0;
		int eIdx = 0;
		int sum = 0;
		
		while(true) {
			if(sum >= M) {
				sum -= input[sIdx++];
			}else if(eIdx == N){
				break;
			}else {
				sum += input[eIdx++];
			}
			if(sum == M) cnt++;
		}
		System.out.println(cnt);
	}

}
