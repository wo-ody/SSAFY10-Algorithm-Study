import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int R, C, K, ans;// 세로,가로,거리,거리에 해당하는 길의 가짓수
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static char[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}

		dfs(R - 1, 0, 1);
		System.out.println(ans);
	}

	static void dfs(int r, int c, int cnt) {
		if (cnt == K) {
			if (r == 0 && c == C - 1)
				ans++;
			return;
		}
		visit[r][c] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (cango(nr, nc) && !visit[nr][nc]) {
				visit[nr][nc] = true;
				dfs(nr, nc, cnt + 1);
				visit[nr][nc] = false;
			}
		}

	}

	static boolean cango(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.')
			return true;
		return false;
	}

}
