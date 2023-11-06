package algorithm2023.oct.day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16509_장군 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static Pos S, K;
	static boolean[][] v = new boolean[10][9];

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	static int[] dy2 = { -1, -1, -1, 1, 1, 1, 1, -1 };
	static int[] dx2 = { -1, 1, 1, 1, 1, -1, -1, -1 };

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
	
	static boolean isValid(int r, int c) {
		if(r<0||c<0||r>=10||c>=9)return false;
		return true;
	}

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		S = new Pos(r, c);

		st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		K = new Pos(r, c);

		Queue<Pos> q = new LinkedList<>();

		q.offer(S);
		v[S.r][S.c] = true;

		int ans = 1;
		boolean isAns =false;

		loop: while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Pos cur = q.poll();
				int cr= cur.r;
				int cc = cur.c;
				for (int d = 0; d < 4; d++) {
					int nr = cr+dy[d];
					int nc = cc+dx[d];
					if(!isValid(nr,nc)||(K.r==nr&&K.c==nc))continue;
					for(int dd = 2*d;dd<2*d+2;dd++) {
						int nr2 = nr+dy2[dd];
						int nc2 = nc+dx2[dd];
						if(!isValid(nr2,nc2)||(K.r==nr2&&K.c==nc2))continue;
						nr2+=dy2[dd];
						nc2+=dx2[dd];
						if(!isValid(nr2,nc2))continue;
						if((K.r==nr2&&K.c==nc2)) {
							isAns = true;
							break loop;
						}
						v[nr2][nc2] = true;
						q.offer(new Pos(nr2,nc2));
					}
				}
			}
			ans++;
		}
		System.out.println(isAns?ans:-1);

	}
}
