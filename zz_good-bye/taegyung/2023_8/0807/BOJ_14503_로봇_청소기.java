package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇_청소기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N, M, r, c, d;

	static int[][] room;

	static int cleanCnt = 0;

	// 0 -> 빈칸,
	// 1 -> 벽
	// 2 -> 청소 된 칸으로 하자
	public static void main(String[] args) throws IOException {
		input();
		activate();

		System.out.println(cleanCnt);
	}

	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		room = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void activate() {
		if (room[r][c] == 0) {
			room[r][c] = 2;
			cleanCnt++;
			activate();
		} else {
			boolean flag = false;
			for (int i = 0; i < 4; i++) {
				if (room[r + dx[i]][c + dy[i]] == 0) { // 청소되지 않은 빈칸이 있음
					flag = true;
				}
			}
			if (flag) { // 반시계방향으로 회전
				d = (d - 1);
				if (d == -1) {
					d = 3;
				}
				if (room[r + dx[d]][c + dy[d]] == 0) {
					r += dx[d];
					c += dy[d];
				}
				activate(); // 1번으로 돌아간다.
			} else { // 주변에 청소할 곳이 없다면
				if (room[r - dx[d]][c - dy[d]] != 1) { // 뒤가 벽이 아니라면
					r -= dx[d];
					c -= dy[d]; // 뒤로 후진하고
					activate(); // 1번으로 돌아간다.
				}

				else {
					return; // 벽이라 후진할 수 없다면 작동을 멈춘다.
				}
			}
		}
	}
}
