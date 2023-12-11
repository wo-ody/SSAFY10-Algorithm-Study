/*
 *	08.08 김창희
 *	BOJ_3109_빵집
 *
 *	[풀이]
 *  1. 그리디로 생각해야한다.
 *  2. 여러개의 경로가 나오기 위해서는 경로가 짧아야하고 경로가 차지하는 영역이 좁아야한다.
 *  3. 위 옆 아래로 재귀로 탐색하게 한다. 
 *  4. 재귀함수가 boolean을 반환하게 하여 위 옆 아래 중 차례대로 탐색가능하게 한다.
 *  5. 계속 갈수있거나 도착지에 도달하게 된다면 true를 더 이상 갈곳이 없다면(return true에 걸리지 않는다면)false를 반환한다. 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int[] dx = { -1, 0, 1 }, dy = { 1, 1, 1 };
	static int n, m, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();

		}
		for (int i = 0; i < n; i++) dfs(i,0);
		System.out.println(answer);
	}

	public static boolean dfs(int x, int y) {
		map[x][y] = '1';
		if (y == m - 1) {
			answer++;
			return true;
		}

		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 'x')
				continue;

			if (map[nx][ny] == '.' && dfs(nx, ny)) {
				return true;
			}
		}
		return false;
	}

}
