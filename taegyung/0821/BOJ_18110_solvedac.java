package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_18110_solvedac {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N];
		for (int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(scores);

		// 자르는 숫자를 찾자
		int cut = (int) Math.round(N * 0.15);
//		System.out.println(Math.round(N * 0.15));

		int sum = 0;
		for (int i = cut; i < N - cut; i++) {
			sum += scores[i];
		}
		System.out.println(Math.round((double) sum / (N - 2 * cut)));
	}
}
