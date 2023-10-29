import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K, start, ans;
	static List<int[]>[] adlist;
	static List<int[]>[] tree;

	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		adlist = new List[N];
		visit = new boolean[N];
		tree = new List[N];
		for (int i = 0; i < N; i++) {
			adlist[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adlist[from].add(new int[] { to, cost });
			adlist[to].add(new int[] { from, cost });
		} // 인접리스트 입력

		prim();
		for (int i = 0; i < N; i++) {
			if (tree[i].size() == 1) {
				start = i;
				visit = new boolean[N];
				visit[start] = true;
				dfs(start, 1, 0);

			}
		} // dfs 시작을 끝에 있는 노드에서 하기 위해 완성된 트리에서
			// 연결된 정점이 1개인 정점을 찾음
		System.out.println(ans);
	}

	static void dfs(int start, int cnt, int cost) {
		ans = Math.max(ans, cost);
		for (int[] next : tree[start]) {
			if (!visit[next[0]]) {
				visit[next[0]] = true;
				dfs(next[0], cnt + 1, cost + next[1]);
				visit[next[0]] = false;
			}
		}
	}

	static void prim() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
		int cnt = 0, ans = 0;
		pq.add(new int[] { 0, 0, -1 });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int to = cur[0];
			if (visit[to])
				continue;
			int cost = cur[1];
			int from = cur[2];
			cnt++;
			ans += cost;

			if (from != -1) {
				tree[to].add(new int[] { from, cost });
				tree[from].add(new int[] { to, cost });
			}
			if (cnt == N) {
				System.out.println(ans);
				return;
			}
			visit[to] = true;
			for (int[] next : adlist[to]) {
				if (!visit[next[0]])
					pq.add(new int[] { next[0], next[1], to });
			}
		}
	}
}