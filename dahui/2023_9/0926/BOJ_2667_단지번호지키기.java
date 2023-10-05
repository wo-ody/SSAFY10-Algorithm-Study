package alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2667_단지번호붙이기 {
	static int N;
	static ArrayList<Integer> cnt = new ArrayList<>(); //각 단지의 집의 수
	static int[][] map;
	static boolean[][] visit;
	static int[][] dydx = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		bfs(0,0);
		Collections.sort(cnt);
		sb.append(cnt.size()).append("\n");

		for(int i: cnt) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);

	}
	
	static void bfs(int y, int x) {
		Deque<Node> q = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					q.add(new Node(i,j));
					visit[i][j] = true;
					int count = 1;
					
					while(!q.isEmpty()) {
						Node now = q.pop();
						int ny = now.y;
						int nx = now.x;
						
						for(int d=0; d<4; d++) {
							int dy = ny + dydx[d][0];
							int dx = nx + dydx[d][1];
							
							if(dy >= 0 && dy < N && dx >= 0 && dx < N 
									&& map[dy][dx] == 1 && !visit[dy][dx]) {
								q.add(new Node(dy,dx));
								visit[dy][dx] = true;
								count++;
							}
						}
					}
					
					cnt.add(count);
				}
			}
		}
	}
	
	public static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
