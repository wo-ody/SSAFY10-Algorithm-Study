package bj.G5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {
	static int N, K; // 수빈이의 위치 N, 동생의 위치 K
	static boolean[] visited = new boolean[100001];
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs(N);
		
		System.out.println(min);
	
	}
	
	static void bfs(int x) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(x, 0));
		visited[x] = true;
		
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			
			if (cur.end == K) {
				min = Math.min(min, cur.time);
			}
			
			if (cur.end * 2 <= 100000 && visited[cur.end * 2] == false) {
				visited[cur.end * 2] = true;
				queue.offer(new Point(cur.end * 2, cur.time));
			}
			
			if (cur.end - 1 >= 0 && visited[cur.end - 1] == false) {
				visited[cur.end - 1] = true;
				queue.offer(new Point(cur.end - 1, cur.time + 1));
			}
			
			if (cur.end + 1 <= 100000 && visited[cur.end + 1] == false) {
				visited[cur.end + 1] = true;
				queue.offer(new Point(cur.end + 1, cur.time + 1));
			}
		}
	}
	
	static class Point {
		int end, time;
		
		public Point(int end, int time) {
			this.end = end;
			this.time = time;
		}
	}
}








