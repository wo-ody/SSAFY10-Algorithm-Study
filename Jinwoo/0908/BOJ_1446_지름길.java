import java.io.*;
import java.util.*;
public class BOJ_1446_지름길 {

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		int d= Integer.parseInt(st.nextToken());
		
		List<List<int[]>> E = new ArrayList<>();
		int[] dist = new int[d+1];
		for (int i=0; i<=d; i++) {
			E.add(new ArrayList<>());
			dist[i] = i;
		}
		for (int i=0; i<d; i++) E.get(i).add(new int[] {i+1, 1});
		int s, e, w;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			s =Integer.parseInt(st.nextToken());
			e =Integer.parseInt(st.nextToken());
			w =Integer.parseInt(st.nextToken());
			if (e>d) continue;
			E.get(s).add(new int[] {e,w});
		}
		
		PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);
		heap.add(new int[] {0,0});
		int now[];
		while (!heap.isEmpty()) {
			now = heap.poll();
			if (now[1]>dist[now[0]]) continue;
			for (int[] edge: E.get(now[0])) {
				if (edge[1]+now[1]>dist[edge[0]]) continue;
				heap.add(new int[] {edge[0], edge[1]+now[1]});
				dist[edge[0]] = edge[1]+now[1];
			}
		}
		System.out.println(dist[d]);
	} // main
}
