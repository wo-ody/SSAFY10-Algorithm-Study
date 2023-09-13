import java.io.*;
import java.util.*;

public class BOJ_2637_장난감조립 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[] indegree = new int[n+1];
		int[] outdegree = new int[n+1];
		
		List<List<node>> g = new ArrayList<>();
		for (int i=0; i<=n; i++) g.add(new ArrayList<>());
		int s, e, w; node next;
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			next = new node(e, w);
			g.get(s).add(next);
			indegree[s]++;
			outdegree[e]++;
		}
		
		Deque<node> q = new ArrayDeque<>();
		q.add(new node(n, 1));
		int[] cnt = new int[n+1];
		cnt[n] = 1;
		node now;
		
		while (!q.isEmpty()) {
			now = q.poll();
			for (node x : g.get(now.e)) {
				outdegree[x.e]--;
				cnt[x.e] += x.w*cnt[now.e];
				if (outdegree[x.e]==0) {
					q.add(new node(x.e, cnt[x.e]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=n; i++) if (indegree[i]==0) sb.append(i).append(" ").append(cnt[i]).append("\n");
		System.out.println(sb);
	}
	
	static class node{
		int e, w;
		public node(int e, int w){
			this.e = e; this.w = w;
		}
	}

}
