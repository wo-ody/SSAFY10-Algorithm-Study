import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int[] origin, copy;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		origin = new int[N];
		copy = new int[N];
		HashMap<Integer, Integer> num = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			origin[i] = Integer.parseInt(st.nextToken());
			copy[i] = origin[i];
		}

		Arrays.sort(copy);

		int n = 0;
		for (int i = 0; i < N; i++) {
			if (!num.containsKey(copy[i])) {
				num.put(copy[i], n++);
			}
		}

		for (int i = 0; i < N; i++) {
			sb.append(num.get(origin[i]) + " ");
		}

		System.out.println(sb);

	}
}
