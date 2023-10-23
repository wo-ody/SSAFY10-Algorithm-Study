import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class point {
		int to;
		int cost;
		List<Integer> route;

		public point(int to, int cost, List<Integer> route) {
			super();
			this.to = to;
			this.cost = cost;
			this.route = route;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m, start, end;
	static List<int[]>[] adlist;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		adlist = new List[n + 1];
		visit = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			adlist[i] = new ArrayList<>();
		} // 인접리스트 초기화

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adlist[from].add(new int[] { to, cost });
		} // 인접리스트 입력

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		dijk();
		System.out.println(sb);
	}

	static void dijk() {
		PriorityQueue<point> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
		pq.add(new point(start, 0, new ArrayList<>()));
		while (!pq.isEmpty()) {
			point cur = pq.poll();
			int from = cur.to;
			int cc = cur.cost;
			List<Integer> route = new ArrayList<>();
			route.addAll(cur.route);
			route.add(from);
			if (from == end) {
				sb.append(cc + "\n");
				sb.append(route.size() + "\n");
				for (int i : route) {
					sb.append(i + " ");
				}
				return;
			}
			visit[from] = true;
			for (int[] next : adlist[from]) {
				int to = next[0];
				int cost = next[1];
				if (!visit[to])
					pq.add(new point(to, cc + cost, route));
			}
		}

	}

}