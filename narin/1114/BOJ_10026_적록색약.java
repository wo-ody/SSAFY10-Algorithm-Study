import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	private static int N, res1, res2;
	private static char[][] grid;
	private static boolean[][] result1, result2;
	private static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	private static void dfs1(int x, int y, char color) {

		for (int[] d : delta) {
			int nx = x + d[0];
			int ny = y + d[1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			if (result1[nx][ny] || grid[nx][ny] != color)
				continue;

			result1[nx][ny] = true;
			dfs1(nx, ny, color);
		}
	}

	private static void dfs2(int x, int y, char color) {

		for (int[] d : delta) {
			int nx = x + d[0];
			int ny = y + d[1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N || result2[nx][ny])
				continue;

			if ((color == grid[nx][ny]) || (color == 'R' && grid[nx][ny] == 'G')
					|| (color == 'G' && grid[nx][ny] == 'R')) {

				result2[nx][ny] = true;
				dfs2(nx, ny, color);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		grid = new char[N][N];
		result1 = new boolean[N][N];
		result2 = new boolean[N][N];
		res1 = 0;
		res2 = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!result1[i][j]) {
					result1[i][j] = true;
					dfs1(i, j, grid[i][j]);
					res1++;
				}

				if (!result2[i][j]) {
					result2[i][j] = true;
					dfs2(i, j, grid[i][j]);
					res2++;
				}

			}
		}

		System.out.println(res1 + " " + res2);

	}
}
