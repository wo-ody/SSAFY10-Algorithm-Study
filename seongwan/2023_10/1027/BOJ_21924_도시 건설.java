import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static long before, after;
	static StringTokenizer st;
	static List<int[]>[] edge;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edge = new List[N + 1];
		visit = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			edge[i] = new ArrayList<>();
		} // 간선리스트 초기화
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edge[from].add(new int[] { to, cost });
			edge[to].add(new int[] { from, cost });
			before += cost;
		} // 간선리스트 입력

		prim();

	}

	static void prim() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
		int cnt = 0;
		pq.add(new int[] { 1, 0 });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int to = cur[0];
			if (visit[to])
				continue;
			int cost = cur[1];
			cnt++;
			after += cost;
			if (cnt == N) {
				System.out.println(before - after);
				return;
			}
			visit[to] = true;
			for (int[] next : edge[to]) {
				if (!visit[next[0]])
					pq.add(next);
			}
		}
		System.out.println(-1);
	}

}