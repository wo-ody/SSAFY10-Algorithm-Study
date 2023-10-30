import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[] exit;
	static boolean[] visit;
	static List<int[]>[] adlist;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N + 1];
		adlist = new List[N + 1];
		exit = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			adlist[i] = new ArrayList<>();
		} // 인접리스트 pq로 초기화

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			adlist[from].add(new int[] { to, cost });
			adlist[to].add(new int[] { from, cost });
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			exit[i] = Integer.parseInt(st.nextToken());
		}

		prim();
	}

	static void prim() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
		int cnt = 0, ans = 0;
		for (int i = 1; i <= N; i++) {
			pq.add(new int[] { i, exit[i] });
		}
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int to = cur[0];
			if (visit[to])
				continue;
			int cost = cur[1];
			cnt++;
			ans += cost;
			if (cnt == N)
				System.out.println(ans);
			visit[to] = true;
			for (int[] next : adlist[to]) {
				if (!visit[next[0]])
					pq.add(next);
			}
		}
	}

}