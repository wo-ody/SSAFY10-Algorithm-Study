import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int vertex;
	Node link;

	public Node(int vertex, Node link) {
		super();
		this.vertex = vertex;
		this.link = link;
	}

}

public class Main {
	private static int N, M;
	private static Node[] student;
	private static int[] num;

	private static List<Integer> topologySort() {
		List<Integer> result = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {

			if (num[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			Integer curNode = q.poll();
			result.add(curNode);

			for (Node temp = student[curNode]; temp != null; temp = temp.link) {
				if (--num[temp.vertex] == 0) {
					q.offer(temp.vertex);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		student = new Node[N + 1];
		num = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			student[a] = new Node(b, student[a]);
			num[b]++;
		}

		List<Integer> list = topologySort();
		if (list.size() == N) {
			for (Integer vertex : list) {
				System.out.print(vertex + " ");
			}
			System.out.println();
		}
	}
}
