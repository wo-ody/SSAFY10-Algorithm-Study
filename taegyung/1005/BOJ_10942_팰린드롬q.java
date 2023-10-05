package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942_팰린드롬q {
	static boolean[][] visited;
	static boolean[][] palindrome;
	static int[] numArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		numArr = new int[N];

		palindrome = new boolean[N][N];
		visited = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) { // 당연
			palindrome[i][i] = true;
			visited[i][i] = true;

		}

		for (int i = 0; i < N; i++) {
//			for (int j = i + 1; j < N; j++) {

//				if (!visited[i][N-1])
			pal(0, i); //
//			}
		}
		for (int i = 1; i < N; i++) {
			pal(i, N - 1);
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(palindrome[i]));
//		}

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			sb.append(palindrome[s - 1][e - 1] ? 1 : 0).append("\n");
		}
		System.out.println(sb);

	}

	public static boolean pal(int i, int j) {
		if (visited[i][j])
			return palindrome[i][j];

		visited[i][j] = true;

		if (i + 1 == j) {
			// 하나차이
//			System.out.println(i + " " + j);
			if (numArr[i] == numArr[j]) {
				palindrome[i][j] = true;
			}
			return palindrome[i][j];
		} else { // 하나보다 큰 차이가 날 때
			if (pal(i + 1, j - 1) && numArr[i] == numArr[j]) // 재귀형식
				return palindrome[i][j] = true;
			else {
				return false;
			}

		}
	}
}
