import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	private static int[] parent;
	private static int[] level;

	private static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}

	private static int union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
			level[a] += level[b];

			// b의 부모는 언제나 a. 초기화
			level[b] = 1;
		}

		return level[a];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int F = Integer.parseInt(br.readLine());

			parent = new int[F * 2];
			level = new int[F * 2];

			for (int i = 0; i < F * 2; i++) {
				parent[i] = i;
				level[i] = 1;
			}

			HashMap<String, Integer> map = new HashMap<>();
			int index = 0;

			for (int f = 0; f < F; f++) {
				st = new StringTokenizer(br.readLine());

				String name1 = st.nextToken();
				String name2 = st.nextToken();

				if (!map.containsKey(name1)) {
					map.put(name1, index++);
				}

				if (!map.containsKey(name2)) {
					map.put(name2, index++);
				}

				int result = union(map.get(name1), map.get(name2));

				sb.append(result).append("\n");

			}

		}

		System.out.println(sb);
	}
}
