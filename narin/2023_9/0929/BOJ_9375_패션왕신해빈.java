import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());

			HashMap<String, Integer> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String type = st.nextToken();

				if (map.containsKey(type)) {
					map.replace(type, map.get(type) + 1);
				} else {
					map.put(type, 1);
				}
			}

			int result = 1;

			for (int v : map.values()) {
				// 해당 옷을 안 입을 수도 있음
				result *= (v + 1);
			}

			// 옷을 아예 안 입는 경우는 빼준다.
			sb.append(result - 1).append("\n");
		}

		System.out.println(sb);
	}
}
