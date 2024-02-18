package practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1926 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static Queue<Node> q = new ArrayDeque<Node>();
	static int count = 0, width = 0;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(map[i][j] == 1)
					solve(i, j);
		
		System.out.println(count);
		System.out.println(width);
	}
	
	static void solve(int i, int j) {
		int current_width = 0;
		
		if(!visit[i][j]) {
			q.add(new Node(i, j));
			visit[i][j] = true;
			current_width++;
			count++;
		}
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			for (int[] d : direction) {
				int my = current.y + d[0];
				int mx = current.x + d[1];
				if(0 <= my && my < n && 0 <= mx && mx < m && map[my][mx] == 1 && !visit[my][mx]) {
					q.add(new Node(my, mx));
					visit[my][mx] = true;
					current_width++;
				}
			}
		}
		width = Math.max(current_width, width);
	}
	
	static class Node {
		int y, x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
