import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static char[][] map;
	static int[][] coins = new int[2][2];// 동전 2개의 좌표
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int idx = 0;// 코인 인덱스

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'o') {
					coins[idx][0] = i;
					coins[idx++][1] = j;
				}
			}
		} // 맵 입력을 받으면서 코인의 좌표값도 입력

		bfs();
	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { coins[0][0], coins[0][1], coins[1][0], coins[1][1] });// 코인 2개의 초기 좌표 입력
		int depth = 0;
		while (!queue.isEmpty()) {
			depth++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				int cr1 = cur[0];
				int cc1 = cur[1];
				int cr2 = cur[2];
				int cc2 = cur[3];

				for (int dir = 0; dir < 4; dir++) {
					int nr1 = cur[0] + dr[dir];
					int nc1 = cur[1] + dc[dir];
					int nr2 = cur[2] + dr[dir];
					int nc2 = cur[3] + dc[dir];

					if (goout(nr1, nc1) && goout(nr2, nc2))// 둘 다 밖으로 나가는 상황
						continue;
					else if (goout(nr1, nc1) || goout(nr2, nc2))// 하나만 나가는 상황
					{
						System.out.println(depth);
						return;
					} else {// 둘 다 안으로 움직이는 상황
						if (map[nr1][nc1] == '#') {
							nr1 = cr1;
							nc1 = cc1;
						}
						if (map[nr2][nc2] == '#') {
							nr2 = cr2;
							nc2 = cc2;
						}
						queue.add(new int[] { nr1, nc1, nr2, nc2 });
					}
				}
			}
			if (depth == 10) {
				System.out.println(-1);
				return;
			}
		}
	}

	static boolean goout(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M)
			return false;
		return true;
	}
}