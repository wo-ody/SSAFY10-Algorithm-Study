import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] area;
	static int[][] delta = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
	static List<Point> cloud, afterMove;
	static boolean[][] isVisited;

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

	private static void move(int d, int s) {
		for (Point p : cloud) {
			int nr = p.r, nc = p.c;

			for (int i = 0; i < s; i++) {
				nr += delta[d][0];
				nc += delta[d][1];

				if (nr > N)
					nr -= N;
				if (nr < 1)
					nr += N;

				if (nc > N)
					nc -= N;
				if (nc < 1)
					nc += N;
			}

			area[nr][nc] = area[nr][nc] + 1;

			afterMove.add(new Point(nr, nc));

		}

		cloud.clear();

		waterCopy();

		cloudAdd();

		afterMove.clear();
	}

	private static void waterCopy() {

		for (Point p : afterMove) {
			int inc = waterCnt(p.r, p.c);
			area[p.r][p.c] = area[p.r][p.c] + inc;
			isVisited[p.r][p.c] = true;
		}

	}

	private static void cloudAdd() {

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (area[i][j] >= 2 && !isVisited[i][j]) {
					cloud.add(new Point(i, j));
					area[i][j] = area[i][j] - 2;
				}
			}
		}
	}

	private static int waterCnt(int r, int c) {

		int count = 0; // 물이 있는 바구니의 수

		for (int d = 1; d < 8; d += 2) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];

			if (nr <= 0 || nc <= 0 || nr > N || nc > N)
				continue;

			if (area[nr][nc] > 0)
				count++;
		}

		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		area = new int[N + 1][N + 1];
		cloud = new ArrayList<>();
		afterMove = new ArrayList<>();

		cloud.add(new Point(N, 1));
		cloud.add(new Point(N, 2));
		cloud.add(new Point(N - 1, 1));
		cloud.add(new Point(N - 1, 2));

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());

			isVisited = new boolean[N + 1][N + 1];
			move(d, s);
		}

		int result = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				result += area[i][j];
			}
		}

		System.out.println(result);
	}
}
