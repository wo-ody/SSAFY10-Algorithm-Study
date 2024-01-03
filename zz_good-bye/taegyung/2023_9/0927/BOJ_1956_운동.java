package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1956_운동 {
	static int[][] town;
	static int V, E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		town = new int[V + 1][V + 1];
		for (int i = 0; i < V + 1; i++) {
			for (int j = 0; j < V + 1; j++) {
				town[i][j] = Integer.MAX_VALUE / 2;
			}
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			town[start][dest] = cost;
		}

		// -1이면 갈 수 없는 곳.
		floyd_warshall();

	}

	// 딱 하나의 사이클만 있으면 된다. // 그럼 자기 자신으로 돌아오는것도 확인하면 되겠다
	public static void floyd_warshall() {

		for (int m = 1; m < V + 1; m++) {
			for (int i = 1; i < V + 1; i++) {
				for (int j = 1; j < V + 1; j++) {
					if (m == i || m == j)
						continue;

					if (town[i][j] > town[i][m] + town[m][j]) {
						town[i][j] = town[i][m] + town[m][j];
					}

//					else if (town[i][j] > town[i][m])

					// 끝
				}
			}
		}
		int min_cost = town[1][1];

		for (int i = 1; i < V + 1; i++) {
//			if (town[i][i] )
			if (town[i][i] != Integer.MAX_VALUE / 2)
				min_cost = Math.min(min_cost, town[i][i]);
		}

		if (min_cost == Integer.MAX_VALUE / 2)
			System.out.println(-1);
		else
			System.out.println(min_cost);
//		for (int i = 1; i < V + 1; i++) {
//			for (int j = 1; j < V + 1; j++)
//				System.out.print(town[i][j] + " ");
//			System.out.println();
//		}

	}
}
