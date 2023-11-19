package algorithm2023.nov.day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14466_소가길을건너간이유6 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, K, R, cowCnt, ans=0;
	static boolean[][] v, cow;
	static ArrayList<Pos> cowList = new ArrayList<>();
	static ArrayList<Pos>[][] road;
	static ArrayList<Integer> c = new ArrayList<>();
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	static boolean isValid(int y, int x) {
		if(y<1||x<1||y>N||x>N)return false;
		return true;
	}
	
	static class Pos{
		int y,x;

		public Pos(int y, int x) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + "]";
		}

		
		
	}
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		
		//N*N 너비의 농장
		N = Integer.parseInt(st.nextToken());
		// K마리의 소
		K = Integer.parseInt(st.nextToken());
		// R개의 길
		R = Integer.parseInt(st.nextToken());
		
		cow = new boolean[N+1][N+1];
		
		road = new ArrayList[N+1][N+1];
		for(int i =0 ;i<=N;i++) {
			for(int j= 0;j<=N;j++) {
				road[i][j] = new ArrayList<>();
			}
		}
		for(int i = 0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int c1= Integer.parseInt(st.nextToken());
			
			road[r][c].add(new Pos(r1,c1));
			road[r1][c1].add(new Pos(r,c));
		}
		for(int i =0 ;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			cow[r][c] = true;
			cowList.add(new Pos(r,c));
		}
		
		for(int i = 0;i<K;i++) {
			ans+=bfs(i);
		}
		
		
		System.out.println(ans);
		
	}
	
	static int bfs(int idx) {
		int y = cowList.get(idx).y;
		int x = cowList.get(idx).x;
		v = new boolean[N+1][N+1];
		int cnt = 0;
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(y,x));
		v[y][x] = true;
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			dLoop:
			for(int d = 0;d<4;d++) {
				int ny = cur.y+dy[d];
				int nx = cur.x+dx[d];
				if(!isValid(ny,nx)||v[ny][nx])continue;
				//길이 있으면 안가기
				for(Pos p: road[cur.y][cur.x]) {
					if(p.x==nx&&p.y==ny)continue dLoop;
				}
				v[ny][nx] = true;
				q.add(new Pos(ny,nx));
			}
		}
		for(int i =idx+1;i<K;i++) {
			int ny = cowList.get(i).y;
			int nx = cowList.get(i).x;
			if(!v[ny][nx])cnt++;
		}
		return cnt;
	}
}
