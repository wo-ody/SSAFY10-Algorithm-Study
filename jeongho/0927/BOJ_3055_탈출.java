package algorithm2023.sep.day27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055_탈출 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	static int R, C;
	static char[][] map;
	static boolean[][] v;

	static Node start;

	static class Node {
		int x, y, time;

		public Node(int y, int x, int time) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", time=" + time + "]";
		}

	}

	static boolean isValid(int y, int x) {
		if (y < 0 || x < 0 || y >= R || x >= C || map[y][x] == 'X')
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		v = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					start = new Node(i, j, 0);
				}
			}
		}
		int res = bfs();
		System.out.println(res != -1 ? res : "KAKTUS");

	}

	static int bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.add(start);
		
		v[start.y][start.x] = true;

		loop: while (!q.isEmpty()) {

			int sz = q.size();
			check();
			print();
			for (int s = 0; s < sz; s++) {
				Node cur = q.poll();

				l: for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];
					if (!isValid(ny, nx) || v[ny][nx])
						continue;
					if (map[ny][nx]=='D')return cur.time + 1;
					
					
					if(map[ny][nx] == '.') {
						q.offer(new Node(ny, nx, cur.time + 1));
						v[ny][nx] = true;
					}
				}
			}
			expansion();

		}
		return -1;
	}
	
	static void check() {
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				if (map[y][x] == '*') {
					for (int d = 0; d < 4; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						if (isValid(ny, nx)) {
							if(map[ny][nx]=='D'||map[ny][nx]=='*')continue;
							map[ny][nx] = '^';
						}
					}
				}
			}
		}
	}

	static void expansion() {
		

		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				if (map[y][x] == '^')
					map[y][x] = '*';
			}
		}
		
	}
	
	


	static void print() {
		for (int y = 0; y < R; y++) {
			System.out.println(Arrays.toString(map[y]));
		}
		System.out.println();
	}

}
