package Krusckal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리 {
	static int V, E;
	static int parent[];		//서로소 배열
	static PriorityQueue<Node> pq;	//노드 저장
	
	static class Node{
		int v1, v2, cost;

		public Node(int v1, int v2, int cost) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
	}
	
	static void makeSet() {
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int x) {
		if(x == parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px == py) return false;
		
		if(px < py) parent[py] = px;
		else parent[px] = py;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		//그래프 초기화
		pq = new PriorityQueue<>((e1, e2) -> e1.cost-e2.cost);	//가중치 기준 오름차순
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.add(new Node(v1, v2, cost));
		}
		
		// union-find setting
		parent = new int[V+1];		//0 dummy
		makeSet();
		
		//가중치 낮은 순으로 정점 뽑아내기
		int cnt = 0;		//최소 비용
		while(!pq.isEmpty()) {
			Node e = pq.poll();
			
			//연결
			if(union(e.v1, e.v2)) cnt += e.cost;
		}
		
		System.out.println(cnt);
	}
}
