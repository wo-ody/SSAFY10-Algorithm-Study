import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_28278_스택2 {
	public static void main(String[] args) throws Exception{
		Stack<Integer> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			switch (num) {
				case 1 :
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case 2:
					sb.append(stack.isEmpty()?-1:stack.pop()).append("\n");
					break;
				case 3:
					sb.append(stack.size()).append("\n");
					break;
				case 4:
					sb.append(stack.isEmpty()?1:0).append("\n");
					break;
				case 5:
					sb.append(stack.isEmpty()?-1:stack.peek()).append("\n");
					break;
			}
		}
		System.out.println(sb);
	}
}
