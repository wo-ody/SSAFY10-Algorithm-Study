package acmicpc.step3;

import java.util.Scanner;

public class L3_2438 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (i >= j)
//					System.out.print('*');
//			}
//			System.out.println();
//		}

		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if (i < j)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}

		sc.close();
	}

}

// 2438 별찍기 + 2439 별찍기
