/**
 * 7.21 김창희
 * 백준_3055_탈출
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<Node> godo = new LinkedList<>();
	static Queue<Node> water = new LinkedList<>();
	static int[] dx = {-1,0,1,0}, dy= {0,1,0,-1};
	static char[][] map;
	static int n,m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == '*')
					water.offer(new Node(i, j, 0));
				if (map[i][j] == 'S')
					godo.offer(new Node(i, j, 0));
			}
		}
		
		int[][] info = setWaterTime();
		
		int answer = goToSafeZone(info);
		System.out.println(answer==-1?"KAKTUS":answer);
	}
	
	public static int[][] setWaterTime(){
		int[][] result = new int[n][m];
		
		while(!water.isEmpty()) {
			Node node = water.poll();
			
			for(int i =0; i<4; i++) {
				int nx = node.x+dx[i];
				int ny = node.y+dy[i];
				
				if(nx<0||ny<0||nx>=n||ny>=m) continue;
				
				if( map[nx][ny] == '.') {
					map[nx][ny] = '*';
					result[nx][ny] = node.cost+1;
					water.offer(new Node(nx,ny,node.cost+1));
				}
			}
			
		}
		return result;
	}
	
	public static int goToSafeZone(int[][] info){
		boolean[][] v= new boolean[n][m];
		
		while(!godo.isEmpty()) {
			Node node = godo.poll();
			
			if(map[node.x][node.y] == 'D') return node.cost;
			for(int i =0; i<4; i++) {
				int nx = node.x+dx[i];
				int ny = node.y+dy[i];
				
				if(nx<0||ny<0||nx>=n||ny>=m) continue;
				
				if(!v[nx][ny] && (map[nx][ny]=='D'||map[nx][ny]=='.'|| (map[nx][ny]=='*' && info[nx][ny] > node.cost+1))) {
					v[nx][ny] = true;
					godo.offer(new Node(nx,ny,node.cost+1));
				}
			}
			
		}
		return -1;
	}

	static class Node {
		int x, y, cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}
