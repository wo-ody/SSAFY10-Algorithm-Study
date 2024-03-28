import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다익스트라로 가중치를 더해가며 가중치가 제일 작은 경우가 pq에서 나오게하면
//도착점에서는 최소의 가중치가 나옴
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int m, n;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dijk();
	}

	static void dijk() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[2] - e2[2]);
		boolean[][] visit = new boolean[m][n];
		if (map[0][0] == -1) {
			System.out.println(-1);
			return;
		}
		pq.add(new int[] {0, 0, map[0][0]});

		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			int cr = temp[0];
			int cc = temp[1];

			if (visit[cr][cc])
				continue;

			int cost = temp[2];

			if (cr == m - 1 && cc == n - 1) {
				System.out.println(cost);
				return;
			}

			visit[cr][cc] = true;

			for (int dir = 0; dir < 4; dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if (cango(nr, nc) && !visit[nr][nc]) {
					pq.add(new int[] {nr, nc, cost + map[nr][nc]});
				}
			}
		}
		System.out.println(-1);
	}

	static boolean cango(int r, int c) {
		return r >= 0 && r < m && c >= 0 && c < n && map[r][c] != -1;
	}
}