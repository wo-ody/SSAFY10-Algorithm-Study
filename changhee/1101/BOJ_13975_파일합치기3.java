import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();

		PriorityQueue<Long> q = new PriorityQueue<>((o1, o2) -> Long.compare(o1, o2));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			long result = 0;
			q.clear();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				q.offer(Long.parseLong(st.nextToken()));
			}

			while (q.size() > 1) {
				long v1 = q.poll();
				long v2 = q.poll();

				result += v1 + v2;
				q.offer(v1 + v2);
			}

			answer.append(result).append("\n");
		}
		System.out.println(answer);
	}
}
