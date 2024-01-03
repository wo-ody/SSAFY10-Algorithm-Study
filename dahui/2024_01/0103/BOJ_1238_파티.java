import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,X,ans; 
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
	
		for(int i=0; i<M+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Node(end, time));
		}
		
		for(int i=1; i<=N; i++) {
			int time = 0;
			time = simulation(i,X) + simulation(X,i);
			ans = Math.max(time, ans);
		}
		
		System.out.println(ans);
	
	}
	
	public static int simulation(int start, int end) {
		Queue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.t - o2.t);
		visit = new boolean[N+1];
		pq.add(new Node(start, 0));
		visit[start] = true;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			visit[n.e] = true;
			if(n.e == end) {
				return n.t;
			}
			
			for(int i=0; i<list.get(n.e).size(); i++) {
				if(!visit[list.get(n.e).get(i).e])
				pq.add(new Node(list.get(n.e).get(i).e, list.get(n.e).get(i).t + n.t));
			}
		}
		
		return 0;
		
	}
	
	public static class Node {
		int e,t;
		public Node (int e, int t) {
			this.e = e;
			this.t = t;
		}
	}

}
