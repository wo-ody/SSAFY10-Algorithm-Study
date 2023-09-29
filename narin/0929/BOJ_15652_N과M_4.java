import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N, M;
	private static int[] num, result;
	private static StringBuilder sb;

	private static void comb(int index, int count) {

		if (count == M) {
			for (int r : result) {
				sb.append(r).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = index; i < N; i++) {
			result[count] = num[i];
			comb(i, count + 1);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new int[N];
		result = new int[M];

		for (int i = 0; i < N; i++) {
			num[i] = i + 1;
		}

		comb(0, 0);

		System.out.println(sb);
	}
}
