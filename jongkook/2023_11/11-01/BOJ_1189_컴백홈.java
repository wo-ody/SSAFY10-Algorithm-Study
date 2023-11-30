package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1189_컴백홈 {
	static int col, row, dist, count = 1, result;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		dist = Integer.parseInt(st.nextToken());
		
		map = new char[col][row];
		visited = new boolean[col][row];
		
		for(int c = 0; c < col; c++) map[c] = br.readLine().toCharArray();
		visited[col-1][0] = true;
		dfs(col-1, 0);
		System.out.println(result);
	}
	static void printMap() {
		for(int c = 0; c < col; c++) System.out.println(Arrays.toString(map[c]));
	}
	
	static void dfs(int y, int x) {
		if(y == 0 && x == row - 1) {
			if(count == dist) {
				result++;
				return;
			}
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(ny < 0 || nx < 0 || ny >= col || nx >= row ||
					visited[ny][nx] || map[ny][nx] == 'T') continue;
			visited[ny][nx] = true;
			count++;
			dfs(ny, nx);
			visited[ny][nx] = false;
			count--;
		}
	}
}
