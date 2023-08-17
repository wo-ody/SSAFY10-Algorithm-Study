/*
 *  08.16 김창희
 *  BOJ_17182_우주탐사선
 *
 *  [풀이]
 *  1. 재귀로 모든 경우(갈수 있는 경로)를 탐색하면 시간초과발생.
 *  2. 플로이드 워셜로 모든 노드에 대해 최단 경로를 구한다(n이 최대 10이라서 가능)
 *  3. 출발점부터 순열을 통해 최단거리를 구한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[] v;
	static int n, k, answer = Integer.MAX_VALUE;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
					// map[x][y]에 가기 위해 i를 경유한다.
					map[x][y] = Math.min(map[x][y], map[x][i] + map[i][y]);
				}
			}
		}

		v = new boolean[n];
		v[k] = true;
		traversal(k, 1, 0);
		System.out.println(answer);
	}

	public static void traversal(int start, int depth, int dist) {
		if (depth == n) {
			answer = Math.min(answer, dist);
			return;
		}

		for (int i = 0; i < n; i++) {
			if(!v[i] && i!=start) {
				v[i] = true;
				traversal(i,depth+1,dist+map[start][i]);
				v[i] = false;
				
			}
		}
	}
}
