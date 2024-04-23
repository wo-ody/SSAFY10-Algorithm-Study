import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static final String[] string =
		{"zero", "one", "two", "three", "four", "five",
			"six", "seven", "eight", "nine"};

	static int M, N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] ans;
	static StringBuilder sb = new StringBuilder();
	static Map<String, Integer> map = new HashMap<>();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		ans = new String[N - M + 1];
		for (int i = M; i <= N; i++) {
			if (i <= 9) {
				ans[i - M] = string[i];
			} else {
				ans[i - M] = string[i / 10] + " " + string[i % 10];
			}
		}

		Arrays.sort(ans);
		mapping();

		for (int i = 0; i < ans.length; i++) {
			st = new StringTokenizer(ans[i]);
			if (st.countTokens() == 1) {
				sb.append(map.get(st.nextToken())).append(" ");
			} else {
				int temp = map.get(st.nextToken()) * 10 + map.get(st.nextToken());
				sb.append(temp).append(" ");
			}

			if ((i + 1) % 10 == 0)
				sb.append("\n");
		}
		System.out.println(sb);
	}

	static void mapping() {
		for (int i = 0; i < 10; i++) {
			map.put(string[i], i);
		}
	}
}