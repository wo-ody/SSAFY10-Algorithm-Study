package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_14621_나만안되는연애 {
	static int N,M; //학교수 도로수
	static long ans;
	static int[] parents;
	static char[] gender;
	static ArrayList<Node> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		gender = new char[N+1]; //0 dummy
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			gender[i] = st.nextToken().charAt(0);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			//성별이 다를 때만 list에 넣어주기
			if(gender[from] == gender[to]) continue;
			
			list.add(new Node(from, to, weight));
		}
		
		Collections.sort(list, (o1, o2) -> o1.weight - o2.weight);
		
		make();
		int count = 0;
		
		for (Node node : list) {
			if(union(node.from, node.to)) {
				ans += node.weight;
				if(++count == N-1) {
					break;
				}
			}
		}
		
		if(count == N-1) {
			System.out.println(ans);
		}else{
			System.out.println(-1);;
		}
	}
	
	private static void make() {
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
