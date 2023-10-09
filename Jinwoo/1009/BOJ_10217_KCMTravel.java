import java.util.*;
import java.io.*;
public class BOJ_10217_KCMTravel {
	static char[][] map;
	static boolean[][][] check = new boolean[9][9][10];
	static Deque<int[]> stack = new ArrayDeque<>();
	static boolean flag;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()), N,M,K,u,v,c,d, nc,nd, now[];
		int[][] dp;
		List<List<int[]>> g; // (u, [v, c, d])
		PriorityQueue<int[]> heap; // (v, c, d)
		for (int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			dp = new int[N+1][M+1];
			g = new ArrayList<>();
			heap = new PriorityQueue<>((o1, o2)->o1[2]-o2[2]); // 우선순위 d
			for (int i=0; i<=N; i++) {Arrays.fill(dp[i], Integer.MAX_VALUE); g.add(new ArrayList<>());}
			for (int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				g.get(u).add(new int[] {v, c, d});
			} //input
			
			for (int i=1; i<=N; i++) Collections.sort(g.get(i),(o1,o2)->o1[2]-o2[2]);
			dp[1][0] = 0;
			heap.add(new int[] {1, 0, 0});
			while (!heap.isEmpty()) {
				now = heap.poll(); // [v, c, d]
				if (now[0]==N) break;
				if (dp[now[0]][now[1]]<now[2]) continue;
				
				for (int[] edge : g.get(now[0])) {
					nc = now[1]+edge[1];
					nd = now[2]+edge[2];
					if (nc <= M && nd < dp[edge[0]][nc]) {
						heap.add(new int[] {edge[0], nc, nd});
						for (int i=nc; i<=M; i++) {
							if (dp[edge[0]][i] <= nd) break;
							dp[edge[0]][i] = nd;
						}
					}
				}
			}
			System.out.println(dp[N][M]==Integer.MAX_VALUE? "Poor KCM":dp[N][M]);
		}
	} //main
}
