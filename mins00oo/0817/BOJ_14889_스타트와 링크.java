package bj.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14889_스타트와링크 {
	static int N;
	static int[][] map;
	static boolean[] visit;

	static int Min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combi(0, 0);
		System.out.println(Min);

	}

	static void combi(int idx, int count) {
		// 팀 조합이 완성될 경우
		if (count == N / 2) {
			/*
			 * 방문한 팀과 방문하지 않은 팀을 각각 나누어 각 팀의 점수를 구한 뒤 최솟값을 찾는다.
			 */
			diff();
			return;
		}

		for (int i = idx; i < N; i++) {
			// 방문하지 않았다면?
			if (!visit[i]) {
				visit[i] = true; // 방문으로 변경
				combi(i + 1, count + 1); // 재귀 호출
				visit[i] = false; // 재귀가 끝나면 비방문으로 변경
			}
		}
	}

	// 두 팀의 능력치 차이 계산
	static void diff() {
		int team_start = 0;
		int team_link = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				// i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스
				if (visit[i] == true && visit[j] == true) {
					team_start += map[i][j];
					team_start += map[j][i];
				}
				// i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스
				else if (visit[i] == false && visit[j] == false) {
					team_link += map[i][j];
					team_link += map[j][i];
				}
			}
		}
		// 두 팀의 점수 차이 (절댓값)
		int val = Math.abs(team_start - team_link);

		Min = Math.min(val, Min);

	}
}
