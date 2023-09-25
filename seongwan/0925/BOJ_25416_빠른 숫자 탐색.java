import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] board = new int[5][5];
	static int r, c;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };// 상,좌,하,우

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 보드 입력

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());// 학생의 현재 위치

		bfs();
	}

	static void bfs() {
		int depth = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { r, c });
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				int cr = cur[0];
				int cc = cur[1];
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];

					if (cango(nr, nc)) {
						if (board[nr][nc] == 1) {
							System.out.println(depth + 1);// 이동 계산을 하기 전이므로 +1
							return;

						}
						board[nr][nc] = -1; // 방문 처리
						queue.add(new int[] { nr, nc });
					}
				}
			}
			depth++;

		}
		System.out.println(-1);// 탐색 후 1이 적혀있는 칸에 도착하지 못했을 때

	}

	static boolean cango(int nr, int nc) {
		if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && board[nr][nc] != -1)
			return true;
		return false;
	}

}
