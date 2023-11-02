import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T, N, M, p, q;
	static List<int[]>[] adlist;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());

			adlist = new List[N + 1];
			visit = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				adlist[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				adlist[from].add(new int[] { to, cost });
				adlist[to].add(new int[] { from, cost });
			}
			prim();
		}

	}

	static void prim() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
		int cnt = 0;
		pq.add(new int[] { 1, 0, 0 });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int to = cur[0];
			if (visit[to])
				continue;
			int from = cur[2];
			if ((from == p && to == q) || (from == q && to == p)) {
				// 해당 경로가 최단 경로에 포함된다면
				System.out.println("YES");
				return;
			}
			cnt++;
			if (cnt == N) {// 해당 경로가 포함되지 않은 채 mst를 구한다면
				System.out.println("NO");
				return;
			}
			visit[to] = true;
			for (int[] next : adlist[to]) {
				if (visit[next[0]])
					continue;
				pq.add(new int[] { next[0], next[1], to });
			}
		}
	}
}