import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class get {
	int x, y;

	public get(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	private static int N, size, result;
	private static get[] core;
	private static int[][] processor;
	private static boolean[] isVisited;
	private static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void comb(int index, int count, int R) {
		if (count == R) {
			dfs(0, 0);
			return;
		}
		for (int i = index; i < size; i++) {
			isVisited[i] = true;
			comb(i + 1, count + 1, R);
			isVisited[i] = false;
		}
	}

	private static void dfs(int index, int count) {
		if (index == size) {
			result = Math.min(result, count);
			return;
		}
		if (!isVisited[index]) {
			dfs(index + 1, count);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int x = core[index].x, y = core[index].y, temp = 0;
			boolean success = false;
			while (true) {
				x += delta[i][0];
				y += delta[i][1];
				if (x < 0 || x >= N || y < 0 || y >= N) {
					success = true;
					break;
				}
				if (processor[x][y] != 0)
					break;
				processor[x][y] = -1;
				temp++;
			}

			if (success) {
				dfs(index + 1, count + temp);
			}

			while (true) {
				x -= delta[i][0];
				y -= delta[i][1];
				if (x == core[index].x && y == core[index].y)
					break;
				processor[x][y] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");

			N = Integer.parseInt(br.readLine());
			size = 0;
			result = Integer.MAX_VALUE;
			processor = new int[N][N];
			core = new get[12];
			isVisited = new boolean[12];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					processor[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					if (processor[i][j] == 1) {
						core[size++] = new get(i, j);
					}
				}
			}

			for (int i = size; i >= 0; i--) {
				comb(0, 0, i);
				if (result < Integer.MAX_VALUE)
					break;
			}

			sb.append(result + "\n");
		}

		System.out.println(sb);
	}
}
