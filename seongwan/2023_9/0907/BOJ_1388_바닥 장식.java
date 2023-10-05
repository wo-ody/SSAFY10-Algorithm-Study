import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, cnt;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		} // map 입력
		find();
		System.out.println(cnt);
	}

	static void find() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '-') {
					cnt++;
					bfs(i, j, 0);
				} // 가로무늬 0
				else if (map[i][j] == '|') {
					cnt++;
					bfs(i, j, 1);
				} // 세로무늬 1
			}
		}
	}

	static void bfs(int r, int c, int chk) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { r, c });
		while (!queue.isEmpty()) {
			int cur[] = queue.poll();
			int cr = cur[0];
			int cc = cur[1];
			map[cr][cc] = '.';// 방문처리
			if (chk == 0) {// 가로무늬인 경우
				int nc = cc + 1;
				if (cango(cr, nc) && map[cr][nc] == '-') {
					map[cr][nc] = '.';
					queue.add(new int[] { cr, nc });
				}
			} else if (chk == 1) {// 세로무늬인 경우
				int nr = cr + 1;
				if (cango(nr, cc) && map[nr][cc] == '|') {
					map[nr][cc] = '.';
					queue.add(new int[] { nr, cc });
				}
			}

		}
	}

	static boolean cango(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M)
			return true;
		return false;
	}// 방문할 수 있는 조건
}
