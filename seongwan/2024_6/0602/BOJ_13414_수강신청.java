import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static class apply {
		String num;
		int ver;

		public apply(String num, int ver) {
			this.num = num;
			this.ver = ver;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int K, L;
	static StringBuilder sb = new StringBuilder();
	static Map<String, Integer> version = new HashMap<>();
	static Deque<apply> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		for (int i = 0; i < L; i++) {
			String temp = br.readLine();

			// 버전관리
			if (version.containsKey(temp))
				version.put(temp, version.get(temp) + 1);
			else
				version.put(temp, 1);

			queue.add(new apply(temp, version.get(temp)));
		}

		int cnt = 0;

		while (!queue.isEmpty()) {
			if (cnt == K)
				break;

			apply temp = queue.poll();
			String key = temp.num;
			int ver = temp.ver;

			if (version.get(key) == ver) {
				sb.append(key).append("\n");
				cnt++;
			}
		}

		System.out.println(sb);
	}
}