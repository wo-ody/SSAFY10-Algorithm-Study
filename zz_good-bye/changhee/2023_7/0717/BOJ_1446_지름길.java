/*
 *  0717_백준_1446_지름길_김창희
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), d=  Integer.parseInt(st.nextToken());
		List<List<Node>> graph =  new ArrayList<>();
		int[] dist =new int[d+1];
		
		for(int i =0; i<d+1; i++) {
			dist[i] = i;
			graph.add(new ArrayList<>());
		}
		
		for(int i =0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken()),y=Integer.parseInt(st.nextToken()),cost=Integer.parseInt(st.nextToken());
			if(x>d || y>d) continue;
			graph.get(x).add(new Node(y,cost));
		}
		
		for(int i =0; i<d+1; i++) {
			if(i>0) dist[i] = Math.min(dist[i],dist[i-1]+1);
			for(Node node: graph.get(i)) {
				if(dist[node.x] > dist[i]+node.cost) {
					
					dist[node.x] = dist[i]+node.cost;
				}
			}
		}
		
		System.out.println(dist[d]);
		
	}
	static class Node{
		int x, cost;

		public Node(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
		
	}

}
