package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 왼쪽 탐색시 기울기가 감소해야 한다.
 * 2. 오른쪽 탐색시 기울기가 증가해야 한다.
 */
public class BOJ_1027_고층건물 {
	static int N, ans;
	static int[] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, count(i));
		}

		System.out.println(ans);
	}

	static int count(int idx) {
		double tmp = 0;
		int cnt = 0;

		// 왼쪽부터 탐색
		for (int i = idx - 1; i >= 0; i--) {
			double slope = (double) (map[idx] - map[i]) / (idx - i);
			if (i == idx - 1 || tmp > slope) {
				cnt++;
				tmp = slope;
			}
		}

		// 오른쪽 탐색
		for (int i = idx + 1; i < N; i++) {
			double slope = (double) (map[idx] - map[i]) / (idx - i);
			if (i == idx + 1 || tmp < slope) {
				cnt++;
				tmp = slope;
			}
		}

		return cnt;
	}
}
