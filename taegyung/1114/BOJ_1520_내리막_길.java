package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520_내리막_길 {
	static int[][] heights;
	static int M, N;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		heights = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				heights[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(0, 0));

	}

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static int dfs(int x, int y) {
		// 네 방향으로 가보고 도로 들고와보자
		if (x == M - 1 && y == N - 1)
			return 1;

		int sum = 0;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || nx >= M || ny < 0 || ny >= N)
				continue;

			if (heights[x][y] > heights[nx][ny]) {
				if (dp[nx][ny] != -1)
					sum += dp[nx][ny];

				else { // 여기서 처리를 해야겠는데
					sum += dfs(nx, ny);

				}
			}
		}
		return dp[x][y] = sum;

	}

}
