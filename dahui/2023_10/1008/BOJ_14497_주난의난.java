package report;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14497_주난의난 {
	static int N,M,count;
	static int[] junan;
	static int[] criminal;
	static int[][] classRoom;
	static boolean[][] visit;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		junan = new int[2];
		criminal = new int[2];
		st = new StringTokenizer(br.readLine());
		junan[0] = Integer.parseInt(st.nextToken())-1;
		junan[1] = Integer.parseInt(st.nextToken())-1;
		criminal[0] = Integer.parseInt(st.nextToken())-1;
		criminal[1] = Integer.parseInt(st.nextToken())-1;
		
		classRoom = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				if(i==junan[0]&&j==junan[1]) {
					classRoom[i][j] = 2;//주난이 칸은 2
				}else if(i==criminal[0]&&j==criminal[1]) {
					classRoom[i][j] = 3;//범인 칸은 3 
				}else {
					classRoom[i][j] = str.charAt(j) - '0';
				}
			}
		}
		
		dijk(junan[0], junan[1]);
		
		System.out.println(count);
		
	}
	
	static void dijk(int y, int x) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->
			o1[2] - o2[2]
		);
		
		while(true) {
			count++;
			visit = new boolean[N][M];
			pq.add(new int[]{y,x,classRoom[y][x]});
			visit[y][x] = true;
			while(!pq.isEmpty()) {
				int[] cur = pq.poll();
				int cy = cur[0];
				int cx = cur[1];
				int num = cur[2];
				visit[cy][cx] = true;
				
				if(num==1 || num==3) {
					classRoom[cy][cx] = 0;
				}else {
					for(int d=0; d<4; d++) {
						int ny = cy + dy[d];
						int nx = cx + dx[d];
						
						if(ny<0 || nx<0 || ny>=N || nx>=M || visit[ny][nx]) continue;
						pq.add(new int[] {ny,nx,classRoom[ny][nx]});
					}
				}
			}
			if(visit[criminal[0]][criminal[1]])return;
		}
	}

}
