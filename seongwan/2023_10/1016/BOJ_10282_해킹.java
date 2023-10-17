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
	static List<int[]>[] adlist;
	static int T, n, d, c, cnt;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			cnt = 0;

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			adlist = new List[n + 1];// 0은 더미
			visit = new boolean[n + 1];

			for (int i = 1; i <= n; i++) {
				adlist[i] = new ArrayList<>();
			} // 인접리스트 초기화

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				adlist[from].add(new int[] { to, w });
			} // 인접리스트 입력

			dijk();
		}
		System.out.println(sb);

	}

	static void dijk() {
		int cost = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
		pq.add(new int[] { c, 0 });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int from = cur[0];
			if (!visit[from]) {
				cost = cur[1];
				visit[from] = true;
				cnt++;
				for (int[] next : adlist[from]) {
					int to = next[0];
					int ncost = next[1];
					if (!visit[to])
						pq.add(new int[] { to, cost + ncost });
				}
			}
		}
		sb.append(cnt + " " + cost + "\n");

	}

}