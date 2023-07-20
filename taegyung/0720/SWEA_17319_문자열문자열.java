package swea;

import java.util.Scanner;

public class SWEA_17319_문자열문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = sc.nextInt();
//			System.out.println(N);
			String S = sc.next();
//			System.out.println(S);
//			System.out.println(S);
//			System.out.println(S.substring(N / 2));
//			System.out.println(S);
			if (N % 2 == 1)
				System.out.println("#" + testCase + " No");
			else {// 가능할 수도

				if (S.substring(0, N / 2).equals(S.substring(N / 2))) {
					System.out.println("#" + testCase + " Yes");
				} else
					System.out.println("#" + testCase + " No");
			}
		}
	}
}
