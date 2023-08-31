package algorithm2023.aug.day31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색_옷_입은_애가_젤다지 {
	static int N, cave[][];
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	static StringBuilder sb = new StringBuilder();
	
	static boolean isValid(int y, int x) {
		if(y<0||x<0||y>=N||x>=N)return false;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input;
		int t = 1;
		while((input=Integer.parseInt(br.readLine()))!=0) {
			N = input;
			cave = new int[N][N];
			for(int i =0;i<N;i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for(int j= 0;j<N;j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("Problem ").append(t++).append(": ").append(dijkstra()).append("\n");
		}
		System.out.println(sb);
	}
	
	static int dijkstra() {
		int[][] dijk = new int[N][N];
		for(int i =0;i<N;i++) {
			Arrays.fill(dijk[i], Integer.MAX_VALUE);
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
		dijk[0][0] = cave[0][0];
		pq.add(new Edge(0,0,cave[0][0]));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			for(int d = 0;d<4;d++) {
				int ny = cur.y+dy[d];
				int nx = cur.x+dx[d];
				if(!isValid(ny,nx))continue;
				int next = cur.cost+cave[ny][nx];
				if(dijk[ny][nx]>next) {
					dijk[ny][nx] = next;
					pq.add(new Edge(ny,nx,next));
				}
			}
		}
		for(int i =0;i<N;i++) {
			System.out.println(Arrays.toString(dijk[i]));
		}
		System.out.println();
		return dijk[N-1][N-1];
	}
	
	static class Edge{
		int y;
		int x;
		int cost;
		
		public Edge(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
		
		
	}
}
