import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	private static int N, M;
	private static int ex, ey;
	// 1 흑돌 2 백돌
	private static int[][] board;
	private static int totalWhite, totalBlack;
	private static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
			{ -1, -1 } };

	private static boolean possible(int x, int y, int stone) {

		int another = 8;

		for (int[] d : delta) {

			int nx = x + d[0];
			int ny = y + d[1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;

			if (board[nx][ny] != stone) {
				another--;
			}

		}

		if (another == 8) {
			return false;
		}

		return true;
	}

	private static void flip(int x, int y) {

		for (int[] d : delta) {

			int tx = x;
			int ty = y;

			endOf(x, y, d[0], d[1]);
			int color = board[x][y];

			if (ex == tx && ey == ty)
				continue;

			while (true) {

				int nx = tx + d[0];
				int ny = ty + d[1];

				if (nx == ex && ny == ey)
					break;

				board[nx][ny] = color;

				tx = nx;
				ty = ny;
			}

		}

	}

	private static void endOf(int x, int y, int dx, int dy) {
		ex = x;
		ey = y;

		int color = board[x][y];
		int nx = x, ny = y;

		while (true) {
			nx = x + dx;
			ny = y + dy;

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				break;
			if (board[nx][ny] == 0)
				break;

			if (board[nx][ny] == color) {
				ex = nx;
				ey = ny;
				return;
			}

			x = nx;
			y = ny;

		}

	}

	private static void totalCount() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1)
					totalBlack++;
				else if (board[i][j] == 2)
					totalWhite++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			board = new int[N][N];

			board[N / 2][N / 2] = 2;
			board[N / 2 - 1][N / 2 - 1] = 2;
			board[N / 2 - 1][N / 2] = 1;
			board[N / 2][N / 2 - 1] = 1;

			totalWhite = 0;
			totalBlack = 0;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int stone = Integer.parseInt(st.nextToken());

				if (possible(x, y, stone) && board[x][y] == 0) {
					board[x][y] = stone;
					flip(x, y);
				}

			}

			totalCount();

			sb.append(totalBlack + " " + totalWhite + "\n");
		}

		System.out.println(sb);

	}
}
