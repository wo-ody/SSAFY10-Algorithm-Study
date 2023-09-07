package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class BOJ_1197_최소_스패닝_트리 {

	static int node, edge;
	static int[] parents;
	static ArrayList<Node> nodeList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());


		parents = new int[node+1];
		nodeList = new ArrayList<>();


		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			//from번 정점과 to번 정점이 가중치 cost인 간선으로 연결되어 있다
			nodeList.add(new Node(from,to, cost));
		}

		Collections.sort(nodeList);

		make();

		int sum = 0;
		int cnt = 0;

		for(Node n : nodeList) {
			if(union(n.from, n.to)){
				sum += n.cost;
				cnt++;

				if(cnt==edge-1) break;
			}
		}

		System.out.println(sum);
	}

	private static boolean union(int from, int to) {

		int fromRoot = findSet(from);
		int toRoot = findSet(to);

		if(fromRoot==toRoot) return false;
		else parents[toRoot] = fromRoot;
		return true;
	}

	private static int findSet(int v) {

		if(parents[v]==v) return v;
		else return parents[v] = findSet(parents[v]);
	}

	private static void make() {
		for(int i = 1 ; i <= node ; i++) {
			parents[i] = i;
		}
	}

	static class Node implements Comparable<Node> {
		int from;
		int to;
		int cost;

		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}



		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}


}
