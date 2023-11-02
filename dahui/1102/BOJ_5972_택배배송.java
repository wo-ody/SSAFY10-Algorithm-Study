package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_5972_택배배송 {
	static int N,M;
	static int[] feed;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		
		feed = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}
		
		Arrays.fill(feed, INF);
		dijk(1);
		System.out.println(feed[N]);
	}
	
	static void dijk(int start) {
		feed[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.n;
			if(feed[now] < node.w)continue;
			for(int i=0; i<list.get(now).size(); i++) {
				int cost = feed[now] + list.get(now).get(i).w;
				if(cost < feed[list.get(now).get(i).n]) {
					feed[list.get(now).get(i).n] = cost;
					pq.add(new Node(list.get(now).get(i).n, cost));
				}
			}
		}
	}
	
	
	public static class Node{
		int n,w;
		public Node(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}
}
