import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m, start_r, start_c;
	static int[][] map, visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					start_r = i;
					start_c = j;

				}

			}
		} // 맵 입력
		bfs(start_r, start_c);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && visited[i][j] == 0)
					sb.append(-1 + " ");//땅이지만 도달하지 못한 곳은 -1출력
				else
					sb.append(visited[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);// 시작점으로부터의 거리 출력
	}

	static void bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { r, c });
		while (!queue.isEmpty()) {
			int[] v = queue.poll();
			int sr = v[0];
			int sc = v[1];
			for (int i = 0; i < 4; i++) {
				int nr = sr + dr[i];
				int nc = sc + dc[i];
				if (nr >= 0 && nr <= n - 1 && nc >= 0 && nc <= m - 1 && visited[nr][nc] == 0 && map[nr][nc] == 1) {
					visited[nr][nc] = visited[sr][sc] + 1;// 같은 깊이에 같은 번호로 깊이 갈수록 값+1
					queue.add(new int[] { nr, nc });
				}
			}
		}
	}
}
