import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1922_네트워크연결 {
	static int N,M;
	static int[][] graph;
	
	static int[] parent;
	
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new int[M][3];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}
		
		simulation();
		System.out.println(result);
		
	}
	
	static void makeSet() {
		parent = new int[N+1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(parent[x] == x) return x;
		return parent[x] = findSet(parent[x]);
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		parent[px] =py; // ######################
	}
	
	static void simulation() {
		makeSet();
		
		Arrays.sort(graph, (o1,o2) -> o1[2] - o2[2]); // cost 기준으로 오름차순 정렬
		
		for (int i = 0; i < M; i++) {
			if(findSet(graph[i][0]) != findSet(graph[i][1])) {
				union(graph[i][0], graph[i][1]);
				result += graph[i][2];
			}
		}
	}

}
