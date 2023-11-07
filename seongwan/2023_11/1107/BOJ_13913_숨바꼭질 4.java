import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, K;
	static int[] visit;
	static StringBuilder sb = new StringBuilder();
	static int range;
	static Deque<Integer> stack = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		range = Math.max(2 * N + 1, 2 * K + 1);
		visit = new int[range];
		Arrays.fill(visit, -1);
		bfs();

		int cur = K;
		stack.add(cur);
		while (true) {
			if (cur == N)
				break;
			stack.push(visit[cur]);
			cur = visit[cur];
		}
		sb.append(stack.size() - 1 + "\n");
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}

		System.out.println(sb);

	}

	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(N);
		visit[N] = 0;
		while (!queue.isEmpty()) {
			int from = queue.poll();
			if (from == K) {
				return;
			}
			int next;
			if (N < K) {
				next = from + 1;
				if (cango(next)) {
					visit[next] = from;
					queue.add(next);
				}
			}
			next = from - 1;
			if (cango(next)) {
				visit[next] = from;
				queue.add(next);
			}

			if (N < K) {
				next = from * 2;
				if (cango(next)) {
					visit[next] = from;
					queue.add(next);
				}
			}
		}

	}

	static boolean cango(int x) {
		if (x >= 0 && x < range && visit[x] == -1)
			return true;
		return false;
	}

}