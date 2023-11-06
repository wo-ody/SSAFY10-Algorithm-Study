import java.io.*;
import java.util.*;
public class BOJ_1937_욕심쟁이판다 {
	static int[][] map, visit;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new int[n][n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans=0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (visit[i][j]>0) continue;
				ans = Math.max(dfs(i,j,n),ans);
			}
		}
		System.out.println(ans);
	}

	static int dfs(int i, int j, int n) {
		if (visit[i][j] > 0) return visit[i][j];
		visit[i][j] = 1;
		for (int k=0; k<4; k++) {
			int nr = i+dr[k], nc = j+dc[k];
			if (nr<0 || nc<0 || n<=nr || n<=nc || map[i][j]>=map[nr][nc]) continue;
			visit[i][j] = Math.max(visit[i][j], dfs(nr, nc, n)+1);
		}
		return visit[i][j];
	}
}
