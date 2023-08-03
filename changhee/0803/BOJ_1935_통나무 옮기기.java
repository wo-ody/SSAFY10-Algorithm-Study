/*
 *	08.03 김창희
 *	BOJ_1935_통나무 옮기기
 *
 *	[풀이]
 *	1. 세개의 점을 하나로 묶어 BFS를 하자!!!
 *	2. 통나무는 세칸을 차지하고 발향은 가로 또는 세로만 존재한다.
 *	3. 방문배열을 삼차원으로 만들어 통나무가 가로일때와 세로일때를 따로 방문체크를 진행한다!
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static Queue<Node> q = new LinkedList<>();
	static char[][] map;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		Node sp = new Node();
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == 'B') {
					if (sp.h == null) sp.h = new Point(i, j);
					else if (sp.m == null) sp.m = new Point(i, j);
					else if (sp.t == null) sp.t = new Point(i, j);
				}
			}
		}

		if (sp.h.x == sp.m.x && sp.m.x == sp.t.x) sp.dir = 0;
		else sp.dir = 1;
		q.offer(sp);

		int answer = move();
		System.out.println(answer == Integer.MAX_VALUE ? 0:answer);

	}

	public static int move() {
		boolean[][][] v = new boolean[n][n][2]; // 가로, 세로를 따로 방문체크
		int result = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (isAllArrive(node.h, node.m, node.t, node.cost)) {
				result=node.cost;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nhx = node.h.x + dx[i], nhy = node.h.y + dy[i];
				int nmx = node.m.x + dx[i], nmy = node.m.y + dy[i];
				int ntx = node.t.x + dx[i], nty = node.t.y + dy[i];

				if (nhx < 0 || nhy < 0 || nhx >= n || nhy >= n || nmx < 0 || nmy < 0 || nmx >= n || nmy >= n || ntx < 0
						|| nty < 0 || ntx >= n || nty >= n)
					continue;
				Node nNode = new Node(new Point(nhx, nhy), new Point(nmx, nmy), new Point(ntx, nty), node.cost + 1,
						node.dir);
				if (map[nhx][nhy] != '1' && map[nmx][nmy] != '1' && map[ntx][nty] != '1' && isVisited(v, nNode)) {
					vCheck(v, nNode);
					q.offer(nNode);
				} 
			}

			if (isCanRotate(node.m)) {
				// m기준으로
				Node nNode = null;
				if (node.dir == 0)
					nNode = new Node(new Point(node.m.x - 1, node.m.y), node.m, new Point(node.m.x + 1, node.m.y),
							node.cost + 1, 1);
				else
					nNode = new Node(new Point(node.m.x, node.m.y - 1), node.m, new Point(node.m.x, node.m.y + 1),
							node.cost + 1, 0);

				if (isVisited(v, nNode)) {
					vCheck(v, nNode);
					q.offer(nNode);
				}
			}
		}
		return result;
	}

	public static void vCheck(boolean[][][] v, Node node) {
		v[node.h.x][node.h.y][node.dir] = true;
		v[node.m.x][node.m.y][node.dir] = true;
		v[node.t.x][node.t.y][node.dir] = true;
	}

	public static boolean isVisited(boolean[][][] v, Node node) {
		if (!v[node.h.x][node.h.y][node.dir] || !v[node.m.x][node.m.y][node.dir] || !v[node.t.x][node.t.y][node.dir])
			return true;
		return false;
	}

	public static boolean isCanRotate(Point p) {
		for (int i = p.x - 1; i < p.x + 2; i++) {
			for (int j = p.y - 1; j < p.y + 2; j++) {
				if (i < 0 || j < 0 || i >= n || j >= n || map[i][j] == '1')
					return false;
			}
		}
		return true;
	}

	public static boolean isAllArrive(Point h, Point m, Point t, int cost) {
		if (map[h.x][h.y] == 'E' && map[m.x][m.y] == 'E' && map[t.x][t.y] == 'E')
			return true;
		return false;
	}

	static class Node {
		Point h, m, t;
		int cost, dir; // dir 0 : 가로, dir 1 :세로

		public Node(Point h, Point m, Point t, int cost, int dir) {
			this.h = h;
			this.m = m;
			this.t = t;
			this.cost = cost;
			this.dir = dir;
		}

		public Node() {
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
