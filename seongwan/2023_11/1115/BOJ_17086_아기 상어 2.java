import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, ans;
	static int[][] map;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 맵 입력

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 1)
					bfs(i, j);
			}
		}
		System.out.println(ans);

	}

	static void bfs(int r, int c) {
		visit = new boolean[N][M];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { r, c });
		visit[r][c] = true;// 출발점 방문 처리
		int depth = 0;
		while (!queue.isEmpty()) {
			depth++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				int cr = cur[0];
				int cc = cur[1];

				for (int dir = 0; dir < 8; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (cango(nr, nc)) {
						if (map[nr][nc] == 1) {// 탐색 중 다른 상어를 최단 거리로 만난 경우
							ans = Math.max(ans, depth);
							return;
						}
						queue.add(new int[] { nr, nc });
						visit[nr][nc] = true;
					}
				}
			}

		}
	}

	static boolean cango(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visit[nr][nc])
			return true;
		return false;
	}

}