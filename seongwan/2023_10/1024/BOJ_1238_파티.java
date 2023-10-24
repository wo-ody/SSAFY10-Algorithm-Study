import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, X, ans[];
	static List<int[]>[] adlist;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		adlist = new List[N + 1];
		ans = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			adlist[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adlist[from].add(new int[] { to, cost });
		}

		for (int i = 1; i <= N; i++) {
			if (i == X)
				continue;
			dijk(i, X);
			dijk(X, i);
		}
		Arrays.sort(ans);
		System.out.println(ans[N]);
	}

	static void dijk(int start, int end) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
		visit = new boolean[N + 1];
		pq.add(new int[] { start, 0 });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int from = cur[0];
			int cc = cur[1];
			if (from == end) {
				if (start == X)
					ans[end] += cc;
				else
					ans[start] = cc;
				return;
			}
			visit[from] = true;// 방문 처리
			for (int[] next : adlist[from]) {
				int to = next[0];
				int cost = next[1];
				if (!visit[to])
					pq.add(new int[] { to, cc + cost });
			}
		}
	}

}