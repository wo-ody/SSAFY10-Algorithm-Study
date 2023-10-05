package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_1922_네트워크연결 {
	static int N,M;
	
	static int[] parent;
	static ArrayList<Node> graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		graph = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.add(new Node(a,b,c));
		}
		
		System.out.println(kruskal());
	}
	
	static int kruskal() {
		int result = 0;
		
		// 초기화
		for (int i = 0; i <= N; i++) parent[i] = i;
		
		// graph 길이만큼
		Collections.sort(graph,(o1,o2)->o1.c - o2.c);
		
		for(Node cur : graph) {
			if(find(cur.a) != find(cur.b)) {
				union(cur.a , cur.b);
				result += cur.c;
			}
		}
		
		return result;
	}
	
	
	static int find(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		parent[pa] = pb;
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
