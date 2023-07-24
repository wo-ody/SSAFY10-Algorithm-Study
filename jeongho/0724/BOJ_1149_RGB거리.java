package algorithm2023.jul.day24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_BOJ1149 {
	static int N;
	static int[][] cost;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		//각 집을 색칠하는 비용을 3개의 색깔 따로 저장
		cost = new int[N][3];
		//0번째 집부터 색칠했을 때 N-1번째 집을 특정 색으로 칠하는 최솟값
		dp = new int[N][3];
		//최솟값을 저장하기 위해 max_value로 fill
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		// 입력
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		//0번째 인덱스의 모든 색을 따로 출발
		for (int i = 0; i < 3; i++) {
			paint(0, i, 0);
		}
		int min = Integer.MAX_VALUE;
		//N-1번째 집까지 칠하는 동안의 최솟값 구함
		for(int i= 0;i<3;i++) {
			min = Math.min(min, dp[N-1][i]);
		}
		System.out.println(min);
	}

	static void paint(int cur, int prevColor, int sum) {
		//범위를 벗어나면 종료
		if (cur == N) {
			return;
		}
		//현재까지 색칠한 값의 합
		sum+=cost[cur][prevColor];
		//최솟값을 갱신할 수 있다면 탐색
		if (dp[cur][prevColor] >sum) {
			dp[cur][prevColor] =sum;
			for (int i = 0; i < 3; i++) {
				if (i != prevColor) {
					paint(cur + 1, i, sum);
				}
			}
		}
	}
}
