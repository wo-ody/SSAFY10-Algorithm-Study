import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, cnt;
	static int[] start = new int[3], end = new int[2];
	static char[][] map;
	static boolean[][] visit;
	static boolean flag;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		st = new StringTokenizer(br.readLine());
		start[0] = Integer.parseInt(st.nextToken()) - 1;
		start[1] = Integer.parseInt(st.nextToken()) - 1;
		end[0] = Integer.parseInt(st.nextToken()) - 1;
		end[1] = Integer.parseInt(st.nextToken()) - 1;
		start[2] = 0;// 가중치 0으로 설정

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		} // map입력

		while (!flag) {
			cnt++;
			dijk();
		}
		System.out.println(cnt);
	}

	static void dijk() {
		visit = new boolean[N][M];
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[2] - e2[2]);
		pq.add(start);
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cr = cur[0];
			int cc = cur[1];
			int cost = cur[2];
			if (cr == end[0] && cc == end[1]) {
				flag = true;
				return;
			}
			visit[cr][cc] = true;
			if (cost == 1)
				map[cr][cc] = '0';// 친구를 만났을 경우 그 칸을 0으로 만들고 그 방향으로의 파동은 퍼지지 않음
			else {
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (cango(nr, nc)) {
						int ncost = map[nr][nc] - '0';
						pq.add(new int[] { nr, nc, ncost });
					}
				}
			} // 친구를 만나지 못한 경우 계속해서 파동이 퍼져 나감
		}

	}

	static boolean cango(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visit[nr][nc])
			return true;
		return false;
	}

}