import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static TreeMap<String, Float> map = new TreeMap<>();
	static StringBuilder sb = new StringBuilder();
	static float sum;

	public static void main(String[] args) throws Exception {
		while (true) {
			String s = br.readLine();

			if (s == null)
				break;
			sum++;
			if (map.containsKey(s))
				map.put(s, map.get(s) + 1);
			else
				map.put(s, (float) 1);
		}
		map.forEach((k, v) -> map.put(k, map.get(k) / sum * 100));
		map.forEach((k, v) -> sb.append((k + String.format(" %.4f\n", v))));
		System.out.println(sb);
	}
}