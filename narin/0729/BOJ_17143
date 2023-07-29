package acmicpc.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17143 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 배열 입력 받기
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		int l = Math.min(N, M); // 가능한 가장 긴 정사각형 변의 길이

		while (true) {
			for (int i = 0; i <= N - l; i++) {
				for (int j = 0; j <= M - l; j++) {
					int mid = arr[i][j];
					if (mid == arr[i + l - 1][j] && mid == arr[i + l - 1][j + l - 1] && mid == arr[i][j + l - 1]) {
						System.out.println(l * l);
						return; // break의 경우 해당 조건문만 나오지만 return은 메소드 탈출
					}
				}
			}
			l--;
		}
	}
}
