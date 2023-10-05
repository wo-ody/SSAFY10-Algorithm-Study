import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, paper[][], s, max, count;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		find();
		System.out.println(count + "\n" + max);
	}

	static void find() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (paper[i][j] == 1) {
					count++;
					bfs(i, j);
				}
			}
		}
	}

	static void bfs(int r, int c) {
		int cnt = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { r, c });
		paper[r][c] = 2;// 2로 바꿔서 방문처리
		cnt++;
		while (!queue.isEmpty()) {
			int cur[] = queue.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int dir = 0; dir < 4; dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if (cango(nr, nc)) {
					queue.add(new int[] { nr, nc });
					cnt++;// 그림의 넓이
					paper[nr][nc] = 2;// 방문처리
				}
			}

		}
		max = Math.max(max, cnt);
	}

	static boolean cango(int r, int c) {
		if (r >= 0 && r < n && c >= 0 && c < m && paper[r][c] == 1)
			return true;
		return false;
	}
}
