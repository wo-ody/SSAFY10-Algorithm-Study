package report;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18223_민준이와마산그리고건우 {
	static int V,E,P,min;
	static int[][] arr;
	static boolean[] visit;
	static boolean check;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());//건우 
	
		arr = new int[V+1][V+1]; //0dummy 1출발 V도착
		visit = new boolean[V+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			arr[a][b] = c;
			arr[b][a] = c;
		}
		
		dijkstra(1);
		
		if(check) {
			System.out.println("SAVE HIM");
		}else {
			System.out.println("GOOD BYE");
		}
		
	}

	static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(o1, o2) -> {
					if(o1[1] == o2[1]) { 
						return o2[2] - o1[2];
					}else {
						return o1[1] - o2[1];
					}
				}); //가중치 값이 같다면 건우를 가진 pq 값을 우선 순위로 주기  
		pq.add(new int[]{start, 0, P==1?1:0}); //건우를 구하면 마지막 값을 올려준다.  
		visit[start] = true;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int node = cur[0];
			visit[node] = true;
			int gunwoo = cur[2];
			
			if(node == V) {
				if(gunwoo == 1) {
					check = true;
					return;
				}else {
					check = false;
					return;
				}
			}
			
			for(int i=1; i<=V; i++) {
				if(arr[node][i] != 0 && !visit[i]) {
					//i가 건우 위치이면 1을 넣어주고 아니라면 원래의 cur[2]를 넣는다. 
					pq.add(new int[] {i, cur[1] + arr[node][i], i==P?1:cur[2]});
				}
			}
		}
	
	}		
}
