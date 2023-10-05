import java.io.*;
import java.util.*;
public class BOJ_1987_알파벳 {
	static char[][] g;
	static boolean[][] visit;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		g = new char[r][c];
		for (int i=0; i<r; i++) {
			g[i] = br.readLine().toCharArray();
		}
		visit = new boolean[r][c];
		System.out.println(dfs(r,c));
	}

	static int dfs(int r, int c) {
		int ans = 1;
		Deque<int[]> q = new ArrayDeque<>();
		q.push(new int[] {0, 0, 1, 1<<(g[0][0]-'A')});
		int[] now;
		int nr, nc;
		while (!q.isEmpty()) {
			now = q.poll();
			if (now[2]==26) return 26;
			ans = Math.max(now[2], ans);
			for (int k=0; k<4; k++) {
				nr = now[0] + dr[k]; nc = now[1] + dc[k];
				if (nr<0 || nc<0 || r<=nr || c<=nc || ((now[3]|1<<(g[nr][nc]-'A')) == now[3])) continue;
				q.push(new int[] {nr, nc, now[2]+1,now[3]|1<<(g[nr][nc]-'A')});
			}
		}
		return ans;
	}
}
