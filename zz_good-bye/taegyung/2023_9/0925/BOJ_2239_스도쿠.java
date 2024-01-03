package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2239_스도쿠 {
	static int[][] sdoku;
	static boolean end = false;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sdoku = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String line = br.readLine();

			for (int j = 0; j < 9; j++) {
				sdoku[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
			}

		}

		// 입력 완료

		// 0이면 아직 비워져있는 공간

		// 사전식으로 앞서려면 왼쪽 위부터 작은수부터 넣을 수 있는지 확인하면서 넣는다.

		// 완탐형식으로 돌면 어떻게 되지
		// 9 * 9 * 9 정도니까 추ㅜㅜㅜㅜㅜㅜㅇ 분해

//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				if (sdoku[i][j] == 0) {
//					// TODO 내 함수가 들어갈 자리
//				}
//			}
//		}

//		for (int i = 0; i < 81; i++) {
//			if (!end) {
//				fill(i);
//			}
//		}
		fill(0);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				// TODO 내 함수가 들어갈 자리
				System.out.print(sdoku[i][j]);

			}
			System.out.println();
		}

	}

	public static void fill(int depth) { // 여까지 확인했다는걸 의미하자

		if (depth == 81) {
			end = true;
			return;
		}
		int x = depth / 9;
		int y = depth % 9;

		if (sdoku[x][y] == 0) {
			for (int n = 1; n <= 9; n++) {
				if (!can_fill(x, y, n))
					continue;

				sdoku[x][y] = n;

				fill(depth + 1);
				if (end)
					return;
				sdoku[x][y] = 0;

			}
		} else {
			fill(depth + 1);
		}
	}

	public static boolean can_fill(int x, int y, int num) {
		// 3으로 나누고 3을 곱해서 범위를 구해

		for (int i = 3 * (x / 3); i < 3 * (x / 3 + 1); i++) {
//			System.out.print(i);
			for (int j = 3 * (y / 3); j < 3 * (y / 3 + 1); j++) {
				// 박스 먼저
				if (sdoku[i][j] == num)
					return false;
			}

		}
//		System.out.println();
		for (int i = 0; i < 9; i++) {
			if (sdoku[i][y] == num)
				return false;
			if (sdoku[x][i] == num)
				return false;
		}
		return true;
	}

}
