/*
 *  08.29 김창희
 *  BOJ_10423_전기가부족해
 *
 *  [풀이]
 *  1. 한대 이상 존재할 수 있는 발전기와 이어지기만 하면 된다.
 *  2. 하지만 발전기랑 이어졌는지 판단하기가 어렵다
 *  3. 발전기들끼리 union한다음 크루스칼로 최소비용을 구하면 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static List<Node> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st =new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		parent=new int[n+1];
		graph =new ArrayList<>();
		
		st=new StringTokenizer(br.readLine());
		
		for(int i =0; i<n+1; i++) parent[i] =i;
		
		int temp = Integer.parseInt(st.nextToken());
		for(int i =1; i<k; i++) {
			int x = Integer.parseInt(st.nextToken());
			union(parent[temp], parent[x]);
			temp = x;
		}
		
		for(int i =0; i<m; i++) {
			st=new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.add(new Node(x,y,cost));
		}
		
		Collections.sort(graph,(o1,o2)->Integer.compare(o1.cost, o2.cost));
		int answer = kruskal();
		System.out.println(answer);
	}
	
	public static int kruskal() {
		int reuslt = 0;
		for(Node node : graph) {
			if(findParent(node.x)!=findParent(node.y)) {
				union(node.x,node.y);
				reuslt += node.cost;
			}
		}
		return reuslt;
	}
	
	public static void union(int x, int y) {
		x=findParent(x);
		y=findParent(y);
		
		if(x>y) parent[x] = y;
		if(x<y) parent[y] = x;
	}
	
	public static int findParent(int x) {
		if(parent[x] == x) return x;
		return parent[x] = findParent(parent[x]);
	}
	static class Node{
		int x, y, cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}
