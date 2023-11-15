import java.io.*;
import java.util.*;
public class Main {
	static int mod=1_000_000_007;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] dist = new int[n+1];
		Arrays.fill(dist, (int)Math.pow(10, 9));
		
		PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);
		
		List<List<Integer>> g = new ArrayList<>();
		for (int i=0; i<=n; i++) g.add(new ArrayList<>());
		int s, e;
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			g.get(s).add(e);
			g.get(e).add(s);
		}
		
		heap.add(new int[] {1, 0});
		dist[1]=0;
		int[] now;
		while(!heap.isEmpty()) {
			now = heap.poll();
			if (dist[now[0]] < now[1]) continue;
			
			for (int next : g.get(now[0])) {
				if (dist[next] > now[1] +1) {
					dist[next] = now[1] +1;
					heap.add(new int[] {next, now[1]+1});
				}
			}
		}
		int[] dc = new int[n+1];
		for (int i=1; i<=n; i++) {
			if (dist[i]<=n) dc[dist[i]]++;
		}
		
		long ans = 1;
		for (int i=0; i<=n; i++) {
			if (dc[i]>0) {
				ans *= dc[i]+1;
				ans %= mod;
			}
		}
		System.out.println(ans-1);
	}

}
