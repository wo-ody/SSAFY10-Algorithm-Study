package algorithm2023.dec.day20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_6497_전력난 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb =new StringBuilder();
	
	
	static int n, m;
	
	static ArrayList<ArrayList<Edge>> edge = new ArrayList<>();
	
	
	static class Edge{
		int to, cost;

		public Edge(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
		
	}
	
	
	public static void main(String[] args) throws Exception{
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if(m==0&&n==0)break;
			edge = new ArrayList<>();
			for(int i = 0;i<m;i++) {
				edge.add(new ArrayList<>());
			}
			
			int max = 0;
			
			for(int i =0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				max+=z;
				
				edge.get(x).add(new Edge(y,z));
				edge.get(y).add(new Edge(x,z));
			}
			PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
			boolean[] v =new boolean[m];
			
			pq.add(new Edge(0,0));
			while(!pq.isEmpty()) {
				Edge cur = pq.poll();
				if(!v[cur.to]) {
					v[cur.to]= true;
					max-=cur.cost;
					for(Edge e : edge.get(cur.to)) {
						pq.add(e);
					}
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
		
		
	}
}