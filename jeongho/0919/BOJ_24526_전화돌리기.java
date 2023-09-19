package algorithm2023.sep.day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_24526_전화돌리기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, indegree[];
	static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0;i<=N;i++) {
			adjList.add(new ArrayList<>());
		}
		indegree = new int[N+1];
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList.get(b).add(a);
			indegree[a]++;
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int cnt = 0;
		for(int i = 1;i<=N;i++) {
			if(indegree[i]==0) {
				q.add(i);
				cnt++;
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : adjList.get(cur)) {
				if(--indegree[next]==0) {
					q.add(next);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
