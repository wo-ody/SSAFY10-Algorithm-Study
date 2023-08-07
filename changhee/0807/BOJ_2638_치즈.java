/*
 *	08.07 김창희
 *	BOJ_2638_치즈
 *
 *	[풀이]
 *  1. 2636번과 비슷한 문제지만 변이 2개가 노출된 치즈만 녹는다는 조건이 추가되었다.
 *  2. 하나의 칸은 상하좌우로 방문하기 때문에 해당 칸이 치즈이면 방문한 횟수를 저장하여 2이상이면 지워주는 작업을 반복한다.
 *  3. 치즈를 지울때마다 카운트를 1씩증가 시키며 카운트가 0일때까지 반복한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		while (bfs(0, 0) > 0) {
			answer++;

		}
		System.out.println(answer);
	}

	public static int bfs(int startX, int startY) {
		Queue<Node> q = new ArrayDeque<>();
		int[][] count = new int[n][m];
		boolean[][] v = new boolean[n][m];
		int result = 0;

		q.offer(new Node(startX, startY));

		while (!q.isEmpty()) {
			Node node = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;

				if (!v[nx][ny]) {
					if (map[nx][ny] == 1) {
						if (++count[nx][ny] < 2)
							continue;
						v[nx][ny] = true;
						map[nx][ny] = 0;
						result++;
					} else {
						v[nx][ny] = true;
						q.offer(new Node(nx, ny));
					}
				}
			}
		}
		return result;
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
