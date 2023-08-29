import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int a, b, c;
	static Edge[] grapgh;
	static int[] parents;
	static int max_cost;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		grapgh = new Edge[m];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			grapgh[i] = new Edge(a, b, c);
		}
		parents = new int[n + 1];
		for(int i = 1; i <= n; i++)
			parents[i] = i;
		max_cost = Integer.MIN_VALUE;
		answer = 0;
		
		Arrays.sort(grapgh, (o1, o2)->o1.cost - o2.cost);
		
		for (Edge e : grapgh) {
			if(union(e.from, e.to)) {
				answer += e.cost;
				max_cost = Math.max(max_cost, e.cost);
			}
		}
		answer -= max_cost;
		System.out.println(answer);

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
	
	static class Edge {
		int from, to, cost;
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

}