package algorithm2023.sep.day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2887_행성터널 {
	static int N;
	static ArrayList<Planet> planetX = new ArrayList<>();
	static ArrayList<Planet> planetY = new ArrayList<>();
	static ArrayList<Planet> planetZ = new ArrayList<>();
	static ArrayList<Edge> edge = new ArrayList<>();

	static int parent[];

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

		N = Integer.parseInt(br.readLine());
		parent = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			planetX.add(new Planet(i, x));
			planetY.add(new Planet(i, y));
			planetZ.add(new Planet(i, z));
		}
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		Collections.sort(planetX, (o1, o2) -> o1.pos - o2.pos);
		Collections.sort(planetY, (o1, o2) -> o1.pos - o2.pos);
		Collections.sort(planetZ, (o1, o2) -> o1.pos - o2.pos);


		for(int i = 0;i<N-1;i++) {
			edge.add(new Edge(planetX.get(i).n, planetX.get(i+1).n, planetX.get(i+1).pos-planetX.get(i).pos));
			edge.add(new Edge(planetY.get(i).n, planetY.get(i+1).n, planetY.get(i+1).pos-planetY.get(i).pos));
			edge.add(new Edge(planetZ.get(i).n, planetZ.get(i+1).n, planetZ.get(i+1).pos-planetZ.get(i).pos));
		}
		Collections.sort(edge, (o1,o2)->o1.cost-o2.cost);

		int sum = 0;
		for (int i = 0; i < edge.size(); i++) {
			Edge cur = edge.get(i);
			if (union(cur.a, cur.b)) {
				sum+=cur.cost;
			}
		}
		System.out.println(sum);

	}

	static class Planet {
		int n, pos;

		public Planet(int n, int pos) {
			this.n = n;
			this.pos = pos;
		}
	}

	static class Edge {
		int a;
		int b;
		int cost;

		public Edge(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [a=" + a + ", b=" + b + ", cost=" + cost + "]";
		}

	}
}
