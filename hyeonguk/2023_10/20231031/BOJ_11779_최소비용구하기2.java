import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000_001;
	static int N, M, start, destination;
	static int[] distance, cities;
	static boolean[] visited;
	static List<Node>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, cost));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		destination = Integer.parseInt(st.nextToken());
		
		cities = new int[N+1];
		distance = new int[N+1];
		visited = new boolean[N+1];
		for(int i=0; i<=N; i++) {
			distance[i] = INF;
		}
		
		solve();
		
		System.out.println(distance[destination]);
		
		List<Integer> move = new ArrayList<>();
		int now = destination;
		while(now != 0) {
			move.add(now);
			now = cities[now];
		}
		
		System.out.println(move.size());
		for(int i = move.size() - 1; i>=0; i--) {
			System.out.print(move.get(i)+ " ");
		}
	}
	
	static void solve() {
		PriorityQueue<Node> pqueue = new PriorityQueue<>((o1, o2)-> {return o1.cost-o2.cost;});
		
		pqueue.offer(new Node(start, 0));
		distance[start] = 0;
		cities[start] = 0;
		
		while(!pqueue.isEmpty()) {
			Node now = pqueue.poll();
			
			if(visited[now.to]) continue;
			
			visited[now.to] = true;
			
			int len = list[now.to].size();
			for(int i=0; i<len; i++) {
				Node next = list[now.to].get(i);
				
				if(distance[next.to] > distance[now.to] + next.cost) {
					distance[next.to] = distance[now.to] + next.cost;
					pqueue.offer(new Node(next.to, distance[next.to]));
					cities[next.to] = now.to;
				}
			}
			
		}
	}
	
	static class Node{
		int to, cost;
		
		Node(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
	}
}
