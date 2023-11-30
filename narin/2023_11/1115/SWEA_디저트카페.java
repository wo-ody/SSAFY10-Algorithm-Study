package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_디저트카페 {

	private static int N, result, sx, sy;
	private static int[][] cafe;
	private static boolean[] desert;
	private static int[][] delta = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

	private static void dfs(int x, int y, int count, int dir) {
		desert[cafe[x][y]] = true;

		for (int d = dir; d < 4; d++) {
			int nx = x + delta[d][0];
			int ny = y + delta[d][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;

			if (nx == sx && ny == sy && count >= 4) {
				result = Math.max(result, count);
				break;
			}

			if (desert[cafe[nx][ny]])
				continue;

			dfs(nx, ny, count + 1, d);

		}

		desert[cafe[x][y]] = false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");

			N = Integer.parseInt(br.readLine());

			cafe = new int[N][N];
			result = -1;
			desert = new boolean[101];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cafe[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sx = i;
					sy = j;
					dfs(i, j, 1, 0);
				}
			}

			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}
}
