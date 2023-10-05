package baekjoon.graph;

import java.util.*;
import java.io.*;

public class BOJ_1260_DFS와_BFS {
	static StringBuilder sb = new StringBuilder();
	static int vertex, edge, start;
	static boolean[] visited;
	static ArrayList<Integer>[] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		vertex = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		map = new ArrayList[vertex+1];
		visited = new boolean[vertex+1];
		for(int i = 0; i <= vertex; i++) map[i] =  new ArrayList<>();
		
		for(int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from].add(to);
			map[to].add(from);
		}
		
		
		for(ArrayList<Integer> v : map) {
			Collections.sort(v);
		}
		
		dfs(start);
		System.out.println();
		visited = new boolean[vertex+1];
		bfs(start);
	}
	static void dfs(int start) {		
		visited[start] = true;
		System.out.print(start + " ");
		for(int forDFS : map[start]) {
			if(!visited[forDFS]) {
				visited[forDFS] = true;
				dfs(forDFS);
			}			
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start] = true;
		while(!queue.isEmpty()) {			
			int x = queue.poll();		
			System.out.print(x + " ");
			for(int forBFS : map[x]) {
				if(!visited[forBFS]) {
					visited[forBFS] = true;
					queue.offer(forBFS);							
				}
			}			
		}
	}
}
