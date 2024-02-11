import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N, result;
	private static int[][] cave, ans;
	private static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	private static void bfs(int x, int y) {

		Queue<Point> q = new LinkedList<>();

		q.add(new Point(x, y));

		ans[x][y] = cave[x][y];

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x + delta[d][0];
				int ny = p.y + delta[d][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				// 반대로 올라갈 수 없음
				if (ans[nx][ny] > ans[p.x][p.y] + cave[nx][ny]) {
					ans[nx][ny] = ans[p.x][p.y] + cave[nx][ny];
					q.add(new Point(nx, ny));
				}

			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int test_case = 1;

		while (true) {
			N = Integer.parseInt(br.readLine());
			result = 0;

			if (N == 0)
				break;

			sb.append("Problem " + test_case + ": ");

			cave = new int[N][N];
			ans = new int[N][N];

			for (int i = 0; i < N; i++) {
				Arrays.fill(ans[i], Integer.MAX_VALUE);
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(0, 0);

			sb.append(ans[N - 1][N - 1]).append("\n");
			test_case++;

		}

		System.out.println(sb);
	}
}
