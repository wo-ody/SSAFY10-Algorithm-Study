package algorithm2023.aug.day17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스 {
	static int N, M, D;
	static int[][] map;
	static boolean[] archer;
	static int max = 0;

	static int[] dy = { 0, -1, 0 };
	static int[] dx = { -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		archer = new boolean[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(max);
	}

	static void comb(int idx, int cnt) {
		if (cnt == 3) {
			int[][] map2 = new int[N][];
			for (int i = 0; i < N; i++) {
				map2[i] = Arrays.copyOf(map[i], map[i].length);
			}
			max = Math.max(max, game(N, map2));
			return;
		}

		if (idx >= M)
			return;
		archer[idx] = true;
		comb(idx + 1, cnt + 1);
		archer[idx] = false;
		comb(idx + 1, cnt);
	}

	static void bfs(int y, int x, int[][] map2, int depth, int r, boolean[][] v) {

		
	}

	static int game(int r, int[][] map2) {
		if (r == 0) {
			return 0;
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if (archer[i]) {
				Queue<Idx> q = new LinkedList<>();
				q.add(new Idx(r, i));
				int dis = 0;
				boolean[][] v = new boolean[r][M];
				loop: while (!q.isEmpty()) {
					int size = q.size();
					dis++;
					if (dis > D)
						break;
					for (int s = 0; s < size; s++) {
						Idx cur = q.poll();

						for (int d = 0; d < 3; d++) {
							int ny = cur.y + dy[d];
							int nx = cur.x + dx[d];
							if (!isValid(ny, nx, r))
								continue;
							if (v[ny][nx])
								continue;
							q.offer(new Idx(ny, nx));
							v[ny][nx] = true;
							if (map2[ny][nx] != 0) {
								map2[ny][nx] = -1;
								break loop;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < M; j++) {
				if (map2[i][j] < 0) {
					cnt++;
					map2[i][j] = 0;
				}
			}
		}
		cnt += game(r - 1, map2);
		return cnt;
	}

	static boolean isValid(int y, int x, int r) {
		if (y < 0 || x < 0 || y >= r || x >= M)
			return false;
		return true;
	}

	static class Idx {
		int y;
		int x;

		public Idx(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
}
