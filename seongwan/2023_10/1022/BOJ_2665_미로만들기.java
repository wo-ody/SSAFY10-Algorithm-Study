import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		} // 맵 입력
		dijk();
	}

	static void dijk() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[2] - e2[2]);
		pq.add(new int[] { 0, 0, 0 });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cr = cur[0];
			int cc = cur[1];
			int des = cur[2];// 파괴한 벽돌 수
			if (cr == n - 1 && cc == n - 1) {
				System.out.println(des);
				return;
			}
			visit[cr][cc] = true;
			for (int dir = 0; dir < 4; dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if (cango(nr, nc)) {
					if (map[nr][nc] == '1')
						pq.add(new int[] { nr, nc, des });
					else
						pq.add(new int[] { nr, nc, des + 1 });
				}
			}
		}

	}

	static boolean cango(int nr, int nc) {
		if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visit[nr][nc])
			return true;
		return false;
	}
}