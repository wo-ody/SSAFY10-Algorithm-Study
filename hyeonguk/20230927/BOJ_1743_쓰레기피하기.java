import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, answer;
	// 동, 남, 서, 북
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// map[r][c] == true이면 r,c 자리에 쓰레기가 있는 것이다.
		map = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = true;

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]) {
					int cnt = bfs(i, j);
					answer = Math.max(answer, cnt);
				}
			}
		}

		System.out.println(answer);

	}

	static int bfs(int i, int j) {
		int cnt = 0;
		map[i][j] = false;
		cnt++;

		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { i, j });

		while (!queue.isEmpty()) {
			int[] item = queue.poll();
			int y = item[0];
			int x = item[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || ny >= N || nx < 0 || nx >= M)
					continue;

				if (map[ny][nx]) {
					map[ny][nx] = false;
					cnt++;
					queue.offer(new int[] {ny, nx});
				}
			}

		}
		return cnt;
	}
}
