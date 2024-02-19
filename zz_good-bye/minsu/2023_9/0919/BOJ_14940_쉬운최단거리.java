package bj.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940_쉬운최단거리 {
	static int N, M, sx, sy; // 행, 열의 길이, 목표지점의 좌표값
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int s = Integer.parseInt(st.nextToken());
				if (s == 2) {
					sx = i;
					sy = j;
					map[i][j] = 0;
				} else if (s == 1) {
					map[i][j] = -1;
				}
			}
		}
		
		bfs(sx, sy);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void bfs(int x, int y) {
		visited = new boolean[N][M];
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(x, y));
		visited[x][y] = true;
		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int cx = cur.x;
			int cy = cur.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				
				if (!visited[nx][ny] && map[nx][ny] != 0) {
					visited[nx][ny] = true;
					map[nx][ny] = map[cx][cy] + 1;
					queue.offer(new Node(nx, ny));
				}
			}
		}
		
	}
	
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
	}
}

