package algorithm2023.oct.day27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11967_불켜기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	
	static int N,M, max;
	//스위치가 들어있는 곳 저장
	static ArrayList<Switch>[][] farm;
	//불이 켜진 장소 저장
	static boolean[][] light;
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	
	//스위치가 켤 수 있는 위치를 저장
	static class Switch{
		int a,b;

		public Switch(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		
	}
	
	
	static boolean isValid(int y , int x) {
		if(y<=0||x<=0||y>N||x>N)return false;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		farm = new ArrayList[N+1][N+1];
		light = new boolean[N+1][N+1];
		
		for(int i = 0;i<=N;i++) {
			for(int j = 0;j<=N;j++) {
				farm[i][j] = new ArrayList<>();
			}
		}
		
		for(int i =0 ;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			farm[x][y].add(new Switch(a,b));
		}
		
		//입력 종료
		
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{1,1});
		//1,1(시작점)은 불이 켜져있음.
		light[1][1] = true;
		boolean[][] v = new boolean[N+1][N+1];
		//방문 배열
		v[1][1] = true;
		boolean isLightOn = false;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			
			for(int d= 0;d<4;d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				//불이 켜져있지 않다면 패스
				if(!isValid(ny,nx)||!light[ny][nx])continue;
				//이미 방문했어도 패스
				if(v[ny][nx])continue;
				//방문 처리 및 큐에 삽입
				v[ny][nx] = true;
				q.offer(new int[] {ny,nx});
			}
			
			
			if(!farm[y][x].isEmpty()) {
				//현재위치의 스위치 탐색
				for(Switch s : farm[y][x]) {
					//아직 불을 켜지 않은 곳이라면 불을 켜고 
					if(!light[s.a][s.b]) {
						light[s.a][s.b]= true; 
						//불을 켰다고 기록
						isLightOn = true;
					}
				}
			}
			
			
			
		}
		//불을 켠 기록이 있는 경우 bfs 한번 더 수행
		if(isLightOn) {
			return bfs();
		}
		return count();
	}
	
	static void dfs(int y, int x) {
		if(!farm[y][x].isEmpty()) {
			for(Switch s : farm[y][x]) {
				light[s.a][s.b]= true; 
			}
		}
		
		max = Math.max(max, count());
		print();
		
		for(int d= 0;d<4;d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(!isValid(ny,nx)||light[ny][nx])continue;
			light[ny][nx] = true;
			dfs(ny,nx);
			light[ny][nx] = false;
			
		}
		
	}
	
	static int count() {
		int cnt = 0;
		for(int i =1;i<=N;i++) {
			for(int j =1;j<=N;j++) {
				if(light[i][j]) {
					cnt++;
				}
			}	
		}
		return cnt;
	}
	
	static void print() {
		for(int i =1;i<=N;i++) {
			System.out.println(Arrays.toString(light[i]));
		}
		System.out.println();
	}
}
