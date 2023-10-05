import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N, ren, min;
	private static int[][] S;
	private static int[] start, link;

	private static void calc(int index, int count) {

		if (count == ren) {
			int[] memS = new int[ren];
			int[] memL = new int[ren];
			boolean[] isSelected = new boolean[N];

			int sumS = 0, sumL = 0;
			int idx = 0;

			for (int i = 0; i < ren; i++) {
				memS[idx++] = start[i];
				isSelected[start[i]] = true;
			}

			idx = 0;
			for (int i = 0; i < N; i++) {
				if (!isSelected[i]) {
					memL[idx++] = i;
				}
			}

			for (int i = 0; i < ren - 1; i++) {
				for (int j = i; j < ren; j++) {
					sumS += S[memS[i]][memS[j]] + S[memS[j]][memS[i]];
					sumL += S[memL[i]][memL[j]] + S[memL[j]][memL[i]];
				}
			}

			min = Math.min(min, Math.abs(sumS - sumL));

			return;
		}

		for (int i = index; i < N; i++) {
			start[count] = i;
			calc(i + 1, count + 1);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		ren = N / 2;
		S = new int[N][N];
		start = new int[ren];
		link = new int[ren];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		calc(0, 0);

		System.out.println(min);
	}
}
