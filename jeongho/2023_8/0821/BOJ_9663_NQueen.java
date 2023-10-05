package algorithm2023.aug.day21;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9663_NQueen {
	static int N, board[][], cnt;
	static int isQueen[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isQueen = new int[N];
		N_Queen(0);
		System.out.println(cnt);
	}

	static void N_Queen(int r) {
		if (r == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			isQueen[r] = i;
			if (isPromising(r)) {
				N_Queen(r + 1);
			}
		}

	}

	static boolean isPromising(int r) {

		for (int i = 0; i < r; i++) {
			if (isQueen[r] == isQueen[i] || Math.abs(r - i) == Math.abs(isQueen[r] - isQueen[i]))
				return false;
		}
		return true;
	}
}
