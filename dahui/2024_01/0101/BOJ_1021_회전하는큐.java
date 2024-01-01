package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1021_회전하는큐 {
	static int N,M, ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Queue<Integer> dq = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			dq.add(i);
		}
		st = new StringTokenizer(br.readLine());
		int l = N;
		
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int cnt = 0;
			while(true) {
				int n = dq.poll();
				cnt++;
				
				if(n == num) {
					ans += Math.min(cnt-1, l-cnt+1);
					l--;
					break;
				}
				
				dq.add(n);
			}
		}
		
		System.out.println(ans);
		
	}

}
