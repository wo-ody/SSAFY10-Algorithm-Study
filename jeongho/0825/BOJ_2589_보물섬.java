package algorithm2023.aug.day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {
	static int R, C, max;
	static char[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		/* 입력 종료 */
		for(int y= 0;y<R;y++) {
			for(int x = 0;x<C;x++) {
				if(map[y][x]=='L') {
					BFS(y,x);
				}
			}
		}
		System.out.println(max);
	}

	static void BFS(int y, int x) {
		Queue<Idx> q = new LinkedList<>();
		boolean[][] v = new boolean[R][C];
		q.add(new Idx(y, x));
		v[y][x] = true;

		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Idx cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];

					if (!isValid(ny, nx))
						continue;
					if (v[ny][nx])
						continue;
					q.offer(new Idx(ny,nx));
					v[ny][nx] = true;
				}
			}
			time++;
		}
		max = Math.max(max, time-1);
		
	}

	static boolean isValid(int y, int x) {
		if (y < 0 || x < 0 || y >= R || x >= C||map[y][x]=='W')
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
