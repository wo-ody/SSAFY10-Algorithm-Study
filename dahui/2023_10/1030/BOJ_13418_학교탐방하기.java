package alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_13418_학교탐방하기 {
	static int N,M,diff;
	static int up; //내리막길을 뺀 오르막길 수 
	static long bestFatigue, worstFatigue; //피로도 
	static int[] parents;
	static Node start;
	static ArrayList<Node> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		
		for(int i=0; i<M+1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.add(new Node(from, to, weight));
		}
		
		//오르막이 0 내리막 1 -> 최선의 경로 ( 내리막으로 이루어짐 , weight 내림차순 정렬, )
		//-> 최악의 경로 경로( weigth 오름차순 정렬 )


		//최선의 경로 찾기
		make();
		Collections.sort(list, (o1, o2) -> o2.weight - o1.weight);
		up = 0;
		int count = 0;
		
		for (Node node : list) {
			if(union(node.from, node.to)) {
				if(node.weight == 0) {
					up++;
					if(++count == N) {
						break;
					}
				}
			}
		}
		
		bestFatigue = (long) Math.pow(up, 2);
		
		//최악의 경로 찾기
		make();
		Collections.sort(list, (o1, o2) -> o1.weight - o2.weight);
		up = 0;
		count = 0;
				
		for (Node node : list) {
			if(union(node.from, node.to)) {
				if(node.weight == 0) {
					up++;
					if(++count == N) {
						break;
					}
				}
			}
		}
				
		worstFatigue = (long) Math.pow(up, 2);
				
		System.out.println(worstFatigue - bestFatigue);

	}
	
	public static void make() {
		for(int i=0; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot; 
		return true;
	}
	
	public static class Node{
		int from,to,weight;
		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

}
