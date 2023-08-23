import java.io.*;
import java.util.*;
public class BOJ_2146_다리만들기 {
	static int n;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {1,-1,0,0}; 
	static int[] dc = {0,0,1,-1}; 
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new boolean[n][n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) map[i][j] = -Integer.parseInt(st.nextToken());
		}
		
		int isl = 1;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (map[i][j]==-1 && !visit[i][j]) makIsl(i, j, isl++);
			}
		}
		
		ans =n*n;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (map[i][j]!=0) {
					visit = new boolean[n][n];
					ans = Math.min(ans, makBrg(i, j, map[i][j]));
				}
			}
		}
		System.out.println(ans);
	} // main
	
	static void makIsl(int i, int j, int isl) {
		map[i][j] = isl;
		visit[i][j] = true;
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {i,j});
		int[] now;
		int nr, nc;
		while (!q.isEmpty()) {
			now = q.poll();
			for (int k=0; k<4; k++) {
				nr = now[0] + dr[k]; nc = now[1] + dc[k];
				if (nr<0 || nc<0 || n<=nr || n<=nc || map[nr][nc] != -1 || visit[nr][nc]) continue;
				map[nr][nc] = isl;
				visit[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
	}
	
	static int makBrg(int i, int j, int isl) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {i,j,0});
		int[] now;
		int nr, nc, nd;
		while (!q.isEmpty()) {
			now = q.poll();
			if (now[2]==ans) return ans;
			for (int k=0; k<4; k++) {
				nr = now[0] + dr[k]; nc = now[1] + dc[k]; nd = now[2]+1;
				if (nr<0 || nc<0 || n<=nr || n<=nc || visit[nr][nc] || map[nr][nc]==isl) continue;
				if (map[nr][nc]!=0) return now[2];
				visit[nr][nc] = true;
				q.add(new int[] {nr, nc, nd});
			}
		}
		return n*n;
	}
}
