import java.io.*;
import java.util.*;
public class BOJ_4485_녹옷입애젤 {
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n, tc=0;
		int[][] map;
		while (true) {
			tc++;
			n = Integer.parseInt(br.readLine());
			if (n==0) break;
			map = new int[n][n];
			for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = dijkstra(map, n);
			sb.append("Problem ").append(tc).append(": ");
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static int dijkstra(int[][] map, int n) {
		int[][] dist = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) dist[i][j] = Integer.MAX_VALUE;
		}
		dist[0][0] = map[0][0];
		PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2)->o1[2]-o2[2]);
		heap.add(new int[] {0,0,map[0][0]});
		int now[], nr, nc,nextcost;
		while (!heap.isEmpty()) {
			now = heap.poll();
			if (dist[now[0]][now[1]] < now[2]) continue;
			for (int k=0; k<4; k++) {
				nr = now[0] + dr[k]; nc = now[1] + dc[k]; 
				if (nr<0 || nc<0 || n<=nr || n<=nc) continue;
				nextcost = now[2] + map[nr][nc];
				if (nextcost>= dist[nr][nc]) continue;
				dist[nr][nc] = nextcost;
				heap.add(new int[] {nr, nc, nextcost});
			}
		}
		return dist[n-1][n-1];
	}
}
