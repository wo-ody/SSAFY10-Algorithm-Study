import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		while (true) {
			if (q.size() < K) {
				q.offer(q.poll());
				while (q.size() != 1) {
					q.poll();
				}
				break;
			}

			q.offer(q.poll());

			for (int i = 0; i < K - 1; i++) {
				q.poll();
			}

		}
		System.out.println(q.poll());
	}
}
