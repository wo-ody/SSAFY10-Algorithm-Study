import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int L, R, C;
	static char[][][] map;
	static int[] start, end;
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static int[] dr = { -1, 0, 1, 0, 0, 0 };
	static int[] dc = { 0, -1, 0, 1, 0, 0 };// 상,좌,하,우,위층,아래층

	public static void main(String[] args) throws Exception {

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			if (L == 0)// 0입력되면 종료
				break;
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[L][R][C];

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String s = br.readLine();
					for (int k = 0; k < C; k++) {
						map[i][j][k] = s.charAt(k);
						if (map[i][j][k] == 'S')
							start = new int[] { i, j, k };
						if (map[i][j][k] == 'E')
							end = new int[] { i, j, k };
					}
				}
				br.readLine();
			} // map
			bfs();
		}
		System.out.println(sb);
	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(start);
		int time = 0;
		while (!queue.isEmpty()) {
			time++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int cur[] = queue.poll();
				int cz = cur[0];
				int cr = cur[1];
				int cc = cur[2];
				for (int dir = 0; dir < 6; dir++) {
					int nz = cz + dz[dir];
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (cango(nz, nr, nc)) {
						if (nz == end[0] && nr == end[1] && nc == end[2]) {
							sb.append("Escaped in " + time + " minute(s)." + "\n");
							return;
						}
						queue.add(new int[] { nz, nr, nc });
						map[nz][nr][nc] = '#';
					}
				}
			}

		}
		sb.append("Trapped!" + "\n");
	}

	static boolean cango(int nz, int nr, int nc) {
		if (nz >= 0 && nz < L && nr >= 0 && nr < R && nc >= 0 && nc < C
				&& (map[nz][nr][nc] == '.' || map[nz][nr][nc] == 'E'))
			return true;
		return false;
	}
}