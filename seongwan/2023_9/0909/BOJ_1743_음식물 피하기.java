import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, K, map[][], max;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;// 음식물 쓰레기 = 1
		}
		find();
		System.out.println(max);
	}

	static void find() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 1)
					bfs(i, j);
			}
		}
	}

	static void bfs(int r, int c) {
		int cnt = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { r, c });
		map[r][c] = 2;// 2로 바꿔서 방문처리
		cnt++;
		while (!queue.isEmpty()) {
			int cur[] = queue.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int dir = 0; dir < 4; dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if (cango(nr, nc)) {
					queue.add(new int[] { nr, nc });
					cnt++;
					map[nr][nc] = 2;// 방문 처리
				}
			}
		}
		max = Math.max(max, cnt);
	}

	static boolean cango(int r, int c) {
		if (r > 0 && r <= N && c > 0 && c <= M && map[r][c] == 1)
			return true;
		return false;
	}
}