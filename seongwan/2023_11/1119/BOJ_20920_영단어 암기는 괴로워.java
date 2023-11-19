import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (s.length() >= M) {
				if (map.containsKey(s)) {// 이미 나왔던 단어인 경우
					map.put(s, map.get(s) + 1);
				} else// 새로운 단어
					map.put(s, 1);
			}
		}

		List<String> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet,
				(e1, e2) -> map.get(e1) == map.get(e2)
						? (e1.length() == e2.length() ? e1.compareTo(e2) : e2.length() - e1.length())
						: map.get(e2) - map.get(e1));

		for (int i = 0; i < keySet.size(); i++) {
			sb.append(keySet.get(i) + "\n");
		}
		System.out.println(sb);
	}
}