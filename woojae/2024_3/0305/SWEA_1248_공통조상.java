package practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_1248 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int t;
	static int v, e, node1, node2;
	static int[] parents;  // 부모 정보를 받을 배열
	static ArrayList<Integer>[] childrens;  // 자식 정보를 받을 리스트
	static ArrayList<Integer> node1_parents;  // 노드 1의 부모를 저장할 리스트
	static ArrayList<Integer> node2_parents;  // 노드 2의 부모를 저장할 리스트
	static int common, size;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			node1 = Integer.parseInt(st.nextToken());
			node2 = Integer.parseInt(st.nextToken());
			
			parents = new int[v+1];
			childrens = new ArrayList[v+1];
			node1_parents = new ArrayList<>();
			node2_parents = new ArrayList<>();
			for (int i = 1; i <= v; i++)
                childrens[i] = new ArrayList<Integer>();

			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				parents[child] = parent;  // 자식의 부모를 저장 -> 공통 조상을 찾기 위한 용도
				childrens[parent].add(child);  // 부모의 자식을 저장 -> 공통 노드의 서브 트리 크기를 구하기 위한 용도 -> 인접 리스트 그래프
			}

			find_parents(node1, node1_parents);
			find_parents(node2, node2_parents);
			common = find_common();
			size = 0;
			dfs(common);
			sb.append("#").append(tc).append(" ").append(common).append(" ").append(size).append("\n");
		}
		System.out.println(sb);
	}
	
	static void find_parents(int cur, ArrayList<Integer> temp) {
		while(cur != 0) {  // 탐색이 이루어질수록 루트노드와 가까워지며 마지막 노드는 루트 노드가 저장됨
			temp.add(cur);  // 현재 노드 저장
			cur = parents[cur];  // 현재 노드의 부모를 저장
		}
	}
	
	static int find_common() {
		int idx1 = node1_parents.size()-1;  // 리스트 역순 탐색 -> 루트 노드부터 탐색
		int idx2 = node2_parents.size()-1;
		int target = 0;
		while(idx1 >= 0 && idx2 >= 0) {  // 첫 인덱스까지
			if(node1_parents.get(idx1).equals(node2_parents.get(idx2)))  // 역순으로 출발하여 가장 마지막 공통 노드를 탐색
					target = node1_parents.get(idx1);
			idx1--;
			idx2--;
		}
		return target;
	}
	
	static void dfs(int start) {  // 탐색한 공통 노드의 서브 트리 사이즈 계산
		size++;
		for (int node : childrens[start])
			dfs(node);
	}
}
