package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	static int R, C, T, ans;
	static List<int[]> dust;
	static int[][] map;
	static List<int[]> cleaner = new ArrayList<>();
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if (n == -1) {
					cleaner.add(new int[] { i, j });
				}
			}
		}

		while (T > 0) {
			dust = new ArrayList<>();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != -1 && map[i][j] != 0) {
						dust.add(new int[] { i, j, map[i][j] });
					}
				}
			}
			sperad();
			clean();
			T--;
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1 || map[i][j] == 0) {
					continue;
				}
				ans += map[i][j];
			}
		}
		
		System.out.println(ans);

	}

	static void sperad() {
		// 먼지가 있는 좌표들을 전부 탐색해서 상하좌우로
		// 범위내에 존재하는지 확인 -> 값이 -1이 아닌지 확인(공기청정기)
		int size = dust.size();
		for (int i = 0; i < size; i++) {
			// 현재 가져온 먼지 좌표
			int[] cur = dust.get(i);
			// 다른 좌표에 확산시킬 값, 현재 값 / 5
			int idx = cur[2] / 5;
			// 상하좌우로 탐색하면서 먼지를 확산시킬 수 있는지 확인
			for (int j = 0; j < 4; j++) {
				int nx = cur[0] + dx[j];
				int ny = cur[1] + dy[j];
				// 범위를 벗어난다면
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
					continue;
				}
				if (map[nx][ny] != -1) {
					map[nx][ny] += idx;
					map[cur[0]][cur[1]] -= idx;
				}
			}
		}
	}

	static void clean() {
		// 청정기의 위쪽 좌표
		int[] up = cleaner.get(0);
		// 2행의 맨ㅌ 끝자락을 기록해두고
		int temp_1 = map[up[0]][C - 1];

		// 2행을 먼저 돌려주고
		for (int i = C - 1; i >= 2; i--) {
			map[up[0]][i] = map[up[0]][i - 1];
		}
		map[up[0]][1] = 0;

		int temp_2 = map[0][C - 1];

		// 행 값 바꿔주기
		for (int i = 0; i < up[0] - 1; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		map[up[0] - 1][C - 1] = temp_1;

		// 맨 첫번째 행 돌려주고
		int temp_3 = map[0][0];
		for (int i = 0; i < C - 2; i++) {
			map[0][i] = map[0][i + 1];
		}

		map[0][C - 2] = temp_2;
		// 첫 번째 열을 돌려주기
		for (int i = up[0] - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		map[1][0] = temp_3;

		// 청정기의 아래쪽 좌표
		int[] down = cleaner.get(1);
		// 2행의 맨ㅌ 끝자락을 기록해두고
		int down_1 = map[down[0]][C - 1];

		// -> 방향으로 돌려주고
		for (int i = C - 1; i >= 2; i--) {
			map[down[0]][i] = map[down[0]][i - 1];
		}
		map[down[0]][1] = 0;

		int down_2 = map[R - 1][C - 1];

		// 아래방향으로 돌리고
		for (int i = R - 1; i > down[0] + 1; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}
		map[down[0] + 1][C - 1] = down_1;

		// <- 방향으로 돌리고
		int down_3 = map[R - 1][0];
		for (int i = 0; i < C - 2; i++) {
			map[R - 1][i] = map[R - 1][i + 1];
		}
		map[R - 1][C - 2] = down_2;

		// 위에 방향으로 돌리기
		for (int i = down[0] + 1; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		map[R - 2][0] = down_3;
	}

}
