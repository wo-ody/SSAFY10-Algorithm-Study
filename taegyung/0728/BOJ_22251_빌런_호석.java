package net.acmicpc;

import java.util.Scanner;

public class BOJ_22251_빌런_호석 {
	// k 자리수
	// 최소 1개, 최대 p개를 반전
	// 반전 후 1이상, N이하사 되도록 바꾼다.
	// x층일때, 반전시킬 LED를 고를 수 있는 경우의 수를 계산하라
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int P = sc.nextInt();
		String X = sc.next();

		while (X.length() < K) {
			X = "0" + X; // 0을 넣어줌
		}
//		System.out.println(X);
		// N 이하로 바꿀 수 있는 경우를 찾아야함.
		// 그럼 7개의 다이오드를 저장하고 있는 걸 확인? 하고
		// 범위 안의 수로 바꿀 수 있는 경우의 수로 바꿔야함.

		// 0 - 1111110 64+32+16+8+4+2
		// 1 - 0110000 32+16
		// 2 - 1101101 64+32+8+4+1
		// 3 - 1111001 64+32+16+8+1
		// 4 - 0110011 32+16+2+1
		// 5 - 1011011 64+16+8+2+1
		// 6 - 1011111 64+16+8+4+2+1
		// 7 - 1110000 64+32+16
		// 8 - 1111111 64+32+16+8+4+2+1
		// 9 - 1111011 64+32+16+8+2+1
		int diod[] = { 126, 48, 109, 121, 51, 91, 95, 112, 127, 123 };

		int answer = 0;
//		int[] answerList = new int[10];
//		int index = 0;
		for (int i = 1; i <= N; i++) { // 비교하는 수끼리 자리수가 다르면 앞에 0을 붙이자
			String s1 = Integer.toString(i);
//			if (i == 7)
//				System.out.print(1);
			while (s1.length() < K) { // 0을 넣어줌
				s1 = "0" + s1;
			}
			int cnt = 0;
			for (int j = 0; j < X.length(); j++) {

				int compare = diod[Character.getNumericValue(s1.charAt(j))]
						^ diod[Character.getNumericValue(X.charAt(j))];
				cnt += Integer.bitCount(compare);
				if (cnt > P)
					break;
			}
			if (cnt <= P && 1 <= cnt) {
				answer += 1;
//				answerList[index++] = i;
			}
		}
		System.out.println(answer);
//		for (int i = 0; i < index; i++)
//			System.out.print(answerList[i] + " ");
		// 9**6 < 54만 -> 완탐 가능할 듯

//		System.out.println(5 ^ 3);
	}
}
