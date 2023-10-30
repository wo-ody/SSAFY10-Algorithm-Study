package BOJ;

import java.io.*;
import java.util.*;

public class boj_13418_학교탐방하기 {
	static int N,M;
	static ArrayList<Node> graph;
	
	static int[] parent;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i < M+1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.add(new Node(a,b,c));
		}
		
		System.out.println(simulation());
	}
	
	static void init() {
		parent = new int[N+1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int v) {
		if(parent[v] == v) return v;
		return parent[v] = find(parent[v]);
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		parent[pa] = pb;
	}
	
	static int simulation() {
		init();
		Collections.sort(graph,(o1,o2)->o1.c - o2.c);
		
		int cnt = 0;
		for(Node cur: graph) {
			if(find(cur.a) != find(cur.b)) {
				union(cur.a, cur.b);
				if(cur.c == 0) cnt++;
			}
		}
		
		int maxR = cnt*cnt;
		
		init();
		Collections.sort(graph,(o1,o2)->o2.c - o1.c);
		
		cnt = 0;
		for(Node cur: graph) {
			if(find(cur.a) != find(cur.b)) {
				union(cur.a, cur.b);
				if(cur.c == 0) cnt++;
			}
		}
		
		int minR = cnt*cnt;
		
		return maxR - minR;
	}
	
	static class Node{
		int a,b,c;
		Node(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

}
