package algorithm2023.aug.day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468 {
	static int N, area[][], maxH, max;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		area= new int[N][N];
		for(int i=0 ;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j= 0;j<N;j++) {
				area[i][j]  =Integer.parseInt(st.nextToken());
				if(area[i][j]>maxH) {
					maxH = area[i][j];					
				}
			}
		}
		for(int i = 0;i<maxH;i++) {
			max = Math.max(max, safe(i));
		}
		System.out.println(max);
	}
	
	static int safe(int h) {
		int cnt =0;
		boolean[][] v = new boolean[N][N];
		for(int i= 0;i<N;i++) {
			for(int j= 0;j<N;j++) {
				if(area[i][j] >h&&!v[i][j]) {
					Queue<Idx> q = new LinkedList<>();
					q.offer(new Idx(i,j));
					v[i][j] = true;
					cnt++;
					while(!q.isEmpty()) {
						Idx idx = q.poll();
						for(int d = 0;d<4;d++) {
							int ny = idx.y+dy[d];
							int nx = idx.x+dx[d];
							if(isValid(ny,nx,h)) {
								if(v[ny][nx])continue;
								q.offer(new Idx(ny,nx));
								v[ny][nx] =true;
							}
						}
					}
				}
			}
		}
		return cnt;
	}
	
	static boolean isValid(int y, int x, int h) {
		if(y<0||x<0||y>=N||x>=N||area[y][x]<=h)return false;
		return true;
	}
	
	static class Idx{
		int y;
		int x;
		public Idx(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
