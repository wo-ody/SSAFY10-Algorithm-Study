package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1027_고층_건물 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] buildings = new int[N];
		for (int i = 0; i < N; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}

		int maxCnt = 0;

		for (int i = 0; i < N; i++) {
			double degree = 1000000000;
			int tCnt = 0;

			for (int j = i - 1; j >= 0; j--) {
				if (degree > (double) (buildings[j] - buildings[i]) / (j - i)) {
					degree = (double) (buildings[j] - buildings[i]) / (j - i);
					tCnt++;
				}
			}
			degree = -1000000000;
			for (int j = i + 1; j < N; j++) {
				if (degree < (double) (buildings[j] - buildings[i]) / (j - i)) {
					degree = (double) (buildings[j] - buildings[i]) / (j - i);
					tCnt++;
				}
			}
			maxCnt = Math.max(tCnt, maxCnt);
		}
		System.out.println(maxCnt);

	}
}
