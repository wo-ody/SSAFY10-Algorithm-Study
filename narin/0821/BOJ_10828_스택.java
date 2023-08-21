import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();

			switch (order) {
			case "push":
				int X = Integer.parseInt(st.nextToken());
				stack.push(X);
				break;
			case "pop":
				if (!stack.isEmpty()) {
					System.out.println(stack.pop());
				} else {
					System.out.println(-1);
				}
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if (stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "top":
				if (!stack.isEmpty()) {
					System.out.println(stack.peek());
				} else {
					System.out.println(-1);
				}
				break;
			}
		}
	}
}
