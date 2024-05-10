import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, Integer> map = new TreeMap<>((e1, e2) -> e1.length() == e2.length() ?
			e1.compareTo(e2) : e1.length() - e2.length());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int num = Integer.parseInt(st.nextToken());

			if (map.containsKey(s)) {
				map.put(s, map.get(s) + num);
			} else {
				map.put(s, num);
			}
		}

		for (String s : map.keySet()) {
			sb.append(s).append(" ").append(map.get(s)).append("\n");
		}
		System.out.println(sb);
	}
}