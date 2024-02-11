import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> name = new HashMap<>();
		PriorityQueue<String> result = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			name.put(br.readLine(), 1);
		}

		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			if (name.containsKey(temp)) {
				result.offer(temp);
			}
		}

		sb.append(result.size() + "\n");
		while (!result.isEmpty()) {
			sb.append(result.poll() + "\n");
		}

		System.out.println(sb);

	}
}
