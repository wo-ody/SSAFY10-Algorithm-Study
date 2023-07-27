package silver;

import java.awt.List;
import java.util.Scanner;

public class BOJ_2468_안전_영역 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] graph = new int[N][N];

		int max_height = 0;
		int tmp;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp = sc.nextInt();
				graph[i][j] = tmp;
				max_height = Math.max(max_height, tmp);

			}
		}
		for (int i = 0; i < max_height; i++) { // 수위에 따라 확인하며 bfs로
			boolean[][] visited = new boolean[N][N];

			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (visited[x][y] == false && graph[x][y] >= i) {
						bfs(graph, x, y, visited);
					}
				}
			}

		}

	}

	static void bfs(int[][] arr, int root_x, int root_y, boolean[][] visited) {
		List a = new List<10>;
	}
}
