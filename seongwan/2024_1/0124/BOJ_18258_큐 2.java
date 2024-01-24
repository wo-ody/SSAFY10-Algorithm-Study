import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//덱을 가지고 시키는 대로 하면 될 거 같음
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> queue = new ArrayDeque<>();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			// push
			if (cmd.equals("push")) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			// pop
			else if (cmd.equals("pop")) {
				if (queue.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(queue.poll() + "\n");
				}
			}
			// size
			else if (cmd.equals("size")) {
				sb.append(queue.size() + "\n");
			}
			// empty
			else if (cmd.equals("empty")) {
				sb.append((queue.isEmpty() ? 1 : 0) + "\n");
			}
			// front
			else if (cmd.equals("front")) {
				if (queue.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(queue.peek() + "\n");
				}
			}
			// back
			else if (cmd.equals("back")) {
				if (queue.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(queue.peekLast() + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}