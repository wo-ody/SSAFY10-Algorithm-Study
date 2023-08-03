package acmicpc.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {

	private static int N, M;
	private static int r, c, d;
	private static int[][] room;
	private static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	private static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		room = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				room[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		count = 0;
		while (true) {

			// 1. 현재 칸이 아직 청소되지 않은 경우
			if (room[r][c] == 0) {
				room[r][c] = -1;
				count++;
			}

			boolean canMove = false;
			// 2. 현재 칸의 주변 4칸 검사
			for (int i = 0; i < 4; i++) {
				int nd = (d + 3) % 4;
				int dx = r + dir[nd][0];
				int dy = c + dir[nd][1];

				// 2-1. 만약 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
				if (dx >= 0 && dx < N && dy >= 0 && dy < M && room[dx][dy] == 0) {
					// 반시계 방향으로 90도 회전한다.
					d = nd;
					// dx, dy가 청소되지 않은 빈칸인 경우 한칸 전진
					r = dx;
					c = dy;
					canMove = true;
					break;
				}
				d = nd;
			}
			// 2-2. 청소되지 않은 빈칸이 없는 경우
			if (!canMove) {
				int bx = r - dir[d][0];
				int by = c - dir[d][1];
				if (bx >= 0 && bx < N && by >= 0 && by < M && room[bx][by] != 1) {
					r = bx;
					c = by;
				} else {
					break;
				}

			}

		}

		System.out.println(count);
	}

}
