package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2485_가로수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 최대 공약수를 구하는 방법을 생각해보자
		// 유클리드 호제법

		int[] trees = new int[N];

		for (int i = 0; i < N; i++)
			trees[i] = Integer.parseInt(br.readLine());

		int[] diffs = new int[N - 1];

		for (int i = 0; i < N - 1; i++)
			diffs[i] = trees[i + 1] - trees[i];

		int commonDivide = GCD(diffs[0], diffs[1]);
		for (int i = 1; i < N - 1; i++) {
//			System.out.println(commonDivide);
			commonDivide = GCD(commonDivide, diffs[i]);

		}

		int sum = 0;
		for (int i = 0; i < N - 1; i++)
			sum += diffs[i] / commonDivide - 1;

//		System.out.println(commonDivide);
		System.out.println(sum);

	}

	public static int GCD(int b1, int b2) {
		if (b2 == 0)
			return b1;
		else
			return GCD(b2, b1 % b2);
	}
}
