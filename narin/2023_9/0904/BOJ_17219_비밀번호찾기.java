import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	private static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		HashMap<String, String> pw = new HashMap<>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String key = st.nextToken();
			String value = st.nextToken();

			pw.put(key, value);
		}

		for (int i = 0; i < M; i++) {
			String q = br.readLine();
			sb.append(pw.get(q) + "\n");
		}

		System.out.println(sb);

	}
}
