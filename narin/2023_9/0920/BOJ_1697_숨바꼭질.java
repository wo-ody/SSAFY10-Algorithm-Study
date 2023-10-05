import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static int N, K, count;
	private static boolean[] isVisited;

	private static void bfs() {
		isVisited = new boolean[100001];
		Queue<Integer> q = new LinkedList<>();

		q.add(N);

		while (!q.isEmpty()) {

			int size = q.size();
			for (int i = 0; i < size; i++) {
				int p = q.poll();

				if (p == K) {
					System.out.println(count);
					return;
				}

				if (p >= 0 && p <= 100000 && !isVisited[p]) {
					isVisited[p] = true;
					q.add(p - 1);
					q.add(p + 1);
					q.add(p * 2);

				}
			}
			count++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		count = 0;

		bfs();

	}
}
