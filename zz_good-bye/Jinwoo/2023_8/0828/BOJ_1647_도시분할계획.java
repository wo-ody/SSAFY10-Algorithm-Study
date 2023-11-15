import java.util.*;
import java.io.*;

public class BOJ_1647_도시분할계획 {
	static List<List<int[]>> g;
	static int V, E;
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		g = new ArrayList<>(V+1);
		for (int i=0; i<=V; i++) g.add(new ArrayList<>());
		int s, e, w;
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			g.get(s).add(new int[] {e,w});
			g.get(e).add(new int[] {s,w});
		}
		visit = new boolean[V+1];
		PriorityQueue<int[]> heap = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		heap.add(new int[] {1,0});
		int[] now;
		int ans=0, cnt=0, mw=0;
		while (!heap.isEmpty()) {
			now = heap.poll();
			if (visit[now[0]]) continue;
			visit[now[0]] = true;
			ans += now[1];
			cnt++;
			mw = Math.max(mw, now[1]);
			if (cnt==V) break;
			for (int[] next: g.get(now[0])) {
				if (visit[next[0]]) continue;
				heap.add(next);
			}
		}
		System.out.println(ans-mw);
	}

}
