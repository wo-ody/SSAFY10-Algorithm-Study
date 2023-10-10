import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, ans;
	static int[][] origin;// 본래 맵 유지
	static int[][] map;
	static int[] wall = new int[3];
	static List<int[]> virus = new ArrayList<>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		origin = new int[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
				if (origin[i][j] == 2) {
					virus.add(new int[] { i, j });// 바이러스의 좌표값 입력
				}
			}
		} // 맵 입력

		simul();
		System.out.println(ans);
	}

	static void simul() {
		for (int i = 0; i < N * M; i++) {
			for (int j = i + 1; j < N * M; j++) {
				for (int j2 = j + 1; j2 < N * M; j2++) {
					wall = new int[] { i, j, j2 };// 벽을 둘 맵의 번호
					mapcopy();
					boolean flag = true;// 벽이 제대로 세워졌는지 확인
					for (int k = 0; k < 3; k++) {
						int r = wall[k] / M;
						int c = wall[k] % M;
						if (map[r][c] == 0) {
							map[r][c] = 1;
						} else {
							flag = false;
							break;
						}
					}
					if (flag) {// 벽이 제대로 세워졌다면 bfs로 탐색
						bfs();// 바이러스의 위치에서 bfs로 바이러스 전파
						count();// 안전영역의 개수를 구하고 현재까지의 최대값과 비교
					}

				}
			}
		}

	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.addAll(virus);
		while (!queue.isEmpty()) {
			int cur[] = queue.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int dir = 0; dir < 4; dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if (cango(nr, nc)) {
					queue.add(new int[] { nr, nc });
					map[nr][nc] = 2;
				}
			}
		}

	}

	static boolean cango(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0)
			return true;
		return false;
	}

	private static void count() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					cnt++;
			}
		}
		ans = Math.max(ans, cnt);

	}

	static void mapcopy() {
		for (int i = 0; i < N; i++) {
			map[i] = origin[i].clone();
		}
	}

}