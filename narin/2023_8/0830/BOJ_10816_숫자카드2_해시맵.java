import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	private static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> count = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (count.containsKey(temp)) {
				count.replace(temp, count.get(temp) + 1);
			} else {
				count.put(temp, 1);
			}
		}

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int find = Integer.parseInt(st.nextToken());
			if (count.get(find) == null) {
				count.put(find, 0);
			}
			sb.append(count.get(find) + " ");
		}

		System.out.println(sb);
	}
}
