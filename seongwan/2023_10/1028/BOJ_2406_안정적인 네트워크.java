import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {// 1 을 제외한 나머지가 mst를 이루어야 함
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[][] connect;
	static int[][] mat;
	static boolean[] visit;
	static List<int[]> check = new ArrayList<>();// 연결된 간선 체크

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		connect = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			connect[i][0] = Integer.parseInt(st.nextToken());
			connect[i][1] = Integer.parseInt(st.nextToken());
		}

		mat = new int[n + 1][n + 1];
		visit = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 인접행렬 입력
		visit[1] = true;
		connect();// 연결되어 있는 정점끼리의 간선 가중치 0처리
		prim();
		System.out.println(sb);
	}

	static void prim() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
		int cnt = 0, ans = 0;
		pq.add(new int[] { 2, 0, 0 });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int to = cur[0];
			if (visit[to])
				continue;
			int cost = cur[1];
			ans += cost;
			cnt++;
			if (cost > 0)
				check.add(new int[] { to, cur[2] });
			if (cnt == n - 1) {
				sb.append(ans + " " + check.size() + "\n");
				for (int[] i : check) {
					sb.append(i[0] + " " + i[1] + "\n");
				}
				return;
			}
			visit[to] = true;
			for (int i = 1; i <= n; i++) {
				if (visit[i])
					continue;
				pq.add(new int[] { i, mat[to][i], to });
			}
		}
	}

	static void connect() {
		for (int i = 0; i < m; i++) {
			int from = connect[i][0];
			int to = connect[i][1];
			mat[from][to] = 0;
			mat[to][from] = 0;
		}

	}

}
