import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static HashMap<String, Integer> map = new HashMap();
	static int N;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (!map.containsKey(s))
				map.put(s, 1);
			else {
				map.put(s, map.get(s) + 1);
			}
		}

		List<String> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet, (e1, e2) -> map.get(e2) == map.get(e1) ? e1.compareTo(e2) : map.get(e2) - map.get(e1));
		System.out.println(keySet.get(0));
	}

}
