import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static Map<String, Integer> map = new HashMap<>();
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String time = st.nextToken();
			int hour = Integer.parseInt(time.substring(0, 2));
			int minute = (60 * hour) + Integer.parseInt(time.substring(3, 5));

			String name = st.nextToken();
			if (map.containsKey(name)) {
				map.put(name, map.get(name) + minute);
			} else {
				map.put(name, minute);
			}
		}

		for (String s : map.keySet()) {
			int fare = 10;
			int min = map.get(s);
			min -= 100;
			if (min > 0) {
				int count = min / 50;
				fare += count * 3;

				if (min % 50 > 0)
					fare += 3;
			}
			map.put(s, fare);
		}
		List<String> keys = new ArrayList<>(map.keySet());
		keys.sort((e1, e2) -> map.get(e1).equals(map.get(e2)) ? e1.compareTo(e2) : map.get(e2) - map.get(e1));

		for (String s : keys) {
			sb.append(s).append(" ").append(map.get(s)).append("\n");
		}

		System.out.println(sb);
	}
}