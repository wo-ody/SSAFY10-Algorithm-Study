package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	static int col, row, max, dx[] = {-1,1,0,0}, dy[] = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		max = Integer.MIN_VALUE;
		map = new int[col][row];
		
		
		for(int c = 0; c < col; c++) {
			st = new StringTokenizer(br.readLine());
			for(int r = 0; r < row; r++) {
				map[c][r] = Integer.parseInt(st.nextToken());
			}
		}
		setWalls(0);
		System.out.println(max);
	}
	
	static void setWalls(int wall) {		
		if(wall == 3) {
			bfs();
			return;
		}
		
		for(int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					setWalls(wall + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	static void bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		int[][] virus = new int[col][row];
		for(int c = 0; c < col; c++) {
			for(int r = 0; r < row; r++) {
				virus[c][r] = map[c][r];
				if(virus[c][r] == 2) queue.offer(new Node(c, r));
			}
		}
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for(int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				if(ny < 0 || nx < 0 || ny >= col || nx >= row || virus[ny][nx] != 0) continue;
				virus[ny][nx] = 2;
				queue.offer(new Node(ny, nx));
			}
		}
		
		int count = 0;
		
		for(int c = 0; c < col; c++) {
			for(int r = 0; r < row; r++) {				
				if(virus[c][r] == 0) count++;
			}
		}
		
		max = Math.max(max, count);
		
	}
	
	
	static void printMap() {
		for(int[] c : map) {
			System.out.println(Arrays.toString(c));
		}
	}
	
	static class Node{
		int y, x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}		
	}

}
