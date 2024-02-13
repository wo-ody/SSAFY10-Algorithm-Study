import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//덱을 이용해서 시키는 대로...
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				deque.addFirst(Integer.parseInt(st.nextToken()));
			} else if (cmd == 2) {
				deque.add(Integer.parseInt(st.nextToken()));
			} else if (cmd == 3) {
				if (deque.isEmpty())
					sb.append(-1 + "\n");
				else
					sb.append(deque.poll() + "\n");
			} else if (cmd == 4) {
				if (deque.isEmpty())
					sb.append(-1 + "\n");
				else
					sb.append(deque.pollLast() + "\n");
			} else if (cmd == 5) {
				sb.append(deque.size() + "\n");
			} else if (cmd == 6) {
				if (deque.isEmpty())
					sb.append(1 + "\n");
				else
					sb.append(0 + "\n");
			} else if (cmd == 7) {
				if (deque.isEmpty())
					sb.append(-1 + "\n");
				else
					sb.append(deque.peek() + "\n");
			} else if (cmd == 8) {
				if (deque.isEmpty())
					sb.append(-1 + "\n");
				else
					sb.append(deque.peekLast() + "\n");
			}
		}
		System.out.println(sb);
	}
}