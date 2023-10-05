import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, R;
	private static int[][] S;
	private static int[] start, link;
	private static int min = Integer.MAX_VALUE;

	private static void comb(int count, int index) {

		if (count == R) {
			int[] memberS = new int[R];
			int[] memberL = new int[R];

			boolean[] isSelected = new boolean[N];
			int indexS = 0;
			for (int i = 0; i < R; i++) {
				memberS[indexS++] = start[i];
				isSelected[start[i]] = true;
			}

			int indexL = 0;
			for (int i = 0; i < N; i++) {
				if (!isSelected[i]) {
					memberL[indexL++] = i;
				}
			}

			int startSum = 0, linkSum = 0;

			for (int i = 0; i < R - 1; i++) {
				for (int j = i; j < R; j++) {
					startSum += S[memberS[i]][memberS[j]] + S[memberS[j]][memberS[i]];
					linkSum += S[memberL[i]][memberL[j]] + S[memberL[j]][memberL[i]];
				}
			}

			if (Math.abs(startSum - linkSum) < min) {
				min = Math.abs(startSum - linkSum);
			}

			return;
		}

		for (int i = index; i < N; i++) {
			start[count] = i;
			comb(count + 1, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		R = N / 2;
		S = new int[N][N];
		start = new int[R];
		link = new int[R];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 0);

		System.out.println(min);
	}
}
