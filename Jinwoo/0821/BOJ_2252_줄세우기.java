import java.io.*;
import java.util.*;
public class BOJ_2252_줄세우기 {
	static int[] ind;
	static List<List<Integer>> g;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		
		ind = new int[n+1];
		g= new ArrayList<>();
		for (int i=0; i<=n; i++) g.add(new ArrayList<Integer>());
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
			ind[e]++;
			g.get(s).add(e);
		}
		
		Deque<Integer> q = new ArrayDeque<>();
		for (int i=1; i<=n; i++) if (ind[i]==0) q.add(i);
		StringBuilder sb = new StringBuilder();
		int now;
		for (int i=1; i<=n; i++) {
			now = q.pop();
			for (int e: g.get(now)) {
				ind[e]--;
				if (ind[e]==0) q.add(e);
			}
			sb.append(now).append(" ");
		}
		System.out.println(sb);
	}

}
