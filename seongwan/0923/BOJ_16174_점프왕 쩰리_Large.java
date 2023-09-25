import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] map;
	static StringTokenizer st;
	static int[] dr = { 1, 0 };
	static int[] dc = { 0, 1 };// 아래,오른쪽

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { 0, 0, map[0][0] });
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cr = cur[0];
			int cc = cur[1];
			int range = cur[2];
			for (int dir = 0; dir < 2; dir++) {
				int nr = cr + dr[dir] * range;
				int nc = cc + dc[dir] * range;
				if (cango(nr, nc)) {
					if (nr == N - 1 && nc == N - 1) {// 승리 지점에 도착한 경우
						System.out.println("HaruHaru");
						return;
					}
					if (map[nr][nc] > 0 && map[nr][nc] <= N - 1) {
						queue.add(new int[] { nr, nc, map[nr][nc] });
						map[nr][nc] = -1;// 방문처리
					}
				}
			}
		}
		System.out.println("Hing");// 도착하지 못하고 탐색이 끝났을 때
	}

	static boolean cango(int r, int c) {
		if (r < N && c < N)
			return true;
		return false;
	}

}
