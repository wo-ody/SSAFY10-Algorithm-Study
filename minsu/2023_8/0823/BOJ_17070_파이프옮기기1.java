package bj.G5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 시간이 너무 오래는 걸리는듯하다..
 * -> 그래서 처음에 for문으로 가져오는거 말고 현재 방향에 맞춰서 확인해야 할 것들을 isValid로 확인해주면서 true면 큐에 넣어주는식으로
 * 또, nx, ny가 마지막 행이나 열에 위치한다면 가로나 세로로는 이동을 못하기 때문에 이 부분은 미리 가지치기를 하면 좀 시간이 줄어든다.
 */
public class BOJ_17070_파이프옮기기1 {
	static int N, cnt;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 마지막 지점이 1(벽)인 경우 바로 0으로 처리를 시켜준다면 시간초과 통과
		if (map[N][N] == 1) {
			System.out.println(0);
		} else {
			bfs(1, 2, 0);
			System.out.println(cnt);
		}

	}

	static void bfs(int x, int y, int d) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(x, y, d));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int nowX = node.x;
			int nowY = node.y;
			int nd = node.d;

			if (nowX == N && nowY == N) {
				cnt++;
				continue;
			} else if (nowX == N && nd == 2) {
				continue;
			} else if (nowY == N && nd == 0) {
				continue;
			}
			// 현재 가로 파이프라면 다음으로는 가로 혹은 대각으로만 이동 가능
			if (nd == 0) {
				if (isValid(node, 0)) {
					queue.offer(new Node(nowX, nowY + 1, 0));
				}
				if (isValid(node, 1)) {
					queue.offer(new Node(nowX + 1, nowY + 1, 1));
				}
			} else if (nd == 1) {
				if (isValid(node, 0)) {
					queue.offer(new Node(nowX, nowY + 1, 0));
				}
				if (isValid(node, 1)) {
					queue.offer(new Node(nowX + 1, nowY + 1, 1));
				}
				if (isValid(node, 2)) {
					queue.offer(new Node(nowX + 1, nowY, 2));
				}
			} else if (nd == 2) {
				if (isValid(node, 1)) {
					queue.offer(new Node(nowX + 1, nowY + 1, 1));
				}
				if (isValid(node, 2)) {
					queue.offer(new Node(nowX + 1, nowY, 2));
				}
			}

		}
	}

	static boolean isValid(Node node, int now) {
		if (now == 0) {
			if (node.y + 1 <= N && map[node.x][node.y + 1] != 1) {
				return true;
			}
		} else if (now == 1) {
			if (node.x + 1 <= N && node.y + 1 <= N && map[node.x + 1][node.y + 1] != 1 && map[node.x][node.y + 1] != 1
					&& map[node.x + 1][node.y] != 1) {
				return true;
			}
		} else if (now == 2) {
			if (node.x + 1 <= N && map[node.x + 1][node.y] != 1) {
				return true;
			}
		}
		return false;
	}

	static class Node {
		int x, y, d; // d는 해당 좌표가 가로, 대각 ,세로 중 어떤 것인지

		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}
}
