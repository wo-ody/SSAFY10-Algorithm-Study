package bj.S2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_스택수열 {
	static int n, start;
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			int val = Integer.parseInt(br.readLine());
			
			if (val > start) {
				for (int i = start + 1; i <= val; i++) {
					stack.push(i);
					sb.append("+").append("\n");
				}
				start = val;
			}
			else if (stack.peek() != val) {
				sb = new StringBuilder();
				sb.append("NO");
				break;
			}
			
			stack.pop();
			sb.append("-").append("\n");
		}

		System.out.println(sb);
	}
}
