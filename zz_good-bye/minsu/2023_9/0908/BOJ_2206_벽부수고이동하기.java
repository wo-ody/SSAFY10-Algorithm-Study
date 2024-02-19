package bj.G3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][][] visited = new int[N][M][2];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 1, 0 }); // x, y, distance, isBroken
		visited[0][0][0] = 1;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			int distance = current[2];
			int isBroken = current[3];

			if (x == N - 1 && y == M - 1) {
				System.out.println(distance);
				return;
			}

			for (int[] dir : directions) {
				int newX = x + dir[0];
				int newY = y + dir[1];

				if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
					if (visited[newX][newY][isBroken] == 0) {
						if (map[newX][newY] == 0) {
							queue.add(new int[] { newX, newY, distance + 1, isBroken });
							visited[newX][newY][isBroken] = 1;
						} else {
							if (isBroken == 0) {
								queue.add(new int[] { newX, newY, distance + 1, 1 });
								visited[newX][newY][1] = 1;
							}
						}
					}
				}
			}
		}
		System.out.println(-1);
	}
}
