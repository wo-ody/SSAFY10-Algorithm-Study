import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_11725_트리의부모찾기 {
	static int N;
	static ArrayList<Integer>[] graph;
	
	static boolean[] visited;
	static int[] result;
	
	public static void DFS(int cur) {
		
		for (int nx : graph[cur]) {
			if(visited[nx]) continue;
			result[nx] = cur; // 부모 노드 넣어주기
			visited[nx] = true;
			DFS(nx);
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		result = new int[N+1];
		for (int i = 1; i <= N; i++) 
			graph[i] = new ArrayList<>();
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		visited[1] = true;
		DFS(1);
		
		for (int i = 2; i <= N; i++) {
			System.out.println(result[i]);
		} 
	}

}
