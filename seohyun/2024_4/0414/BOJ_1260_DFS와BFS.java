import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,V;
	static LinkedList<Integer>[] graph ;
	static boolean[] visited ;

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		graph = new LinkedList[N+1];
		for (int i = 0; i <= N; i++) graph[i] = new LinkedList<Integer>();
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
			
		}
		
		//인접리스트 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		//dfs
		DFS(V);
		
		//방문배열 초기화
		visited = new boolean[N+1];
		sb.append("\n");
		
		//bfs
		BFS(V);
		
		//정답 출력
		System.out.println(sb);
		
	}
	public static void DFS(int node) {
		sb.append(node + " ");
		visited[node] = true;
		
		for(int i = 0; i < graph[node].size(); i++) {
			int nxt_node = graph[node].get(i);
			if(visited[nxt_node] == false)
				DFS(nxt_node);
		}
	}
	public static void BFS(int node) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(node);
		sb.append(node + " ");
		visited[node] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0;i<graph[cur].size();i++) {
				int nxt = graph[cur].get(i);
				if(visited[nxt]) continue;
				q.add(nxt);
				sb.append(nxt + " ");
				visited[nxt] = true;
			}
		}
	}

}
