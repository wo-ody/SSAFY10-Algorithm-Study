package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20922_겹치는건싫어 {
	static int N,K,ans;
	static int[] input, num;
	static Queue<Integer> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		num = new int[100001]; //각 숫자의 개수를 담을 배열
		input = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			q.add(input[i]);
			num[input[i]]++;
			
			if(num[input[i]] == K+1) { 
				ans = Math.max(ans, q.size()-1);
				
				while(true) {
					int a = q.poll();
					num[a]--;
					if(a == input[i]) {
						break;
					}
				}
			}
		}
		
		ans = Math.max(ans, q.size());
		
		System.out.println(ans);
	}

}
