package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_햄버거_다이어트 {
	// greedy문제네
	// 선호도는 조합된 재료들의 맛에 대한 점수의 합.
	// 같은 재료 여러번 x, 칼로리를 제외하면 제한이 없다.

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, L;
	static int[][] elements;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			elements = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				elements[i][0] = score;
				elements[i][1] = cal;

			}

			System.out.println("#" + testCase + " " + comb(0, 0, 0));
			// 정렬을 할 때 먼저 cal이 낮은 순으로 정렬하고, 그 다음 score이 높은 순으로 하나..?
//			Arrays.sort(elements, (o1, o2) -> o1[1] - o2[1]);
//			Arrays.sort(elements, (o1, o2) -> o2[0] - o1[0]);
////			System.out.println(Arrays.toString(elements));
//			int score = 0;
//			for (int[] element : elements) {
//				if (L >= element[1]) {
//					score += element[0];
//					L -= element[1];
//				}
//			}
//			System.out.println("#" + testCase + " " + score);
		}

	}

	static int comb(int nCal, int nScore, int srcIdx) {
		if (nCal > L)
			return Integer.MIN_VALUE;
		if (srcIdx == N) {
			return nScore;
		}
		return Math.max(comb(nCal + elements[srcIdx][1], nScore + elements[srcIdx][0], srcIdx + 1),
				comb(nCal, nScore, srcIdx + 1));
	}
}
