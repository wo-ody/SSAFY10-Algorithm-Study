package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_4485_녹색옷입은애가젤다지 {
	static int N;
	static int[][] map;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) {
				System.out.println(sb);
				return;
			}
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		
			sb.append("Problem ").append(tc++).append(": ").append(dijkstra()).append("\n");
		}

	}
	
	static int dijkstra() {
		int[][] d = new int[N][N];
		boolean[][] chk = new boolean[N][N];
		for (int i = 0; i < N; i++) Arrays.fill(d[i], Integer.MAX_VALUE);
		int result = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.cost - o2.cost);
		pq.add(new Node(0,0,map[0][0]));
		d[0][0] = map[0][0];
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.x == N-1 && cur.y == N-1) {
				result = cur.cost;
				break;
			}
			
			if(chk[cur.x][cur.y]) continue;
			chk[cur.x][cur.y] = true;
			
			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				if(isCango(nx,ny) == false || chk[nx][ny]) continue;
				if(d[nx][ny] > d[cur.x][cur.y] + map[nx][ny]) {
					int cost = d[cur.x][cur.y] + map[nx][ny];
					d[nx][ny] = cost;
					pq.add(new Node(nx,ny,cost));
				}
				
			}
		}
		
		return result;
		
	}
	
	static boolean isCango(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}
	
	static class Node{
		int x, y, cost;
		Node(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}

}
