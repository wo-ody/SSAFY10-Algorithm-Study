package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9205_맥주_마시면서_걸어가기 {
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		// 1000 미터 전에 편의점을 들러야한다.
		// 그럼 각 편의점별로 1000미터 안에 있는지, 잇다보면 목적지까지도 갈 수 있는지를 확인하자
		// 그럼

		for (int testCase = 0; testCase < T; testCase++) {
			int n = Integer.parseInt(br.readLine());

//			StringTokenizer st = new StringTokenizer(br.readLine());
//
//			int sang_x = Integer.parseInt(st.nextToken());
//			int sang_y = Integer.parseInt(st.nextToken());

			int[][] store = new int[n + 2][2];
			parents = new int[n + 2];
			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());

				parents[i] = i; // union find를 위함
				// 하나로 다 묶는 이유는 100번의 확인 끝에 처음과 마지막이 같은 루트를 바라보면 돼
			}
//			st = new StringTokenizer(br.readLine());
//			int rock_x = Integer.parseInt(st.nextToken());
//			int rock_y = Integer.parseInt(st.nextToken());

			// union find를 진행해도 될 것 같음

			// 100개의 편의점 각각에 대해

			for (int i = 0; i < n + 1; i++) {
				for (int j = i + 1; j < n + 2; j++) {
					if (Math.abs(store[i][0] - store[j][0]) + Math.abs(store[i][1] - store[j][1]) <= 1000) {
						// 도달할 수 있다.
						merge(i, j);
					}
				}
			}
			if (find_root(0) == find_root(n + 1)) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}
	}

	static void merge(int i, int j) {
		int pi = find_root(i);
		int pj = find_root(j);

		if (pi != pj) {
			parents[pi] = pj;
		}
	}

	static int find_root(int node) {
		if (node == parents[node])
			return node;
		return parents[node] = find_root(parents[node]);
	}
}
