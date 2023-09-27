package bj.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1389_케빈베이컨의6단계법칙 {
	static int N, M, ans, min = Integer.MAX_VALUE;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], 500000000);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a - 1][b - 1] = 1;
			arr[b - 1][a - 1] = 1;
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) {
						continue;
					}
					if (arr[i][k] >= 1 && arr[k][j] >= 1) {
						arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if (i == j) {
					continue;
				}
				sum += arr[i][j];
			}
			if (min > sum) {
				min = sum; // 새로 갱신해주고
				ans = i;
			}
		}
		
		System.out.println(ans + 1);
	}
}
