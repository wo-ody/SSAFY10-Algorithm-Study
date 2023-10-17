package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7465_창용마을무리의개수 {

	static int T, N, M, cnt;
	static boolean[][] adj;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			adj = new boolean[N+1][N+1];
			visit = new boolean[N+1];
			cnt = 0;

			// 인접행렬 입력 받기
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				adj[a][b] = adj[b][a] = true;
			}
			
			// dfs로 무리 개수 알아내기
			for (int y = 1; y <= N; y++) {
				if( visit[y] ) continue; 
				dfs(y);
				cnt++;
			}
			
			
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int y) {
		visit[y] = true;
		for (int x = 1; x <= N; x++) {
			if( adj[y][x] && !visit[x] ) {
				dfs(x);
			}
		}
		
	}

}
