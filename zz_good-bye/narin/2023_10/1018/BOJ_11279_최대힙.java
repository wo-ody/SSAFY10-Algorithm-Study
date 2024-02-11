import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				if (!heap.isEmpty())
					sb.append(heap.poll()).append("\n");
				else
					sb.append(0).append("\n");
			} else {
				heap.offer(num);
			}
		}

		System.out.println(sb);
	}
}
