package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전_영역 {
	static int[][] map;
	static int max_area_cnt = 0;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int w = 0; w <= 100; w++) {
			// 물 수위가 올라감

			max_area_cnt = Math.max(max_area_cnt, safe_area(w));
		}
		System.out.println(max_area_cnt);

	}

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	static int safe_area(int w) {
		// 물의 수위에 따라 작동할거임

		boolean[][] visited = new boolean[N][N];
		int cnt = 0;
		// 아래로 내려가서 확인하자
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > w && visited[i][j] == false) {
					bfs(i, j, w, visited);
					cnt++;
				}
			}

		}
		return cnt;

	}

	static void bfs(int i, int j, int w, boolean[][] visited) {

		Queue<int[]> queue = new ArrayDeque<>();

		queue.offer(new int[] { i, j });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = tmp[0] + dx[d];
				int ny = tmp[1] + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;

				if (!visited[nx][ny] && map[nx][ny] > w) {
					queue.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
			}
		}
	}
}