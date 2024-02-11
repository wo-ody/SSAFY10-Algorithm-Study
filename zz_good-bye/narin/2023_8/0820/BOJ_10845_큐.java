import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();

			switch (order) {
			case "push":
				q.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (!q.isEmpty()) {
					System.out.println(q.poll());
				} else {
					System.out.println(-1);
				}
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				if (q.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "front":
				if (!q.isEmpty()) {
					System.out.println(q.peek());
				} else {
					System.out.println(-1);
				}
				break;
			case "back":
				if (!q.isEmpty()) {
					for (int i = 0; i < q.size() - 1; i++) {
						int temp = q.poll();
						q.offer(temp);
					}
					System.out.println(q.peek());
					int temp = q.poll();
					q.offer(temp);
				} else {
					System.out.println(-1);
				}
				break;
			}
		}
	}
}
