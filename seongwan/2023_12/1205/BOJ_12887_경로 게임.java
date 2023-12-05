import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int M, total;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0 };// 상,하,우
	static int[] dc = { 0, 0, 1 };// 상,하,우

	public static void main(String[] args) throws Exception {
		M = Integer.parseInt(br.readLine());
		visit = new boolean[2][M];
		map = new char[2][M];

		for (int i = 0; i < 2; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '.')
					total++;// 전체 하얀색 칸의 개수를 체크
			}
		}

		System.out.println(total - bfs());
	}

	static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		int depth = 1;
		for (int i = 0; i < 2; i++) {
			if (map[i][0] == '.') {
				queue.add(new int[] { i, 0 });
				visit[i][0] = true;
				if (0 == M - 1)
					return depth;// 마지막 열에 최단 거리로 도착했다면
			}
		} // 첫 열의 하얀색 칸인 부분을 출발점으로 bfs

		while (!queue.isEmpty()) {
			int size = queue.size();
			depth++;
			for (int i = 0; i < size; i++) {
				int cur[] = queue.poll();
				int cr = cur[0];
				int cc = cur[1];
				for (int dir = 0; dir < 3; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (cango(nr, nc)) {
						if (nc == M - 1)
							return depth;// 마지막 열에 최단 거리로 도착했다면

						queue.add(new int[] { nr, nc });
						visit[nr][nc] = true;
					}
				}
			}
		}
		return depth;
	}

	static boolean cango(int nr, int nc) {
		if (nr >= 0 && nr < 2 && nc >= 0 && nc < M && !visit[nr][nc] && map[nr][nc] == '.')
			return true;
		return false;
	}

}