package boj;

import java.io.*;
import java.util.*;

public class boj_2146_다리만들기{
	static int N;
	static int[][] map;
	
	static int[][] island;
	static ArrayList<Node>[] start;
	static int island_cnt = 0;
	
	static int result;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		island = new int[N][N];
		start = new ArrayList[20000]; // island num 만큼 넣어주기 
		result = Integer.MAX_VALUE;
		for (int i = 0; i < 20000; i++) start[i] = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 함수 시작
		simulation();
		
		System.out.println(result);
		
		
	}
	
	static void BFS(int x, int y, int inum, boolean[][] visited) {
		Queue<Node> q = new ArrayDeque<>();
		
		q.add(new Node(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			island[cur.x][cur.y] = inum;
			
			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(isCango(nx,ny) == false || visited[nx][ny]) continue;
				
				if(map[nx][ny] == 0) {
					start[inum-1].add(new Node(nx,ny));
					continue;
				}
				
				q.add(new Node(nx,ny));
				visited[nx][ny] = true;
			}
		}
	}
	
	static void get_sea() {
		boolean[][] visited = new boolean[N][N];
		
		int cnt = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0 || visited[i][j]) continue;
				BFS(i,j,cnt, visited);
				cnt++;
			}
		}
		
		island_cnt = cnt - 1;
	}
	
	static void start_make_bridge(int x, int y, boolean[][] sea, int island_num) {
		//  sea -> 섬 주위 체크
		// visited -> 경로 체크
		Queue<Node> q = new ArrayDeque<>();
		int[][] visited = new int[N][N];
		
		q.add(new Node(x,y));
		visited[x][y] = 1;
		sea[x][y] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(isCango(nx,ny) == false || visited[nx][ny] > 0) continue;
				if(map[nx][ny] == 0) {
					q.add(new Node(nx,ny));
					visited[nx][ny] = visited[cur.x][cur.y] + 1;
				}
				else {
					if(island[nx][ny] != island_num) {
						// 정답 갱신
						result = Math.min(result, visited[cur.x][cur.y]);
						sea[cur.x][cur.y] = true;
						return;
					}
				}
			}
		}
	}
	
	
	static void make_bridge() {
		boolean[][] visited = new boolean[N][N];
		
		for (int i = 0; i< island_cnt; i++) {
			if(start[i].size() == 0) break;
			for(Node cur : start[i]) {
				if(visited[cur.x][cur.y]) continue;
				start_make_bridge(cur.x, cur.y, visited, i+1);
			}
		}
		
		
	}
	
	static void simulation() {
		// 섬 번호 매기기 1번부터 ! + 바깥 바다 좌표 저장
		get_sea();
		
		// 다리 만들기 시작
		make_bridge();
		
	}
	
	static boolean isCango(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}
	
	static class Node{
		int x,y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
