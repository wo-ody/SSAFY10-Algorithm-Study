/*
 *  08.30 김창희
 *  BOJ_16946_벽부수고이동하기4
 *
 *  [풀이]
 *  1. 0으로 이루어진 덩어리들에 numbering을 부여하며 총 몇개의 0으로 이루어져 있는지 배열에 표시한다.
 *  2. map을 돌며 1일 경우 상하좌우를 보며 합을 구하며, 중복되지 않는 numbering만 더해준다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static int[][] map;
	static int[][] label;
	static boolean[][] v;
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = temp[j] - 48;
			}
		}

		v = new boolean[n][m];
		label = new int[n][m];
		int numbering = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) map[i][j] = -1;
				if (map[i][j] == 0 && !v[i][j]) bfs(i, j, numbering++);
			}
		}

		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != -1) {
					answer.append("0");
					continue;
				}

				set.clear();
				int sum = 1;
				for (int x = 0; x < 4; x++) {
					int ni = i + dx[x];
					int nj = j + dy[x];

					if (ni < 0 || nj < 0 || ni >= n || nj >= m || map[ni][nj] == -1) continue;

					if (!set.contains(label[ni][nj])) {
						set.add(label[ni][nj]);
						sum += map[ni][nj];
					}
				}

				answer.append(sum%10);
			}
			answer.append("\n");

		}

		System.out.println(answer);
	}

	public static void bfs(int x, int y, int numbering) {
		Queue<Node> q = new ArrayDeque<>();
		Queue<Node> zero = new ArrayDeque<>();

		int count = 1;

		q.offer(new Node(x, y));
		zero.offer(new Node(x, y));
		v[x][y] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

				if (!v[nx][ny] && map[nx][ny] == 0) {
					v[nx][ny] = true;
					q.offer(new Node(nx, ny));
					zero.offer(new Node(nx, ny));
					count++;
				}
			}
		}

		while (!zero.isEmpty()) {
			Node node = zero.poll();
			map[node.x][node.y] = count;
			label[node.x][node.y] = numbering;
		}
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
