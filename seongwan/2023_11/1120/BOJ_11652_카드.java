import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static HashMap<Long, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else
				map.put(num, 1);
		}

		List<Long> keyset = new ArrayList<>(map.keySet());
		Collections.sort(keyset,
				(e1, e2) -> map.get(e2).equals(map.get(e1)) ? e1.compareTo(e2) : map.get(e2) - map.get(e1));
		System.out.println(keyset.get(0));
	}
}