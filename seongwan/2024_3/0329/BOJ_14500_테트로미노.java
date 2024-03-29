import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//한 점을 기준으로 dfs로 사방으로 총 3칸만 가는 걸로 처리
//다 탐색 후 최대 점수를 출력 ㅗ자만 따로 처리
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, max;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;
				dfs(i, j, 3, map[i][j]);
				visit[i][j] = false;
				mountain(i, j);
			}
		}
		System.out.println(max);
	}

	//현재위치, 갈 수 있는 남은 칸 수, 현 시점까지의 합
	static void dfs(int r, int c, int n, int sum) {
		//더 이상 갈 수 없는 경우
		if (n == 0) {
			max = Math.max(max, sum);
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (cango(nr, nc) && !visit[nr][nc]) {
				visit[nr][nc] = true;
				dfs(nr, nc, n - 1, sum + map[nr][nc]);
				visit[nr][nc] = false;
			}
		}
	}

	static void mountain(int r, int c) {
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (cango(r, c)) {
				int r1 = nr + dr[(dir + 1) % 4];
				int c1 = nc + dc[(dir + 1) % 4];

				int r2 = nr + dr[(dir + 3) % 4];
				int c2 = nc + dc[(dir + 3) % 4];

				if (cango(r1, c1) && cango(r2, c2)) {
					int sum = map[r][c] + map[nr][nc] + map[r1][c1] + map[r2][c2];
					max = Math.max(max, sum);
				}
			}
		}
	}

	static boolean cango(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}