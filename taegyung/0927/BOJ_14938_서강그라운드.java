package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14938_서강그라운드 {
	static int[][] areas;
	static int n, m, r;
	static int[] items;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		items = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		areas = new int[n + 1][n + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				areas[i][j] = Integer.MAX_VALUE / 2;

			}
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			areas[start][dest] = cost;
			areas[dest][start] = cost;

			// 저장 완료
		}

		floyd_warshall();

	}

	static void floyd_warshall() {

		for (int m = 1; m < n + 1; m++) {
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (m == i || m == j)
						continue;

					areas[i][j] = Math.min(areas[i][j], areas[i][m] + areas[m][j]);
				}
			}
		}

		// 플로이드-와샬 끝

		// 이제 들를 수 있는 위치들을 확인하면서 아이템의 최대값을 구하자

		int max_items = Integer.MIN_VALUE;
		for (int i = 1; i < n + 1; i++) {
			int items_cnt = 0;

			for (int j = 1; j < n + 1; j++) {
				if (i == j || areas[i][j] <= m) {
					items_cnt += items[j];
				}
			}

			max_items = Math.max(max_items, items_cnt);
		}

		System.out.println(max_items);
	}

}
