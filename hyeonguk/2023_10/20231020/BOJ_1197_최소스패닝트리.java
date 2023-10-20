import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int V, E, answer;
	static int[] parent;
	static Edge[] edges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V+1];
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
		
		edges = new Edge[E];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(from, to, cost);
		}
		
		Arrays.sort(edges, (o1, o2) -> {return Integer.compare(o1.cost, o2.cost);});
		
		answer = 0;
		for(int i=0; i<E; i++) {
			int from = edges[i].from;
			int to = edges[i].to;
			int cost = edges[i].cost;
			
			if(find_parent(from) != find_parent(to)){
				union(from, to);
				answer += cost;
			}
		}
		
		System.out.println(answer);

	}
	static class Edge {
		int from, to, cost;
		Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	static int find_parent(int x) {
		if(parent[x]==x) return x;
		return parent[x] = find_parent(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find_parent(x);
		y = find_parent(y);
		
		if(x<y) parent[y] = x;
		else parent[x] = y;
	}
}
