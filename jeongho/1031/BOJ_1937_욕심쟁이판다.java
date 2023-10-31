package algorithm2023.oct.day30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1937_욕심쟁이판다 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, map[][], dp[][];

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	static boolean[][] v;

	static class Pos {
		int y, x;

		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	static boolean isValid(int y, int x) {
		if (y < 0 || x < 0 || y >= n || x >= n)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], 1);
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;
		v = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!v[i][j]) {
					max = Math.max(dfs(i, j), max);
				}
			}
		}
		System.out.println(max);

	}

	static int dfs(int y, int x) {
		
		
		if(dp[y][x] >1)return dp[y][x];
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (!isValid(ny, nx))
				continue;
			if (map[ny][nx] > map[y][x]) {
				dp[y][x] = Math.max(dp[y][x], dfs(ny,nx)+1);
			}
		}
		return dp[y][x];
		
	}

	static void print() {
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
	}
}
