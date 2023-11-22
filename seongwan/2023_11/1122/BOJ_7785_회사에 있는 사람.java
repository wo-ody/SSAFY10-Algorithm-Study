import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static Map<String, String> map = new HashMap<>();
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}

		List<String> keyset = new ArrayList<>(map.keySet());

		Collections.sort(keyset, (e1, e2) -> e2.compareTo(e1));

		for (String s : keyset) {
			if (map.get(s).equals("enter")) {
				sb.append(s + "\n");
			}
		}
		System.out.println(sb);
	}
}
