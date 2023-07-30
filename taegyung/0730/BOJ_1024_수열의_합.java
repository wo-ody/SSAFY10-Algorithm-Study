package net.acmicpc;

import java.util.Scanner;

public class BOJ_1024_수열의_합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long N = sc.nextLong();
		long L = sc.nextLong();

		/*
		 * 길이가 L로 고정됐다고 생각해보자. L이면서 합이 N이 되는 연속된 수는 구하기가 쉽지 않나..? 음 중간값이 N/L이고 좌 우 합쳐서
		 * L개만큼 있다고 생각을 하면 예 ) 4를 가운데 두고 3만큼 이면 3 4 5가 될 것 그럼 합은 12가 된다. N = 12 L = 3 N
		 * / L = 4
		 * 
		 * 다시 N == 20 L == 5 N / L = 4 2 3 4 5 6 4 + 8 + 8 == 20 되네 홀수도 확인해보자
		 * 
		 * N == 21 L == 6 N / L == 3 1 2 3 4 5 6 3 + 3 + 9 + 6 = 21
		 */

//		for(int i = L / 2; i < L )
		boolean done_flag = false;
		while (L <= 100) {

			long start = N / L - (L - 1) / 2;
			if (start < 0) {
				break;
			}

			if (N == (start * 2 + L - 1) * L / 2) {
				for (long i = 0; i < L; i++) {
					System.out.print(start + i + " ");
				}
				done_flag = true;
				break;
			}
			L += 1;
		}
		if (!done_flag) {
			System.out.println(-1);
		}

	}
}
