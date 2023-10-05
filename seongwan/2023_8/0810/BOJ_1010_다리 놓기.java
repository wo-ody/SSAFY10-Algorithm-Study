import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T, N, M;// 테스트 케이스,서쪽 사이트, 동쪽 사이트
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			input();
			sb.append(comb(M, N) + "\n");

		}
		System.out.println(sb);
	}

	static void input() throws NumberFormatException, IOException {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M + 1][N + 1];
	}

	static int comb(int M, int N) {
		if (N == 0 || M == N) {
			return arr[M][N] = 1;
		} else {
			if (arr[M][N] != 0)
				return arr[M][N];//구했던 부분은 다시 구하지 않고 메모이제이션을 이용함
			return arr[M][N] = comb(M - 1, N - 1) + comb(M - 1, N);
		}
	}// 조합식을 나눠서 조합의 개수를 구함
}
