import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int m, n, before, after;
	static boolean[] visit;
	static List<int[]>[] edge;

	public static void main(String[] args) throws Exception {
		while (true) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if (m == 0)
				break;
			before = 0;
			after = 0;// 초기화
			visit = new boolean[m];
			edge = new List[m];
			for (int i = 0; i < m; i++) {
				edge[i] = new ArrayList<>();
			}

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				edge[from].add(new int[] { to, cost });
				edge[to].add(new int[] { from, cost });
				before += cost;
			}
			prim();
			sb.append(before - after + "\n");
		}
		System.out.println(sb);
	}

	static void prim() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
		pq.add(new int[] { 0, 0 });
		int cnt = 0;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int to = cur[0];
			if (visit[to])
				continue;// 방문했던 정점이라면 무시
			int cost = cur[1];
			cnt++;
			after += cost;
			if (cnt == m) {
				return;
			}
			visit[to] = true;
			for (int[] next : edge[to]) {
				int nextn = next[0];
				if (!visit[nextn])
					pq.add(new int[] { nextn, next[1] });
			}
		}
	}
}