package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_벽돌깨기 {

	private static int N, W, H, result;
	private static int[][] map, copyMap;
	private static int[] select;
	private static int[][] delta = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	private static void comb(int count) {

		if (count == N) {

			copyMap = copy();

			for (int i = 0; i < N; i++) {
				int target = select[i];

				for (int j = 0; j < H; j++) {
					if (copyMap[j][target] > 0) {
						bomb(j, target, copyMap[j][target]);
						break;
					}
				}

				clean();
			}

			result = Math.min(result, remain());

			return;
		}

		for (int i = 0; i < W; i++) {

			select[count] = i;

			comb(count + 1);

		}
	}

	private static int[][] copy() {
		int[][] res = new int[H][W];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				res[i][j] = map[i][j];
			}
		}
		return res;
	}

	private static void bomb(int x, int y, int count) {

		copyMap[x][y] = 0;

		for (int[] d : delta) {

			int dx = x;
			int dy = y;

			for (int i = 0; i < count - 1; i++) {

				int nx = dx + d[0];
				int ny = dy + d[1];

				if (nx < 0 || ny < 0 || nx >= H || ny >= W)
					continue;

				if (copyMap[nx][ny] > 0) {

					bomb(nx, ny, copyMap[nx][ny]);

				}

				dx = nx;
				dy = ny;
			}

		}
	}

	private static void clean() {

		for (int j = 0; j < W; j++) {
			for (int i = H - 1; i >= 0; i--) {
				if (copyMap[i][j] == 0) {
					for (int k = i - 1; k >= 0; k--) {
						if (copyMap[k][j] > 0) {
							copyMap[i][j] = copyMap[k][j];
							copyMap[k][j] = 0;
							break;
						}
					}
				}
			}
		}
	}

	private static int remain() {

		int count = 0;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (copyMap[i][j] > 0) {
					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			result = Integer.MAX_VALUE;

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			select = new int[N];

			comb(0);

			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}
}
