import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int v, e;
	static int a, b, c;
	static Edge[] grapgh;
	static int[] parents;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		grapgh = new Edge[e];
		parents = new int[v + 1];
		answer = 0;
		
		for(int i = 1; i <= v; i++)
			parents[i] = i;
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			grapgh[i] = new Edge(a, b, c);
		}
		Arrays.sort(grapgh, (o1, o2)->o1.cost - o2.cost);
		
		for (Edge e : grapgh) {
			if(union(e.from, e.to))
				answer += e.cost;
		}
		System.out.println(answer);

	}
	
	static class Edge {
		int from, to, cost;
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	static int find(int x) {
		if(parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y)
			return false;
		parents[y] = x;
		return true;
	}

}