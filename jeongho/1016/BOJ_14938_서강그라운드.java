package algorithm2023.oct.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14938_서강그라운드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, m, r, map[][], item[];

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		item = new int[n];
		map = new int[n][n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(map[i], 999_999_999);
			map[i][i] = 0;
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int l = Integer.parseInt(st.nextToken());
			map[s][e] = l;
			map[e][s] = l;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		int max = 0;

//		for(int i =0;i<n;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println();

		for (int i = 0; i < n; i++) {
			max = Math.max(max, dijkstra(i));
		}
		System.out.println(max);

	}

	static int dijkstra(int i) {

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		pq.add(new int[] { i, 0 });
		int[] dijk = new int[n];
		Arrays.fill(dijk, 999_999_999);
		dijk[i] = 0;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			for (int j = 0; j < n; j++) {
				int next = cur[1] + map[cur[0]][j];
				if (next < dijk[j]) {
					dijk[j] = next;
					pq.add(new int[] { j, next });
				}
			}
		}
		int cnt = 0;
		for (int j = 0; j < n; j++) {
			if (dijk[j] <= m)
				cnt += item[j];
		}
		return cnt;

	}
}
