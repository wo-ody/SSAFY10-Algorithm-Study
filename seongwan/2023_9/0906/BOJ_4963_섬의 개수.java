import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int w, h, cnt, map[][];
	static int dr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int dc[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		while (true) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0)
				break;
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			while (true) {
				int[] point = find();
				if (point == null)
					break;
				cnt++;
				int r = point[0];
				int c = point[1];
				dfs(r, c);

			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int r, int c) {
		map[r][c] = 2;
		for (int dir = 0; dir < 8; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (cango(nr, nc)) {
				dfs(nr, nc);
			}
		}
	}

	static int[] find() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] == 1)
					return new int[] { i, j };
			}
		}
		return null;
	}

	static boolean cango(int r, int c) {
		if (r >= 0 && r < h && c >= 0 && c < w && map[r][c] == 1)
			return true;
		return false;

	}

}
