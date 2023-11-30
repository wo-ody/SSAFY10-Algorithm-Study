import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static int N, M, X, ans;
	private static List<Node>[] town;
	private static int[] go, back;
	private static boolean[] isVisited;
	private static int INF = 100_00_01;

	private static void dijkstra(int start, int[] arr) {
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		isVisited = new boolean[N + 1];

		q.add(new Node(start, 0)); // start to start = 0
		arr[start] = 0;

		while (!q.isEmpty()) {
			Node now = q.poll();

			isVisited[now.vertex] = true;

			for (int i = 0; i < town[now.vertex].size(); i++) {

				Node next = town[now.vertex].get(i);
				if (!isVisited[next.vertex] && arr[next.vertex] > now.weight + next.weight) {
					arr[next.vertex] = now.weight + next.weight;
					q.add(new Node(next.vertex, arr[next.vertex]));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		town = new ArrayList[N + 1];
		go = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			town[i] = new ArrayList<>();
		}

		Arrays.fill(go, INF);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());

			town[u].add(new Node(v, T));
		}

		dijkstra(X, go);
		ans = -10;
		for (int i = 1; i <= N; i++) {
			back = new int[N + 1];
			Arrays.fill(back, INF);
			dijkstra(i, back);

//			System.out.println(Arrays.toString(back));

			if (ans < go[i] + back[X]) {
				ans = go[i] + back[X];
			}
		}

//		System.out.println(Arrays.toString(go));
//		System.out.println(Arrays.toString(back));

		System.out.println(ans);

	}

	static class Node {
		int vertex, weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}

}
