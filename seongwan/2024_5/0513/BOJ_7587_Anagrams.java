import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		HashMap<String, String> name = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			String ans = null;
			for (int i = 0; i < N; i++) {
				String origin = br.readLine();
				char[] temp = origin.toCharArray();

				Arrays.sort(temp);
				String sorted = new String(temp);

				if (!map.containsKey(sorted)) {
					map.put(sorted, 1);

					name.put(sorted, origin);
				} else {
					map.put(sorted, map.get(sorted) + 1);
				}

				if (ans == null)
					ans = sorted;

				else {
					if (map.get(sorted) > map.get(ans))
						ans = sorted;
				}
			}
			sb.append(name.get(ans)).append(" ").append(map.get(ans) - 1).append("\n");
		}
		System.out.println(sb);
	}
}