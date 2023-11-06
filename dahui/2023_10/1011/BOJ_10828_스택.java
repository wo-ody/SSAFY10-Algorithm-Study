package alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> stack = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}else if(str.equals("top")){
				if(!stack.isEmpty()) {
					sb.append(stack.peek()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
			}else if(str.equals("pop")) {
				if(!stack.isEmpty()) {
					sb.append(stack.pop()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
			}else if(str.equals("size")) {
				sb.append(stack.size()).append("\n");
			}else {
				sb.append(stack.isEmpty()?1:0).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}

}
