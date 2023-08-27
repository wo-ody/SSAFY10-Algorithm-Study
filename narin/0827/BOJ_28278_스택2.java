import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());

			switch (order) {
			case 1:
				int x = Integer.parseInt(st.nextToken());
				stack.push(x);
				break;
			case 2:
				if (!stack.isEmpty()) {
					sb.append(stack.pop() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
				break;
			case 3:
				sb.append(stack.size() + "\n");
				break;
			case 4:
				if (!stack.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(1 + "\n");
				}
				break;
			case 5:
				if (!stack.isEmpty()) {
					sb.append(stack.peek() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}
}
