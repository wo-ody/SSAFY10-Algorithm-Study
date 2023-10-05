package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21736_헌내기는_친구가_필요해 {
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int col, row, count;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new char[col][row];
		visited = new boolean[col][row];
		
		for(int i = 0; i < col; i++) map[i] = br.readLine().toCharArray();
		for(int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
				if(map[i][j] == 'I') {
					bfs(i, j);
					System.out.println(count == 0 ? "TT" : count);
					return;
				}
			}
		}
		
	}
	static void bfs(int y, int x) {
		Queue<Doyeon> queue = new ArrayDeque<>();
		queue.offer(new Doyeon(y, x));
		while(!queue.isEmpty()) {
			Doyeon doyeon = queue.poll();
			int doX = doyeon.x;
			int doY = doyeon.y;
			for(int i = 0; i < 4; i++) {
				int nx = dx[i] + doX;
				int ny = dy[i] + doY;
				if(nx < 0 || ny < 0 || nx >= row || ny >= col || visited[ny][nx] || map[ny][nx] == 'X') continue;
				if(map[ny][nx] == 'P') count++;
				visited[ny][nx] = true;
				queue.offer(new Doyeon(ny, nx));				
			}
		}
		
	}
	static class Doyeon{
		int y, x;

		public Doyeon(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
