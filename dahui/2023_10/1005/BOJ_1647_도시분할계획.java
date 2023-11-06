package alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//마을안에서 모든 집이 연결돼있어야 함.
//마을에는 적어도 집이 하나 이상
//분리된 두 마을 사이의 길들은 필요 없으며, 한 마을안에서도 두 집 사이의 경로가 있다면 나머지 길은 필요없음
//길의 유지비의 합을 최소로.
//임의의 두 집 사이의 경로는 항상 존재한다.
//-> 최소스패닝 트리를 찾고나서 가장 큰 가중치 길을 제거하면 최소로 분리가 된다
public class BOJ_1647_도시분할계획 {
	static int N,M; //집 수, 길 수
	static int cnt; //사용된 간선의 개수
	static Edge[] edgeList;
	static int[] parents;
	static long weightSum; //유지비의 합

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[M];
		parents = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(a,b,c);			
		}
		
		//간선리스트를 가중치 기준 오름차순 정렬 -> 가중치가 작은 값부터 사용해야하므로~
		Arrays.sort(edgeList, (e1, e2) -> e1.weight - e2.weight);
		
		make();
		
		for (Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				//싸이클 체크해서 true이면
				weightSum += edge.weight;
				if(++cnt == N-1) {
					//종료전에 마지막 가중치 값 빼주기 -> 마을 분리
					weightSum -= edge.weight;
					break; //연결된 간선 개수가 총 노드 수 - 1 이면 종료
				}
			}
		}
		
		System.out.println(weightSum);
	}
	
	//서로소 집합 만들기 (자기 자신이 부모인)
	static void make() {
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	//부모 노드 찾기
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	//사이클이 발생하면 부분집합을 못만들게
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false; //사이클이 발생하므로 false
		//발생안하면 부분집합 생성
		parents[bRoot] = aRoot;
		return true;
	}
	
	static class Edge {
		int from,to,weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
	}
}
