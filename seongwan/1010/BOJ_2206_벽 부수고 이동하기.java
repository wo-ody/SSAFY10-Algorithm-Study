import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, ans = 1;
	static char[][] map;
	static boolean[][][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visit = new boolean[N][M][2];// 벽을 깼을 때와 깨지 않았을 때 visit 따로 처리
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		} // map 입력

		if (N == 1 && M == 1 && map[0][0] == '0')
			System.out.println(1);
		else
			bfs();

	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { 0, 0, 0 });// [2]== 0 벽을 깨지 않았음을 표시,1==벽을 하나 깸을 표시
		visit[0][0][0] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				int cr = cur[0];
				int cc = cur[1];
				int wall = cur[2];
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (nr == N - 1 && nc == M - 1) {
						System.out.println(ans + 1);// 도착칸으로 이동했을 때 시간을 더해주지 않았으므로 +1
						return;// 도착한 경우
					}

					if (cango(nr, nc) && !visit[nr][nc][wall]) {
						if (map[nr][nc] == '0') {// 다음 칸이 빈 칸인 경우
							queue.add(new int[] { nr, nc, wall });
							if (wall == 0) {// 벽을 깬 적이 없다면
								visit[nr][nc][0] = true;
								visit[nr][nc][1] = true;
							} else// 벽을 깬 적이 있다면
								visit[nr][nc][1] = true;
						} else// 다음 빈 칸이 벽인 경우
						if (wall == 0) {
							queue.add(new int[] { nr, nc, 1 });
							visit[nr][nc][1] = true;
						}
					}
				}
			}
			ans++;
		}
		System.out.println(-1);// 도착하지 못하는 경우
	}

	static boolean cango(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M)
			return true;
		return false;
	}
}