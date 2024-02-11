import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = 0;

		Deque<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {

			int target = Integer.parseInt(st.nextToken());
			int count = 0;

			while (q.peekFirst() != target) {
				q.offer(q.poll());
				count++;
			}

			result += Math.min(count, q.size() - count);
			q.poll();
		}

		System.out.println(result);

	}
}
