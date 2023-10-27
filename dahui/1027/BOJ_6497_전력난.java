package alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//짧은 길로 모든 집들이 서로 연결 되어있어야한다.
//총 길의 수가 m-1 
//미터 수만큼 돈이 들어간다. 
//테스트 케이스 수가 안 주어지고 입력의 끝에서 0 0 이 들어온다. 
//출력 값은 절약할 수 있는 최대 액수

public class BOJ_6497_전력난 {
	static int m,n; //집수, 길수
	static long sum,ans,cost; //모든 길의 비용, 절약되는 최대비용 , 쓰이는 비용;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static ArrayList<Node> adjList = new ArrayList<>();
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			if(m == 0 && n ==0) break;
			
			adjList.clear();
			sum = 0;
			ans = 0;
			cost = 0;
			parents = new int[m];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				sum += weight;
				
				adjList.add(new Node(from, to, weight));
			}
			
			Collections.sort(adjList, (o1, o2) -> o1.weight - o2.weight);
			
			make();
			
			int cnt = 0;
			for(Node node : adjList) {
				if(union(node.from, node.to)) {
					cost += node.weight;
					if(++cnt == m-1) {
						sb.append(sum - cost).append("\n");
						break;
					}
				}
			}
		}
		
		System.out.println(sb);
	}
	
	public static void make() {
		for(int i=0; i<m; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) { //각 노드의 부모 노드 찾기 
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	//사이클이 발생하는지 안하는지 확인하고 발생하면 부분집합 못 만들게 false 
	public static boolean union(int a , int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot; return true;
	}
	
	public static class Node{
		int from, to, weight;
		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

}
