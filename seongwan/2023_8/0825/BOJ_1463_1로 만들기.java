import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, depth;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		bfs();
		System.out.println(depth);
	}

	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(N);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				if (cur == 1)
					return;
				if (cur % 3 == 0) {
					int nr = cur / 3;
					queue.add(nr);
				}
				if (cur % 2 == 0) {
					int nr = cur / 2;
					queue.add(nr);
				}
				int nr = cur - 1;
				queue.add(nr);

			}
			depth++;

		}

	}//3가지 연산으로 1로 갈 수 있는 최단 루트를 구함
}
