import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int V, answer, targetNode;
	static List<int[]>[] Node;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		Node = new ArrayList[V];
		visited = new boolean[V];
		
		for(int i=0; i<V; i++) {
			Node[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i=0; i<V; i++) {
			st = new StringTokenizer(br.readLine());
			int nowNode = Integer.parseInt(st.nextToken())-1;
			int targetNode = 0;
			while((targetNode = Integer.parseInt(st.nextToken())-1)!= -2) {
				int edge = Integer.parseInt(st.nextToken());
				Node[nowNode].add(new int[] {targetNode, edge});
			}
		}
		
		targetNode = 0;
		answer = 0;
		dfs(0, 0);
		dfs(targetNode, 0);
		
		System.out.println(answer);
	}
	
	static void dfs(int nowNode, int distance) {
		if(answer < distance) {
			answer = distance;
			targetNode = nowNode;
		}
		visited[nowNode] = true;
		int size = Node[nowNode].size();
		for(int i=0; i<size; i++) {
			int nextNode = Node[nowNode].get(i)[0];
			int toNextDistance = distance + Node[nowNode].get(i)[1];
			if(!visited[nextNode])
				dfs(nextNode, toNextDistance);
		}
		visited[nowNode] = false;
	}
}
