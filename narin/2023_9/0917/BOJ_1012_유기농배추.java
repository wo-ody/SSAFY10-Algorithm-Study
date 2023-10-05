import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N, M, K, count;
	private static int[][] field;
	private static boolean[][] isVisited;
	private static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();

		q.add(new Point(x, y));

		isVisited[x][y] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + delta[i][0];
				int ny = p.y + delta[i][1];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				if (field[nx][ny] == 1 && !isVisited[nx][ny]) {
					isVisited[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			count = 0;
			isVisited = new boolean[N][M];
			field = new int[N][M];

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());

				field[x][y] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (field[i][j] == 1 && !isVisited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
}
