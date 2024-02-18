package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_10886_덱 {
	static int N, num;
	static Deque<Integer> dq = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			switch(str) {
			case "push_front" :
				num = Integer.parseInt(st.nextToken());
				dq.addFirst(num);
				break;
				
			case "push_back" :
				num = Integer.parseInt(st.nextToken());
				dq.addLast(num);
				break;
				 
			case "pop_front" :
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.pollFirst()).append("\n");
				break;
				
			case "pop_back" :
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.pollLast()).append("\n");
				break;
				
			case "size" :
				sb.append(dq.size()).append("\n");
				break;
				
			case "empty" :
				if(dq.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
				
			case "front" :
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.peekFirst()).append("\n");
				break;
				
			case "back" :
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.peekLast()).append("\n");
				break;
			}
			
		}
		System.out.println(sb);
	}

}
