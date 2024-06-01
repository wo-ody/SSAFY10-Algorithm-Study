import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int W, H;
	static char[][] map;
	static int[] start = new int[2];
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};

	public static void main(String[] args) throws Exception {
		while (true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			if (W == 0)
				break;

			map = new char[H][W];
			visit = new boolean[H][W];

			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = s.charAt(j);

					if (map[i][j] == '@') {
						start[0] = i;
						start[1] = j;
					}
				}
			}

			sb.append(bfs()).append("\n");
		}
		System.out.println(sb);
	}

	static int bfs() {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(start);
		visit[start[0]][start[1]] = true;
		int cnt = 0;

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int cr = temp[0];
			int cc = temp[1];

			cnt++;

			for (int dir = 0; dir < 4; dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];

				if (cango(nr, nc)) {
					visit[nr][nc] = true;
					queue.add(new int[] {nr, nc});
				}
			}

		}
		return cnt;
	}

	static boolean cango(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W && !visit[r][c] && map[r][c] == '.';
	}
}