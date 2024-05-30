import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int W, H;
	static char[][] map;
	static boolean[][][] visit;//위치와 해당 위치에 도달했을 때의 방향까지 기록
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int[] start = new int[2];
	static int[] end = new int[2];
	static boolean check;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new char[H][W];
		visit = new boolean[H][W][4];
		for (int i = 0; i < H; i++) {
			String s = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = s.charAt(j);

				if (map[i][j] == 'C' && !check) {
					check = true;
					start[0] = i;
					start[1] = j;
				} else if (map[i][j] == 'C' && check) {
					end[0] = i;
					end[1] = j;
				}
			}
		}

		System.out.println(dijk());
	}

	static int dijk() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[2] - e2[2]);

		for (int dir = 0; dir < 4; dir++) {
			int nr = start[0] + dr[dir];
			int nc = start[1] + dc[dir];
			if (cango(nr, nc)) {
				pq.add(new int[] {nr, nc, 0, dir}); //위치, 사용한 거울 개수, 현재 방향
			}
		}

		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			int cr = temp[0];
			int cc = temp[1];
			int mirror = temp[2];
			int direction = temp[3];

			if (cr == end[0] && cc == end[1]) {
				return mirror;
			}

			if (visit[cr][cc][direction]) {
				continue;
			}

			visit[cr][cc][direction] = true;

			int nr = cr + dr[direction];
			int nc = cc + dc[direction];

			if (cango(nr, nc) && !visit[nr][nc][direction]) {
				pq.add(new int[] {nr, nc, mirror, direction});
			}

			nr = cr + dr[(direction + 1) % 4];
			nc = cc + dc[(direction + 1) % 4];

			if (cango(nr, nc) && !visit[nr][nc][direction]) {
				pq.add(new int[] {nr, nc, mirror + 1, (direction + 1) % 4});
			}

			nr = cr + dr[(direction + 3) % 4];
			nc = cc + dc[(direction + 3) % 4];

			if (cango(nr, nc) && !visit[nr][nc][direction]) {
				pq.add(new int[] {nr, nc, mirror + 1, (direction + 3) % 4});
			}

		}
		return -1;
	}

	static boolean cango(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < H && nc < W && map[nr][nc] != '*';
	}
}