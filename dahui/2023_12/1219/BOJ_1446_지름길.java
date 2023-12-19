package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1446_지름길 {
	static int N,D,ans;
	static ArrayList<Node> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if(end-start > weight && end <= D) {
				list.add(new Node(start, end, weight));
			}
		}
		
		ans = Integer.MAX_VALUE;
		
		bfs();
		
		System.out.println(ans);
	}
	
	static void bfs() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[]{0,0});
		
		while(!pq.isEmpty()) {
			int[] n = pq.poll();
			int now = n[0];
			int weight = n[1];
			
			ans = Math.min(ans, D - now + weight);
			
			if(now == D) {
				ans = weight;
				return;
			}
			
			if(now > D) {
				return;
			}
			
			for(int i=0; i<list.size(); i++) {
				Node node = list.get(i);
				
				if(node.s >= now) {
					pq.add(new int[] {node.e, (node.s - now) + node.w + weight});
				}
			}
		}
	}
	
	public static class Node{
		int s,e,w;
		public Node(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}
}
