package algorithm2023.nov.day09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_30464_시간낭비 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, road[],dp[][];
	
	static class Pos{
		int i, cntR, dir, time;
		

		public Pos(int i, int cntR, int dir, int time) {
			super();
			this.i = i;
			this.cntR = cntR;
			this.dir = dir;
			this.time = time;
		}


		@Override
		public String toString() {
			return "Pos [i=" + i + ", cntR=" + cntR + ", dir=" + dir + ", time=" + time + "]";
		}
		
		
		
	}
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		
		road = new int[N];
		
		dp = new int[N][3];
		st = new StringTokenizer(br.readLine());
		for(int i= 0;i<N;i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}
		ArrayDeque<Pos> q = new ArrayDeque<>();
		q.add(new Pos(0,0, 1, 0));
		while(!q.isEmpty()) {
			Pos cur = q.pollLast();if(cur.cntR<2) {
				int i = cur.i+road[cur.i]*(-cur.dir);
				if(i>=0&&i<N&&dp[i][cur.cntR+1]<cur.time+1) {
					dp[i][cur.cntR+1] = cur.time+1;
					if(i!=N-1&&road[i]!=0) {
						q.offer(new Pos(i,cur.cntR+1,-cur.dir,cur.time+1));
					}
				}
			}
			int i=  cur.i+road[cur.i]*cur.dir;
			if(i>=0&&i<N&&dp[i][cur.cntR]<cur.time+1) {
				dp[i][cur.cntR] = cur.time+1;
				if(i!=N-1&&road[i]!=0) {
					q.offer(new Pos(i,cur.cntR,cur.dir,cur.time+1));
				}
			}
			
			
		}
//		for(int i =0;i<N;i++) {
//			System.out.print(dp[i][0]);
//			System.out.print(dp[i][1]);
//			System.out.print(dp[i][2]);
//			System.out.println();
//		}
		int ans= Math.max(dp[N-1][2], dp[N-1][0]);
		System.out.println(ans==0?-1:ans);
	}
}
