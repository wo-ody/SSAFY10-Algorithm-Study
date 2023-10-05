import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int u, v, t;
	static int answer;
	static Edge[] graph;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new Edge[m];
		parents = new int[n + 1];
		answer = 1;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			graph[i] = new Edge(u, v, t);
		}
		Arrays.sort(graph, (o1, o2) -> o1.day - o2.day);
		makeset();
		for(int i = 0; i < n - 1; i++)  // 문제의 제약 조건 -> 탐색 범위 = n - 1
			if(union(graph[i].from, graph[i].to) && graph[i].day == answer)  // 길도 연결 되어있고 현재 시점에서 오픈한 노점이라면
				answer++;
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
	
	static void makeset() {
		for(int i = 1; i <= n; i++) parents[i] = i;
	}
	
	static class Edge {
		int from, to, day;

		Edge(int from, int to, int day) {
			this.from = from;
			this.to = to;
			this.day = day;
		}
	}
}
