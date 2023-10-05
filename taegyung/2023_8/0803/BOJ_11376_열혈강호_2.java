package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11376_열혈강호_2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[][] workers;
	static int[] workCntPerWorkers;
	static boolean[] done;
	static int[] works;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		workers = new int[N + 1][];
		workCntPerWorkers = new int[N + 1];
		Arrays.fill(workCntPerWorkers, 0);
		done = new boolean[M + 1];
		works = new int[M + 1];
		Arrays.fill(works, 0);
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int wCnt = Integer.parseInt(st.nextToken());
			workers[i] = new int[wCnt];
			for (int j = 0; j < wCnt; j++) {
				workers[i][j] = Integer.parseInt(st.nextToken());
			} // 다 저장
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int wCnt = 0; wCnt < 2; wCnt++) {

				Arrays.fill(done, false);
				if (dfs(i)) {
					cnt++;
				}
			}

		}

		System.out.println(cnt);

	}

	static boolean dfs(int node) {

		for (int i : workers[node]) {
			if (done[i])
				continue;
			done[i] = true;
			if (works[i] == node)
				continue; // 내가 한 일은 다시 안본다.
			if (works[i] == 0 || dfs(works[i])) {
				works[i] = node;
				return true;
			}
		}
		return false;
	}
}
