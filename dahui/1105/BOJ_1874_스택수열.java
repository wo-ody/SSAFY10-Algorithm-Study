package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_1874_스택수열 {
	static int N;
	static Deque<Integer> stack = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int stackIndex = 1;
		
		while( N >= 1 ) {
			int num = Integer.parseInt(br.readLine());
			
			while(stackIndex <= num) {
				stack.push(stackIndex++);
				sb.append("+\n");
			}
			
			if(num != stack.pop()) {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
			
			sb.append("-\n");
			
			N--;
		}
		
		System.out.println(sb);
		
	}
}
