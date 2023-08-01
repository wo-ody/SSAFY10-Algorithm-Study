import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	static int node, edge, start;
	static PriorityQueue<Node> pq; 
	static ArrayList<Node>[] map;
	static boolean[] visited;
	static int[] dist;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		map = new ArrayList[node+1];
		for(int i = 0; i < node+1; i++)  map[i] = new ArrayList<>();
		dist = new int[node+1];
		visited = new boolean[node+1];
		
		for(int in = 0; in < edge; in++) {
			StringTokenizer forSt = new StringTokenizer(br.readLine(), " ");
			int v = Integer.parseInt(forSt.nextToken());
			int e = Integer.parseInt(forSt.nextToken());
			int w = Integer.parseInt(forSt.nextToken());
			map[v].add(new Node(e,w));
		}
		dijkstra(start);
		for(int v = 1; v < dist.length; v++) {
			if(dist[v] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[v]);
		}
	}
	
	static void dijkstra(int start) {		
		Arrays.fill(dist, INF);
		dist[start] = 0;
		pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));
		while(!pq.isEmpty()) {
			int nowNode = pq.poll().edge;
			
			if(visited[nowNode]) continue;
			visited[nowNode] = true;
			for(Node nextNode : map[nowNode]) {
				if(dist[nextNode.edge] > dist[nowNode] + nextNode.weight) {
					dist[nextNode.edge] = dist[nowNode] + nextNode.weight;
					pq.offer(new Node(nextNode.edge, dist[nextNode.edge]));
				}
			}
		}
	}
	
}

class Node implements Comparable<Node>{
	int edge, weight;

	public Node(int edge, int weight) {
		super();
		this.edge = edge;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return weight - o.weight;
		}
	}
	
