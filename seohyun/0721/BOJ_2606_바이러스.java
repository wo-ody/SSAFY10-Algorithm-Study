import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_2606_바이러스 {
	static int N,E;
	static LinkedList<Integer>[] lst;
	static boolean[] visited;
	
	static int result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		lst = new LinkedList[N+1];
		visited = new boolean[N+1];
		for(int i=0;i<=N;i++) lst[i] = new LinkedList<Integer>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			lst[from].add(to);
			lst[to].add(from);
		}
		
		
		//DFS 함수
		DFS(1);
		System.out.println(result-1); // 1번은 뺴주기
		
	}
	public static void DFS(int node) {
		visited[node] = true;
		result += 1;
		
		for (int i = 0; i < lst[node].size(); i++) {
			int nxt = lst[node].get(i);
			if(visited[nxt]) continue;
			DFS(nxt);
			
		}
	}

}
