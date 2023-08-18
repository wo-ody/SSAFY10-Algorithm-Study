/*
 *  08.18 김창희
 *  BOJ_17836_공주님을구해라!
 *
 *  [풀이]
 *  1. 검을 얻었는지의 유무를 Node에 포합시킨다
 *  2. 0,0부터 m,n까지 한번 구하고 무기위치부터 n,m까지 거리를 구하고 최단거리를 구한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static int n, m, t, INF = Integer.MAX_VALUE;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		int wX = 0, wY = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					wX = i;
					wY = j;
				}
			}
		}

		Node start = new Node(0, 0, false);
		int[][] dist = findRoot(start,0);
		int answer = dist[n-1][m-1];
		
		//그람을 구하기 전에 비용으로 시작해야한다.
		if (dist[wX][wY]!= INF) {
			start= new Node(wX,wY,true);
			dist = findRoot(start,dist[wX][wY]);
			answer =Math.min(answer, dist[n-1][m-1]);
		}                                                                                                                                                                                                               
		
		System.out.println(answer<=t?answer:"Fail");
	}

	public static int[][] findRoot(Node start,int cost) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		int[][] v = new int[n][m];

		q.offer(start);
		for (int i = 0; i < n; i++) Arrays.fill(v[i], INF);
		v[start.x][start.y] = cost;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if(v[node.x][node.y] )
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;

				if (node.cheat || map[nx][ny] != 1) {
					if (v[nx][ny] > v[node.x][node.y] + 1) {
						v[nx][ny] = v[node.x][node.y] + 1;
						q.offer(new Node(nx, ny, node.cheat));
					}
				}
			}
		}

		return v;
	}

	static class Node {
		int x, y;
		boolean cheat;

		public Node(int x, int y, boolean cheat) {
			this.x = x;
			this.y = y;
			this.cheat = cheat;
		}
	}
}
