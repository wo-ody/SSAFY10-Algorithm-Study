package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16564_히오스프로게이머 {
	static int N, K, ans;
	static int[] level, diff;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		level = new int[N];
		
		for(int i=0; i<N; i++) {
			level[i] = Integer.parseInt(br.readLine());
		}
		
		if(N==1) {
			System.out.println(level[0] + K);
		}else {
			Arrays.sort(level);
			diff = new int[N-1];
			
			int idx = 1;
			diff[0] = (level[1] - level[0])*idx++;
			for(int i=1; i<N-1; i++) {
				diff[i] = diff[i-1]+(level[i+1] - level[i])*idx++;
			}
			
			int a = 0;
			for(int i=0; ;i++) {
				if(diff[i] >= K) {
					a = i-1;
					break;
				}
				
				if(i == N-2) {
					a = i;
					break;
				}
			}
			
			if(a != -1) {
				if(K-diff[a] == 0) {
					ans = level[a+1];
				}else {
					ans = level[a+1] + (K-diff[a])/(a+2);
				}
			}else {
				ans = level[0] + K;
			}
			
			System.out.println(ans);
		}
		
	}

}
