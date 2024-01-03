package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드 {
	static int[][] cities;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		cities = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				cities[i][j] = Integer.MAX_VALUE / 2;
			}
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			cities[start][dest] = Math.min(cities[start][dest], cost);

			// 최소값을 저장

		}

		// 갈 수 없는 경우는 0을 출력

		floyd_warshall();
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				System.out.print(cities[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void floyd_warshall() {

		for (int m = 1; m < n + 1; m++) {
			// 노드 하나씩 중간 노드로

			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (m == i || m == j || i == j)
						continue;

					cities[i][j] = Math.min(cities[i][m] + cities[m][j], cities[i][j]);
					// floyd_warshall
				}
			}

		}
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (cities[i][j] == Integer.MAX_VALUE / 2)
					cities[i][j] = 0;
			}
		}
	}

}
