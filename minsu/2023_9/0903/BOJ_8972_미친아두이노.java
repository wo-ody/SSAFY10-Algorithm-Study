package bj.G3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_8972_미친아두이노 {

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static char[][] map;
	static Point jongsuArduino;
	static int cnt = 0;
	static int[][] dist = { {}, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, -1 }, { 0, 0 }, { 0, 1 }, { -1, -1 }, { -1, 0 },
			{ -1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
				} else if (map[i][j] == 'I') {
					map[i][j] = '.';
					jongsuArduino = new Point(i, j);
				}
			}
		}

		String moving = br.readLine();

		if (goSimulate(moving)) {
			StringBuilder ans = new StringBuilder();
			map[jongsuArduino.x][jongsuArduino.y] = 'I';
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					ans.append(map[i][j]);
				}
				if (i != N - 1)
					ans.append("\n");
			}
			System.out.printf("%s", ans.toString());
		} else {
			System.out.printf("kraj %d", cnt);
		}
	}

	public static boolean goSimulate(String moving) {

		for (int i = 0; i < moving.length(); i++) {
			cnt++;
			int d = moving.charAt(i) - '0';
			int nx = jongsuArduino.x + dist[d][0];
			int ny = jongsuArduino.y + dist[d][1];
			jongsuArduino = new Point(nx, ny);

			if (map[nx][ny] == 'R') {
				return false;
			}
			moveCrazyArduino();

			if (map[nx][ny] == 'R') {
				return false;
			}

		}
		return true;
	}

	public static void moveCrazyArduino() {
		boolean[][] isDestroyed = new boolean[N][M];
		boolean[][] isMove = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '.')
					continue;
				map[i][j] = '.';
				int min = Integer.MAX_VALUE;
				int nx = 0;
				int ny = 0;

				for (int d = 1; d <= 9; d++) {
					if (!isIn(i + dist[d][0], j + dist[d][1]))
						continue;
					int len = getDist(i + dist[d][0], j + dist[d][1]);
					if (min > len) {
						min = len;
						nx = i + dist[d][0];
						ny = j + dist[d][1];
					}
				}
				if (isMove[nx][ny]) {
					isDestroyed[nx][ny] = true;
				}
				isMove[nx][ny] = true;
			}
		}

		if (isDestroyed[jongsuArduino.x][jongsuArduino.y]) {
			System.out.printf("kraj %d", cnt);
			System.exit(0);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (isDestroyed[i][j]) {
					map[i][j] = '.';
				} else if (isMove[i][j])
					map[i][j] = 'R';
			}
		}
	}

	public static int getDist(int x, int y) {
		return Math.abs(x - jongsuArduino.x) + Math.abs(y - jongsuArduino.y);
	}

	public static boolean isIn(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}
