import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		while (!pq.isEmpty()) {
			sb.append(pq.poll() + "\n");
		}

		System.out.println(sb);
	}
}
