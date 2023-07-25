package studyAuthenticating;

import java.io.*;
import java.util.*;

public class BOJ_2606_바이러스 {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int node, edge, start;
	static int count;
	static Queue<Integer> queue;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		node = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		graph = new ArrayList[node+1];
		visited = new boolean[node+1];
		for(int i = 0; i < node+1; i++){
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int tc = 1; tc <= edge; tc++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			graph[B].add(A);
		}
		
		System.out.println(dfs(1));
	}
	static int dfs(int x){
		visited[x] = true;
		for(int v : graph[x]){
			if(visited[v] != true){
				count++;
				dfs(v);
			}
		}
		return count;
	}
}
