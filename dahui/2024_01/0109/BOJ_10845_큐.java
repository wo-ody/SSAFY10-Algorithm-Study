package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_10845_큐 {
	static int N;
	static Deque<Integer> q = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push")) {
				q.add(Integer.parseInt(st.nextToken()));
			}else if(str.equals("pop")) {
				if(!q.isEmpty()) {
					sb.append(q.pop()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
			}else if(str.equals("size")) {
				sb.append(q.size()).append("\n");
			}else if(str.equals("empty")) {
				if(q.isEmpty()) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}else if(str.equals("front")) {
				if(!q.isEmpty()) {
					int num = q.pop();
					sb.append(num).append("\n");
					q.addFirst(num);
				}else {
					sb.append(-1).append("\n");
				}
			}else {
				if(!q.isEmpty()) {
					int num = q.pollLast();
					sb.append(num).append("\n");
					q.add(num);
				}else {
					sb.append(-1).append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}
