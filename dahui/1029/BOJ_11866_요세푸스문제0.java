package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_11866_요세푸스문제0 {
	static int K,N;
	static Deque<Integer> dq = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			dq.add(i);
		}
		sb.append("<");
		
		while(dq.size() > 1) {
			for(int i = 0; i < K - 1; i++) {
				dq.offer(dq.poll());
			}
			
			sb.append(dq.poll()).append(", ");
		}
		
		sb.append(dq.poll()).append(">");
		System.out.println(sb);
	
	}

}
