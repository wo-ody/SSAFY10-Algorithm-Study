import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] map;
	static int N, M;
	static int[] point = new int[2];// 도연이의 위치
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };// 상,좌,하,우
	static int ans;// 만난 사람의 수

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		} // map 입력
		find();
		bfs();
		System.out.println(ans == 0 ? "TT" : ans);
	}

	static void find() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'I') {
					point[0] = i;
					point[1] = j;
					return;// 위치를 찾으면 종료
				}
			}

		}
	}// 도연이 위치 찾기

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(point);

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (map[nr][nc] == 'O') {
						map[nr][nc] = 'X';
						queue.add(new int[] { nr, nc });
					}
					if (map[nr][nc] == 'P') {
						map[nr][nc] = 'X';
						ans++;
						queue.add(new int[] { nr, nc });
					}

				}

			}
		}

	}

}
