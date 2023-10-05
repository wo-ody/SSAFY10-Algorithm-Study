package algorithm2023.aug.day30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리만들기2 {

	static int N, M, map[][], distance[][], parent[];
	static boolean visited[][];

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	static ArrayList<Edge> graph = new ArrayList<>();

	static StringBuilder sb;

	static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}

	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if (px == py)
			return false;

		parent[px] = py;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int islN = 1;

		// 섬 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited= new boolean[N][M];
		
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				// 1이라면 -> 섬이라면
				if (map[i][j] == 1&&!visited[i][j]) {
					map[i][j] = islN++;
					makeIsland(i, j);
				}
			}
		}
		
		parent = new int[islN];
		for (int i = 0; i < islN; i++) {
			parent[i] = i;
		}

		distance = new int[islN][islN];

		for (int i = 0; i < islN; i++) {
			Arrays.fill(distance[i], 10);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) {
					for (int d = 0; d < 4; d++) {
						calcDist(i, j, d, map[i][j]);
					}
				}
			}
		}

		for (int i = 1; i < islN; i++) {
			for (int j = i + 1; j < islN; j++) {
				if (distance[i][j] == 10)
					continue;
				graph.add(new Edge(i, j, distance[i][j]));
			}
		}

		Collections.sort(graph, (o1, o2) -> o1.cost - o2.cost);
		int sum = 0;
		boolean[] v = new boolean[islN];
		for (int i = 0; i < graph.size(); i++) {
			Edge cur = graph.get(i);
			if (union(cur.a, cur.b)) {
				v[cur.a] = true;
				v[cur.b] = true;
				sum += cur.cost;
			}
		}
		
		boolean isAns = true;
		
		for(int i= 2;i<islN;i++) {
			if(find(i-1)!=find(i)) {
				isAns = false;
				break;
			}
		}
		
		System.out.println(isAns?sum:-1);
	}
	
	static void makeIsland(int y, int x) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(y,x));
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int d = 0;d<4;d++) {
				int ny = cur.y+dy[d];
				int nx = cur.x+dx[d];
				
				if(!isValid(ny,nx))continue;
				if(visited[ny][nx])continue;
				if(map[ny][nx] ==0)continue;
				q.offer(new Node(ny,nx));
				map[ny][nx] = map[y][x];
				visited[ny][nx] =true;
			}
		}
	}

	static void calcDist(int y, int x, int d, int start) {
		y += dy[d];
		x += dx[d];
		int dist = 0;
		while (isValid(y, x)) {
			if (map[y][x] == start)
				return;
			if (map[y][x] > 0) {
				if (dist < 2)
					return;
				int next = map[y][x];
				distance[start][next] = Math.min(distance[start][next], dist);
				distance[next][start] = distance[start][next];
				return;
			}
			y += dy[d];
			x += dx[d];
			dist++;
		}
	}

	static boolean isNumbered(int y, int x) {
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (isValid(ny, nx)) {
				if (map[ny][nx] != 0) {
					map[y][x] = map[ny][nx];
					return true;
				}
			}
		}
		return false;
	}

	static boolean isValid(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= M)
			return false;
		return true;
	}

	static class Edge {
		int a;
		int b;
		int cost;

		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [a=" + a + ", b=" + b + ", cost=" + cost + "]";
		}

	}
	
	static class Node{
		int y;
		int x;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		
	}
}
