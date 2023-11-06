package algorithm2023.oct.day26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * Union-Find 사용
 * 전체 간선을 union-find 
 * 이후 여행 경로에 대해 union을 한번 더 수행해 연결되어 있는지 확인.
 * 연결되어 있지 않아 union 함수가 false를 반환했다면 NO 출력, 이미 모두 연결되어 있다면 YES출력
*/

public class BOJ_1976_여행가자 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	//도시의 수 N, 여행 계획에 속한 도시들의 수 M
	static int N, M;
	//간선들을 저장한 배열
	static ArrayList<Edge> edges = new ArrayList<>();
	
	static int[] parent;
	
	//union-find
	static int find(int x) {
		if(parent[x]== x )return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px==py)return false;
		if(px>py) {
			parent[py] = px;
		}else {
			parent[px] = py;			
		}
		return true;
	}
	
	//간선 정보
	static class Edge{
		int u,v;

		public Edge(int u, int v) {
			super();
			this.u = u;
			this.v = v;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
	
		//union-find를 위한 parent 배열 초기화
		parent = new int[N+1];
		for(int i= 1;i<=N;i++) {
			parent[i] = i;
		}
		
		
		for(int i= 1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<=N;j++) {
				if(st.nextToken().equals("1")) {
					edges.add(new Edge(i,j));
				}
			}
		}
		//입력 종료
		
		
		
		//모든 간선에 대해 union-find ( 연결된 도시끼리 모두 union해서 find값을 맞춰줌.)
		for(Edge e : edges) {
			union(e.u,e.v);
		}
		
		
		//각 여행지끼리 union -> 이미 연결된 경우 false반환, true를 반환한 경우 불가능한 여행 경로
		st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		boolean flag = true;
		for(int i = 1;i<M;i++) {
			int v=  Integer.parseInt(st.nextToken());
			if(union(u,v)) {
				flag = false;
				break;
			}
			u = v;
		}
		System.out.println(flag?"YES":"NO");
		
	}
}
