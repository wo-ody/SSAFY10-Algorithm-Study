import java.util.*;
import java.io.*;

public class BOJ_1197_최소스패닝트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int V, E;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		String[] st = br.readLine().split(" ");
		V=Integer.parseInt(st[0]);
		E=Integer.parseInt(st[1]);
		PriorityQueue<Edge> heap = new PriorityQueue<>();
		for (int i=0; i<E; i++) {
			Edge edge = new  Edge(br.readLine().split(" "));
			heap.add(edge);
		}
		parent = new int[V+1];
		for (int i=0; i<V+1; i++) parent[i] = i;
		int ans=0;
		int cnt=0;
		while (!heap.isEmpty()) {
			Edge edge = heap.poll();
			if (!union(edge.s, edge.e)) continue;
			ans += edge.cost;
			cnt++;
			if (cnt==V-1) break;
		}
		bw.write("" + ans);
		bw.flush();
	}
	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x==y) return false;
		parent[Math.max(x, y)] = Math.min(x, y);
		return true;
	}
	
	public static int find(int x) {
		int xx = parent[x];
		while (xx!=parent[xx]) xx = parent[xx];
		return xx;
	}
}

class Edge implements Comparable<Edge> {
	int s, e, cost;
	public Edge(String[] st) {
		this.s = Integer.parseInt(st[0]);
		this.e = Integer.parseInt(st[1]);
		this.cost = Integer.parseInt(st[2]);
	}
	
	@Override
	public int compareTo(Edge edge) {
		return this.cost - edge.cost;
	}
}
