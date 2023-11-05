import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> ppq = new PriorityQueue<>();
		PriorityQueue<Integer> mpq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {

			int num = Integer.parseInt(br.readLine());

			if (num > 0) {
				ppq.offer(num);
			} else if (num < 0) {
				mpq.offer(num);
			} else {
				if (ppq.isEmpty() && mpq.isEmpty())
					sb.append(0).append("\n");
				else if (ppq.isEmpty())
					sb.append(mpq.poll()).append("\n");
				else if (mpq.isEmpty())
					sb.append(ppq.poll()).append("\n");
				else {
					int plus = Math.abs(ppq.peek());
					int minus = Math.abs(mpq.peek());

					if (plus > minus) {
						sb.append(mpq.poll()).append("\n");
					} else if (plus < minus) {
						sb.append(ppq.poll()).append("\n");
					} else {
						sb.append(mpq.poll()).append("\n");
					}
				}
			}
		}

		System.out.println(sb);
	}
}
