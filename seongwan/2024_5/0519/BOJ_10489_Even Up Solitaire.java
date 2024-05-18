import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> stack = new ArrayDeque<>();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());

			if (stack.isEmpty()) {
				stack.push(temp);
				continue;
			}

			if ((temp + stack.peek()) % 2 == 0) {
				stack.pop();
			} else {
				stack.push(temp);
			}
		}
		System.out.println(stack.size());
	}
}