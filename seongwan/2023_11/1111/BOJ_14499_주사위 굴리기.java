import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, x, y, K;
	static int[][] map;
	static int[] dice = new int[6];// 주사위에 적힌 번호
	static int[] dr = { 0, 4, 5, 1 };// 밑면부터 r축으로 남쪽 방향으로 이동할 때 주사위 변화
	static int[] dc = { 0, 2, 5, 3 };// 밑면부터 c축으로 동쪽 방향으로 이동할 때 주사위 변화
	static int dridx, dcidx;
	static int[] point = new int[2];

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		point[0] = x;
		point[1] = y;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 맵 입력

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int cmd = Integer.parseInt(st.nextToken());
			roll(cmd);
		}
		System.out.println(sb);
	}

	static void roll(int cmd) {
		int bottom = 0, top = 0;
		boolean chk = false;
		if (cmd == 1) {// 동쪽
			if (cango(point[0], point[1] + 1)) {
				chk = true;
				point[1]++;
				dcidx = (dcidx + 1) % 4;
				bottom = dc[dcidx];
				top = dc[(dcidx + 2) % 4];
				dr[dridx] = bottom;
				dr[(dridx + 2) % 4] = top;
			}
		} else if (cmd == 2) {// 서쪽
			if (cango(point[0], point[1] - 1)) {
				chk = true;
				point[1]--;
				dcidx = (dcidx + 3) % 4;
				bottom = dc[dcidx];
				top = dc[(dcidx + 2) % 4];
				dr[dridx] = bottom;
				dr[(dridx + 2) % 4] = top;
			}
		} else if (cmd == 3) {// 북쪽
			if (cango(point[0] - 1, point[1])) {
				chk = true;
				point[0]--;
				dridx = (dridx + 3) % 4;
				bottom = dr[dridx];
				top = dr[(dridx + 2) % 4];
				dc[dcidx] = bottom;
				dc[(dcidx + 2) % 4] = top;
			}
		} else {// 남쪽
			if (cango(point[0] + 1, point[1])) {
				chk = true;
				point[0]++;
				dridx = (dridx + 1) % 4;
				bottom = dr[dridx];
				top = dr[(dridx + 2) % 4];
				dc[dcidx] = bottom;
				dc[(dcidx + 2) % 4] = top;
			}
		}

		if (chk) {
			if (map[point[0]][point[1]] != 0) {// 맵에 있는 수가 주사위 바닥에 복사되는 경우
				dice[bottom] = map[point[0]][point[1]];
				map[point[0]][point[1]] = 0;
			} else {// 주사위 바닥에 있는 수가 맵에 복사되는 경우
				map[point[0]][point[1]] = dice[bottom];
			}

			sb.append(dice[top] + "\n");
		}
	}

	static boolean cango(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M)
			return true;
		return false;
	}
}