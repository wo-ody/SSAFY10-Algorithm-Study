package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int cnt;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };
	static int R, C;
	static boolean[][] checkList;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		checkList = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String row = br.readLine();
			for (int j = 0; j < C; j++) {
				if (row.charAt(j) == '.') {
					checkList[i][j] = true;
				} else {
					checkList[i][j] = false;
				}
			}
		}

		// 갈 수 있다 -> true
		// 갈 수 없다 -> false

		for (int i = 0; i < R; i++) {
			dfs(i, 0);

		}
		System.out.println(cnt);

	}

	public static boolean dfs(int x, int y) {
		if (y == C - 1) {
			cnt++;
			return true;
		}
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < R && 0 <= ny && ny < C && checkList[nx][ny] == true) {
				checkList[nx][ny] = false;
				if (dfs(nx, ny))
					return true;
//				checkList[nx][ny] = true;
			}
		}
		return false;
	}
}
