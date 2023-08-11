/*
 *	08.11 김창희
 *	BOJ_2234_성곽
 *
 *	[풀이]
 *  1. 배열 자체를 Node 배열로 생성을 해서 동 서 남 북에 대한 벽 정보를 저장해서 bfs를 탐색한다.
 *  2. 각 칸마다 numbering을 하여 벽을 부수는 경우를 가정하여 최대값을 구한다. 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static Node[][] map;
	static int[] rCount = new int[2501];
	static int[] dx = { 0, -1, 0, 1 }, dy = { -1, 0, 1, 0 };
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new Node[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = new Node(i, j);
				setBlock(Integer.parseInt(st.nextToken()), map[i][j]);
			}
		}

		int[] answer = new int[3];
		boolean[][] v = new boolean[n][m];
		int numbering = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!v[i][j]) {
					int count = findMaxRoom(v, i, j, numbering);
					rCount[numbering++] = count;

					answer[0]++;
					answer[1] = Math.max(answer[1], count);
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				answer[2] = Math.max(answer[2], union(i, j));
			}
		}
		
		System.out.println(answer[0] + "\n" + answer[1] + "\n" + answer[2]);

	}
	
	public static void setBlock(int number, Node node) {
		String temp = Integer.toBinaryString(number);
		int[] result = new int[4];
		for (int i = 0; i < temp.length(); i++)
			result[i] = temp.charAt(temp.length() - i - 1) - 48;
		node.road = result;
	}

	public static int findMaxRoom(boolean[][] v, int startX, int startY, int numbering) {
		Queue<Node> q = new ArrayDeque<>();
		int result = 1;

		q.offer(new Node(startX, startY));
		map[startX][startY].numbering = numbering;
		v[startX][startY] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int x = 0; x < 4; x++) {
				int nx = node.x + dx[x];
				int ny = node.y + dy[x];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;

				if (!v[nx][ny] && map[node.x][node.y].road[x] == 0) {
					result++;
					v[nx][ny] = true;
					map[nx][ny].numbering = numbering;
					q.offer(new Node(nx, ny));
				}
			}
		}
		return result;
	}

	public static int union(int x, int y) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;

			int n1 = map[x][y].numbering;
			int n2 = map[nx][ny].numbering;
			if (n1 != n2)
				result = Math.max(result, rCount[n1] + rCount[n2]);
		}
		return result;
	}

	static class Node {
		int x, y, numbering;
		int[] road;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			this.road = new int[4];
		}
	}
}
