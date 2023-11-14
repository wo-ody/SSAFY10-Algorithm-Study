import java.io.*;
import java.util.*;
public class BOJ_2056_작업 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n], indegree = new int[n];
		List<List<Integer>> g = new ArrayList<>();
		for (int i=0; i<n; i++) g.add(new ArrayList<>());
		StringTokenizer st = new StringTokenizer(br.readLine());
		time[0] = Integer.parseInt(st.nextToken());
		
		int c, bf;
		for (int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			indegree[i] = c;
			for (int j=0; j<c; j++) {
				bf = Integer.parseInt(st.nextToken());
				g.get(bf-1).add(i);
			}
		}
		
		Deque<Integer> q = new ArrayDeque<>();
		for (int i=0; i<n; i++) {
			if (indegree[i]==0) q.add(i);
		}
		int now, before[]=new int[n];
		while (!q.isEmpty()) {
			now = q.poll();
			for (int i : g.get(now)) {
				before[i] = Math.max(before[i], time[now]+before[now]);
				if (--indegree[i] == 0) q.add(i);
			}
		}
		
		int ans=0;
		for (int i=0; i<n; i++) {
			ans = Math.max(ans, time[i]+before[i]);
		}
		System.out.println(ans);
	}
}
