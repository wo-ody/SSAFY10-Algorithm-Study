package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
	static int col, row, height, res;
	static int[][][] tomato;
	static int[] dz = {0, 0, 0, 0, -1, 1}, dy = {-1, 1, 0, 0, 0, 0}, dx = {0, 0, -1, 1, 0, 0};
	static Queue<Node> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		tomato = new int[height][col][row];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < col; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < row; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < col; j++) {
				for(int k = 0; k < row; k++) {
					if(tomato[i][j][k] == 1) queue.offer(new Node(i, j, k));
				}
			}
		}
		bfs();
//		printTomato();	
		System.out.println(isFresh() ? getMax()-1 : -1);
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for(int d = 0; d < 6; d++) {
				int nz = node.z + dz[d]; 
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				if(nz < 0 || ny < 0 || nx < 0 ||
						nz >= height || ny >= col || nx >= row || 
								tomato[nz][ny][nx] != 0) continue;	
				queue.offer(new Node(nz, ny, nx));	
				tomato[nz][ny][nx] = tomato[node.z][node.y][node.x] + 1;
			}
			res++;
		}
	}
	
	static int getMax() {
		int max = Integer.MIN_VALUE;
		for(int[][] two : tomato) {
			for(int[] one : two) {
				for(int o: one)
					max = Math.max(max, o);
			}
		}
		return	max;
	}
	static void printTomato() {
		for(int[][] two : tomato) {
			for(int[] one : two) {
				System.out.println(Arrays.toString(one));
			}
		}
	}
	
	static boolean isFresh() {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < col; j++) {
				for(int k = 0; k < row; k++) {
					if(tomato[i][j][k] == 0) return false;
				}
			}
		}
		return true;
	}
	static class Node{
		int z, y, x;

		public Node(int z, int y, int x) {
			super();
			this.z = z;
			this.y = y;
			this.x = x;
		}
		
	}
}
