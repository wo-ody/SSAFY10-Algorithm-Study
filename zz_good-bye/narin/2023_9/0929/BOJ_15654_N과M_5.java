import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int N, M;
	private static int[] num, result;
	private static boolean[] isVisited;
	private static StringBuilder sb;

	private static void comb(int index, int count) {

		if (count == M) {
			for (int r : result) {
				sb.append(r + " ");
			}
			sb.append("\n");

			return;
		}

		for (int i = 0; i < N; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				result[count] = num[i];
				comb(i + 1, count + 1);
				isVisited[i] = false;
			}
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
		isVisited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		comb(0, 0);

		System.out.println(sb);
	}
}
