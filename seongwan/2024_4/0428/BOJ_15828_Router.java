import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static Deque<Integer> queue = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		while (true) {
			int temp = Integer.parseInt(br.readLine());

			if (temp == -1)
				break;

			if (temp == 0)
				queue.poll();
			else {
				if (queue.size() >= N)
					continue;
				queue.add(temp);
			}
		}
		if (queue.isEmpty())
			sb.append("empty");
		else {
			for (Integer i : queue) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}
}