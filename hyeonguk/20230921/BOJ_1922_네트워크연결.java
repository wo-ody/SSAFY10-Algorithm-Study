import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer;
	static boolean[] visited;
	static List<int[]>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new int[] {end, cost});
			list[end].add(new int[] {start, cost});
		}
		
		prim(1);
		System.out.println(answer);

	}
	
	static void prim(int startNode) {
		visited[startNode] = true;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2)-> {
			return Integer.compare(o1[1], o2[1]);
		});
		
		int size = list[startNode].size();
		for(int i=0; i<size; i++) {
			int endNode = list[startNode].get(i)[0];
			int cost = list[startNode].get(i)[1];
			pq.offer(new int[] {endNode, cost});
		}
		
		int ans = 0;
		
		while(!pq.isEmpty()) {
			int[] items = pq.poll();
			int node = items[0];
			int cost = items[1];
			
			if(visited[node]) continue;
			
			visited[node] = true;
			
			answer += cost;
			
			int length = list[node].size();
			for(int i=0; i<length; i++) {
				int next = list[node].get(i)[0];
				int value = list[node].get(i)[1];
				pq.offer(new int[] {next, value});
			}
		}
	}
}
