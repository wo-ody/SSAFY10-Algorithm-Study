package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17472_다리만들기2 {
	static int N,M;
	static int[][] map;
	
	// 섬 
	static boolean[][] visited;
	static int island_cnt;
	static ArrayList<Node>[] island;
	static int[][] island_map;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	
	// 인접그래프
	static ArrayList<Node> adj;
	
	// MSt
	static int[] parent;
	
	static int result = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		island = new ArrayList[8];
		for (int i = 0; i < 8; i++) island[i] = new ArrayList<>();
		island_map = new int[N][M];
		
		simulation();
		
		System.out.println(result);
		
	}
	
	static void start_numbering(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		
		q.add(new Node(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			island[island_cnt].add(cur);
			island_map[cur.x][cur.y] = island_cnt; 
			
			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				if(isCango(nx,ny) == false || map[nx][ny] == 0 || visited[nx][ny]) continue;
				q.add(new Node(nx,ny));
				visited[nx][ny] = true;
			}
		}
	}
	
	static void island_numbering() {
		island_cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j] || map[i][j] == 0) continue;
				start_numbering(i,j);
				island_cnt++;
			}
		}
	}
	
	static void make_graph(int num) {
		for(Node cur: island[num]) {
			// 다리 만들기 == 가중치
			for (int k = 0; k < 4; k++) {
				int x = cur.x;
				int y = cur.y;
				int cnt = 0;
				while(true) {
					x += dx[k];
					y += dy[k];
					cnt++;
					if(isCango(x, y) == false) break;
					if(map[x][y] == 1) {
						if(island_map[x][y] != (num) && cnt - 1 >= 2) {
							int other = island_map[x][y];
							adj.add(new Node(num,other, cnt - 1));
							//adj[other].add(new Node(num, cnt - 1));
						}
						break;
					}
				}
			}
			
		}
	}
	
	static int findSet(int v) {
		if(parent[v] == v) return v;
		else return parent[v] = findSet(parent[v]);
	}
	
	static void union(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		
		parent[pa] = pb;
	}
	
	static void kruskal() {
		boolean[] chk = new boolean[island_cnt + 1];
		
		Collections.sort(adj,(o1,o2)->o1.z - o2.z);
		
		for(Node cur : adj) {
			if(findSet(cur.x) != findSet(cur.y)) {
				union(cur.x , cur.y);
				result += cur.z;
				chk[cur.x] = true;
				chk[cur.y] = true; 
			}
		}
		
		int num = findSet(1);
		for (int i = 2; i < island_cnt; i++) {
			if(num != findSet(i)) {
				result = -1;
				return;
			}
		}
	}
	
	static void simulation() {
		// 섬 번호 매기기
		island_numbering();
		
		// 인접 리스트 만들기
		adj = new ArrayList<>();
		
		for (int i = 1; i <= island_cnt; i++) {
			make_graph(i);
		}
		
		// MST 구하기
		parent = new int[island_cnt + 1];
		for (int i = 0; i <= island_cnt; i++) parent[i] = i;
		kruskal();
		
		
	}
	
	static boolean isCango(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}
	
	static class Node{
		int x,y,z;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		Node(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	
	
	

}
