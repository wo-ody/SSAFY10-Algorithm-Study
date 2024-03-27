import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14284_간선이어가기2 {
	static int n, m, s, t, ans;
	static ArrayList<ArrayList<int[]>> edge = new ArrayList<>();
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= n; i++) {
			edge.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			edge.get(from).add(new int[]{to,v});
			edge.get(to).add(new int[]{from,v});
		}
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		visit = new boolean[n+1];
		simulation();
		System.out.println(ans);

	}

	public static void simulation() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[]{s, 0});

		while(!pq.isEmpty()){
			int[] node = pq.poll();
			int n = node[0];
			int v = node[1];

			if (n == t) {
				ans = v;
				return;
			}

			visit[n] = true;

			for (int i = 0; i < edge.get(n).size(); i++) {
				int to = edge.get(n).get(i)[0];
				if (!visit[to]) {
					pq.add(new int[]{to, v+edge.get(n).get(i)[1]});
				}
			}
		}


	}
}
