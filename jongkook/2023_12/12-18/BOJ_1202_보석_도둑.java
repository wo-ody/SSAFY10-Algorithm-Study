
package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1202_보석_도둑 {
	static int jewerlySize, bagSize;
	static int[] bag;
	//	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static ArrayList<Node> jewerly = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		jewerlySize = Integer.parseInt(st.nextToken());
		bagSize = Integer.parseInt(st.nextToken());
		bag = new int[bagSize];

		for(int i = 0; i < jewerlySize; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			jewerly.add(new Node(weight, cost));
		}
		for(int b = 0; b < bagSize; b++) bag[b]= Integer.parseInt(br.readLine());
		Collections.sort(jewerly);
		Arrays.sort(bag);
		int index = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		long result = 0;
		for(int num : bag){
			while(index < jewerly.size() && num >= jewerly.get(index).weight) pq.add(jewerly.get(index++).cost);
			if(!pq.isEmpty()) result += pq.poll();
		}
		System.out.println(result);
	}

	static class Node implements Comparable<Node>{
		int weight, cost, index;

		public Node() {}

		public Node(int weight, int cost) {
			super();
			this.weight = weight;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [weight=" + weight + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Node o) {
			if(this.weight == o.weight) return o.cost - this.cost;
			return this.weight - o.weight;
		}
	}
}
