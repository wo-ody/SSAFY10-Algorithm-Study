/*
 *	08.08 김창희
 *	BOJ_1937_욕심쟁이판다
 *	
 *	욕심부리면 살쪄..
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][] dist;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dist = new int[n][n];
		
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				answer = Math.max(answer, dfs(i,j));
			}
		}
		
		System.out.println(answer);

	}

	public static int dfs(int x, int y) {
		if(dist[x][y]!=0) {
			return dist[x][y];
		}		
		dist[x][y]=1;
		
		for(int i =0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0||ny<0||nx>=n||ny>=n) continue;
			
			if(map[x][y] < map[nx][ny])	dist[x][y] = Math.max(dist[x][y], dfs(nx,ny)+1);
		}
		
		return dist[x][y];
	}
}
