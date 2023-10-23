import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] input, result;
	private static HashSet<String> set;
	private static StringBuilder sb;

	private static void comb(int index, int count) {

		if (count == M) {

			if (!set.contains(Arrays.toString(result))) {
				set.add(Arrays.toString(result));
				for (int r : result) {
					sb.append(r + " ");
				}
				sb.append("\n");
			}

			return;
		}

		for (int i = index; i < N; i++) {
			result[count] = input[i];
			comb(i, count + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N];
		result = new int[M];
		set = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);
		comb(0, 0);

		System.out.println(sb);

	}
}
