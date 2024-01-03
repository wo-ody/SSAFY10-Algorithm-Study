package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2188_축사_배정 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[][] cows;
	static int[] house;

	static boolean[] done;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		cows = new int[N + 1][];
		house = new int[M + 1];
		Arrays.fill(house, 0);
		done = new boolean[M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cntCows = Integer.parseInt(st.nextToken());

			cows[i] = new int[cntCows];
			for (int c = 0; c < cntCows; c++) {
				cows[i][c] = Integer.parseInt(st.nextToken());
			} // 소 저장
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			Arrays.fill(done, false);
			if (dfs(i))
				cnt++;
		}
		System.out.println(cnt);
	}

	static boolean dfs(int Node) {

		for (int want : cows[Node]) {
			if (done[want])
				continue;
			done[want] = true;

			if (house[want] == 0 || dfs(house[want])) {
				house[want] = Node;
				return true;
			}
		}
		return false;
	}
}
