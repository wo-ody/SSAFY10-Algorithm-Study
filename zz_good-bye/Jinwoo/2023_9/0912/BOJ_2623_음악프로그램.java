import java.io.*;
import java.util.*;
public class BOJ_2623_음악프로그램 {
	static int[] indeg; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		
		indeg = new int[n+1];
		List<List<Integer>> g = new ArrayList<>();
		for (int i=0; i<=n; i++) g.add(new ArrayList<>());
		for (int a=0; a<m; a++) {
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int s, e = Integer.parseInt(st.nextToken());;
			for (int i=0; i<b-1; i++) {
				s = e; e = Integer.parseInt(st.nextToken());
				g.get(s).add(e);
				indeg[e]++;
			}
		}
		
		boolean[] visit = new boolean[n+1];
		Deque<Integer> q = new ArrayDeque<>();
		for (int i=1; i<=n; i++) {
			if (indeg[i]==0) q.add(i);
		}
		StringBuilder sb = new StringBuilder();
		int now;
		while(!q.isEmpty()) {
			now = q.poll();
			sb.append(now).append("\n");
			visit[now] = true;
			for (int next: g.get(now)) {
				if (--indeg[next]==0) q.add(next);
			}
		}
		for (int i=1; i<=n; i++) {
			if (indeg[i]!=0) { sb = new StringBuilder(); sb.append(0); break;}
			if (!visit[i]) sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

}
