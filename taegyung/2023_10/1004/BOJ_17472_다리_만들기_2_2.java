package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리_만들기_2_2 {
	static int[][] island;

	static int N, M;
	static ArrayList<Integer> parents = new ArrayList<>();
	static int parentsCnt = 2;

	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		island = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				island[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// parents는 새로 나올때마다 만들어줄거임
		// 근데 2부터 볼까
		parents.add(-1);
		parents.add(-1);

		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (island[i][j] == 1) {
					init_bfs(i, j, parentsCnt);
					parents.add(parentsCnt++);
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(island[i]));
//		}

		// TODO MST -> UnionFind
		// TODO bfs -> 같은 섬인지를 나타내야함.
		// TODO 섬이 최대 6개라고 하니까 섬 별로 parent를 나타낼까

		// TODO visited를 처리해서 같은 섬이 아니면 새로 parent를 만들어서 확인
//		for (int i = 2; i < parents.size(); i++) {
//			System.out.println(parents.get(i));
//		}
//
//		mergeParent(3, 4);
//		for (int i = 2; i < parents.size(); i++) {
//			System.out.println(parents.get(i));
//		}

//		System.out.println(MST());
		int result = MST();

		// 마지막에 다 연결 안됐을 수도 있다.
		boolean flag = true;
		int compare_parent = getParent(2);
		for (int i = 3; i < parents.size(); i++) {
			if (compare_parent != getParent(i))
				flag = false;
		}
		if (flag)
			System.out.println(result);
		else
			System.out.println(-1);
	}

	public static int MST() {
		// 각 점을 돌면서 섬이면 -> 네 방향으로 섬을 만날 때 까지 -> pq에 넣는다.
		// -> 나중에 pq를 한번에 다 빼면서 확인한다.

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o1[0] - o2[0];
		});

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (island[i][j] != 0) { // 섬이면
					// 네 방향 돌면서 확인
					for (int d = 0; d < 4; d++) {
						int x = i + dx[d];
						int y = j + dy[d];

						while (x >= 0 && x < N && y >= 0 && y < M) {
							if (island[x][y] != 0) {
								if (island[x][y] == island[i][j]) { // 내 섬을 만남
									break;
								} else { // 다른 섬 만남 -> 이게 최소인지를 확인하기 위해 pq에 넣음
									pq.offer(new int[] { Math.abs(x - i) + Math.abs(y - j) - 1, island[i][j],
											island[x][y] }); // 거리, 이을 두 섬 번호
									break;
								}
							}
							x += dx[d];
							y += dy[d];
						}
					}
				}
			}
		}

		// 마지막에 pq 하나씩 빼면서 union find 확인하면서 값 더함

		int result = 0;
		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();

			if (tmp[0] >= 2 && mergeParent(tmp[1], tmp[2])) {
//				System.out.println(Arrays.toString(tmp));
				result += tmp[0];
			}
		}

		return result;

	}

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void init_bfs(int start_x, int start_y, int islandNum) {

//		visited[start_x][start_y] = true;
		island[start_x][start_y] = islandNum;

		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { start_x, start_y });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for (int d = 0; d < 4; d++) {

				int nx = tmp[0] + dx[d];
				int ny = tmp[1] + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				if (island[nx][ny] == 1) {
					queue.offer(new int[] { nx, ny });
					island[nx][ny] = islandNum; // 바꿔줌 ( visited 역할)
				}
			}
		}
		// 다 돌고 나면 island 자체가 바뀌어있을거임

	}

	public static int getParent(int p) {
		if (p == parents.get(p))
			return p;
//		parents.
		parents.set(p, getParent(parents.get(p)));
		return parents.get(p);
	}

	public static boolean mergeParent(int p1, int p2) {
		if (getParent(p1) == getParent(p2)) { // 같으면 합치면 안됨
			return false;
		} else {
			parents.set(getParent(p1), p2);
			return true;
		}
	}
}
