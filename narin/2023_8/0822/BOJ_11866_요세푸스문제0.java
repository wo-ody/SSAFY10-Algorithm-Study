import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		sb.append("<");

		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < K - 1; j++) {
				q.offer(q.poll());
			}
			sb.append(q.poll() + ", ");
		}

		sb.append(q.poll() + ">");
		System.out.println(sb);
	}
}
