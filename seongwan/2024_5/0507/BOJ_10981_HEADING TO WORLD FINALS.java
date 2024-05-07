import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static class team {
		String name;
		int score;
		int penalty;

		public team(String name, int score, int penalty) {
			this.name = name;
			this.score = score;
			this.penalty = penalty;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Map<String, team> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String univ = st.nextToken();

			if (!map.containsKey(univ)) {
				map.put(univ,
					new team(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			} else {
				team t = new team(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

				if (map.get(univ).score == t.score ? map.get(univ).penalty > t.penalty :
					map.get(univ).score < t.score) {
					map.put(univ, t);
				}
			}
		}

		List<String> keys = new ArrayList<>(map.keySet());
		keys.sort((e1, e2) -> map.get(e1).score == map.get(e2).score ? map.get(e1).penalty - map.get(e2).penalty
			: map.get(e2).score - map.get(e1).score);

		for (int i = 0; i < K; i++) {
			sb.append(map.get(keys.get(i)).name).append("\n");
		}

		System.out.println(sb);
	}
}