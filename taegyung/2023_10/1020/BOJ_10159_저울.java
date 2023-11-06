package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10159_저울 {
	static boolean[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		graph = new boolean[N][N];
		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int before = Integer.parseInt(st.nextToken()) - 1;
			int after = Integer.parseInt(st.nextToken()) - 1;

			graph[before][after] = true;
		}

		for (int m = 0; m < N; m++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (graph[i][m] && graph[m][j])
						graph[i][j] = true;
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(graph[i]));
//		}

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j]) {
					arr[i] += 1;
					arr[j] += 1;
				}
			}
		}
//		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < N; i++) {
			System.out.println(N - 1 - arr[i]);
		}

	}
}
