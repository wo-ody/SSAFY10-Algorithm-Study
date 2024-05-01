import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static Map<String, Integer> map = new HashMap<>();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int amount = Integer.parseInt(st.nextToken());

			if (map.containsKey(name)) {
				map.put(name, map.get(name) + amount);
			} else {
				map.put(name, amount);
			}
		}

		List<String> keys = new ArrayList<>(map.keySet());

		for (int i = 0; i < keys.size(); i++) {
			for (int j = i + 1; j < keys.size(); j++) {
				if ((int)(map.get(keys.get(i)) * 1.618) == map.get(keys.get(j)) ||
					(int)(map.get(keys.get(j)) * 1.618) == map.get(keys.get(i))) {
					System.out.println("Delicious!");
					return;
				}
			}
		}
		System.out.println("Not Delicious...");
	}
}