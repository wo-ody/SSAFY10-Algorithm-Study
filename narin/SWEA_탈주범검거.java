import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	private static int N, M, R, C, L; // 세로N 가로M 맨홀위치R,C 탈출소요시간L
	private static int result;
	private static int[][] map;
	private static boolean[][] isVisited;
	private static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	private static Queue<Point> q;

	private static void bfs(int x, int y) {

		q = new ArrayDeque<>();

		q.add(new Point(x, y));
		isVisited[x][y] = true;

		for (int l = 0; l < L - 1; l++) {

			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();

				switch (map[p.x][p.y]) {
				case 1:
					int[] idx1 = { 0, 1, 2, 3 };
					temp(p.x, p.y, idx1);
					break;
				case 2:
					int[] idx2 = { 0, 1 };
					temp(p.x, p.y, idx2);
					break;
				case 3:
					int[] idx3 = { 2, 3 };
					temp(p.x, p.y, idx3);
					break;
				case 4:
					int[] idx4 = { 0, 3 };
					temp(p.x, p.y, idx4);
					break;
				case 5:
					int[] idx5 = { 1, 3 };
					temp(p.x, p.y, idx5);
					break;
				case 6:
					int[] idx6 = { 1, 2 };
					temp(p.x, p.y, idx6);
					break;
				case 7:
					int[] idx7 = { 0, 2 };
					temp(p.x, p.y, idx7);
					break;
				}
			}
		}
	}

	private static void temp(int x, int y, int[] index) {

		for (int d : index) {
			int nx = x + delta[d][0];
			int ny = y + delta[d][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;

			if (d == 0) {
				if (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7)
					continue;
			} else if (d == 1) {
				if (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6)
					continue;
			} else if (d == 2) {
				if (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7)
					continue;
			} else if (d == 3) {
				if (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5)
					continue;
			}

			if (isVisited[nx][ny] || map[nx][ny] == 0)
				continue;

			isVisited[nx][ny] = true;
			q.add(new Point(nx, ny));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			result = 0;
			isVisited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(R, C);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (isVisited[i][j]) {
						result++;
					}
				}
			}

			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
